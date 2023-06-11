package p336;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Variable> variables = new ArrayList<>();
    public static int counter = 0;

    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(new File("src/p336/input.txt"));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            variables.clear();
            int numOfConnections = scanner.nextInt();
            if (numOfConnections == 0) {
                break;
            }

            for (int i = 0; i < numOfConnections; i++) {
                Variable first = null;
                Variable second = null;

                int firstInput = scanner.nextInt();
                int secondInput = scanner.nextInt();

                for (Variable variable : variables) {
                    if (variable.name == firstInput) {
                        first = variable;
                    }
                    if (variable.name == secondInput) {
                        second = variable;
                    }
                    if (first != null && second != null) {
                        break;
                    }
                }

                if (first == null) {
                    first = new Variable(firstInput);
                    variables.add(first);
                }

                if (firstInput != secondInput) {
                    if (second == null) {
                        second = new Variable(secondInput);
                        variables.add(second);
                    }

                    first.makeConnection(second);
                    second.makeConnection(first);
                }


            }

            /*for (Variable variable : variables) {
                System.out.println(variable.name);
                for (Variable var : variable.connections) {
                    System.out.println(var.name);
                }
                System.out.println();
            }*/

            while (true) {
                int first = scanner.nextInt();
                int second = scanner.nextInt();

                if (first == 0 && second == 0) {
                    break;
                }

                counter++;

                for (Variable variable : variables) {
                    variable.found = false;
                }

                Variable start = null;
                for (Variable variable : variables) {
                    if (variable.name == first) {
                        start = variable;
                        break;
                    }
                }

                if (start == null) {
                    System.out.printf("Case %d: %d nodes not reachable from node %s with TTL = %s.\n", counter, variables.size(), first, second);
                    continue;
                }

                if (second == 0) {
                    System.out.printf("Case %d: %d nodes not reachable from node %s with TTL = %s.\n", counter, variables.size() - 1, first, second);
                    continue;
                }

                ArrayList<Variable> reached = new ArrayList<>();
                ArrayList<Variable> reachable = new ArrayList<>();
                reached.add(start);

                for (int j = 0; j < second; j++) {
                    for (Variable variable : reached) {
                        if (!variable.found){
                            for (Variable var : variable.connections) {
                                if (!reachable.contains(var) && (!reached.contains(var))) {
                                    reachable.add(var);
                                }
                            }
                        }
                        variable.found = true;
                    }

                    reached.addAll(reachable);
                    reachable.clear();
                }

                System.out.printf("Case %d: %d nodes not reachable from node %s with TTL = %s.\n", counter, variables.size() - reached.size(), first, second);

            }
        }
    }

    public static class Variable {
        private final int name;
        private final ArrayList<Variable> connections;
        private boolean found;

        public Variable(int name) {
            this.name = name;
            this.connections = new ArrayList<>();
            this.found = false;
        }

        public void makeConnection(Variable variable) {
            this.connections.add(variable);
        }
    }
}
