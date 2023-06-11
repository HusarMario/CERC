package p124;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static ArrayList<Variable> variables = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/p124/input.txt"));


        boolean single = true;

        String input;
        while ((input = bufferedReader.readLine()) != null) {

            if (single) {
                single = false;
            } else {
                System.out.println();
            }

            for (int i = 0; i < input.length(); i = i + 2) {
                variables.add(new Variable(input.charAt(i)));
            }

            input = bufferedReader.readLine();
            for (int i = 0; i < input.length(); i = i + 4) {
                for (Variable out : variables) {
                    for (Variable in : variables) {
                        if ((out.getName() == input.charAt(i)) && (in.getName() == input.charAt(i + 2))) {
                            out.vstupDo(in);
                            in.vystupZ(out);
                        }
                    }
                }
            }

            variables.sort(Comparator.comparing(Variable::getName));

            /*for (Variable variable : variables) {
                System.out.println(variable.getName());

                System.out.println("Outs:");
                for (Variable out : variable.getVystupne()) {
                    System.out.println(out.getName());
                }

                System.out.println("Ins:");
                for (Variable in : variable.getVstupne()) {
                    System.out.println(in.getName());
                }

                System.out.println();
            }*/

            for (Variable variable : variables) {
                if (variable.getVstupne().isEmpty()) {
                    variable.setAble(true);
                    //System.out.println(variable.getName());
                }
            }

            for (Variable variable : variables) {
                if (variable.isAble()) {
                    control(variable, "");
                }
            }

            variables.clear();
        }
    }

    public static void control (Variable variable, String out) {
        String appended = out + variable.getName();
        variable.setFound(true);

        if (appended.length() == variables.size()) {
            System.out.println(appended);
            variable.setFound(false);
            return;
        }

        for (Variable outs : variable.getVystupne()) {
            outs.setAble(true);
            for (Variable ins : outs.getVstupne()) {
                if (!ins.isFound()) {
                    outs.setAble(false);
                    break;
                }
            }
        }

        for (Variable var : variables) {
            if ((var.isAble()) && (!var.isFound())) {
                control(var, appended);
            }
        }

        variable.setFound(false);
        for (Variable outs : variable.getVystupne()) {
            outs.setAble(false);
        }
    }

    public static class Variable {
        private final char name;
        private final ArrayList<Variable> vstupne;
        private final ArrayList<Variable> vystupne;
        private boolean found;
        private boolean able;

        public Variable(char name) {
            this.name = name;
            this.vstupne = new ArrayList<>();
            this.vystupne = new ArrayList<>();
            this.found = false;
            this.able = false;
        }

        public void vstupDo(Variable variable) {
            this.vystupne.add(variable);
        }

        public void vystupZ(Variable variable) {
            this.vstupne.add(variable);
        }

        public char getName() {
            return name;
        }

        public ArrayList<Variable> getVstupne() {
            return vstupne;
        }

        public ArrayList<Variable> getVystupne() {
            return vystupne;
        }

        public void setFound(boolean found) {
            this.found = found;
        }

        public void setAble(boolean able) {
            this.able = able;
        }

        public boolean isFound() {
            return found;
        }

        public boolean isAble() {
            return able;
        }
    }
}
