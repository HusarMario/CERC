package p10003;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(new File("src/p10003/input.txt"));

        while (scanner.hasNext()) {
            int lenOfStick = scanner.nextInt();
            if (lenOfStick == 0) {
                break;
            }
            int numOfCuts = scanner.nextInt();

            ArrayList<Integer> cuts = new ArrayList<>();
            TreeMap<Integer,ArrayList<Integer>> lengths = new TreeMap<>();

            cuts.add(0);
            lengths.put(0,new ArrayList<>());

            for (int i = 0; i < numOfCuts; i++) {
                int number = scanner.nextInt();
                cuts.add(number);
                lengths.put(number,new ArrayList<>());
            }

            cuts.add(lenOfStick);
            lengths.put(lenOfStick,new ArrayList<>());

            for (int i = 1; i < cuts.size(); i++) {
                for (int j = 0; j+i < cuts.size(); j++) {
                    ArrayList<Integer> current = lengths.get(cuts.get(j));

                    if (i == 1) {
                        current.add(0);
                        continue;
                    }

                    if (i == 2) {
                        current.add(cuts.get(j+i) - cuts.get(j));
                        continue;
                    }

                    int distance = cuts.get(j+i) - cuts.get(j);
                    int k = 1;
                    int addition = Integer.MAX_VALUE;
                    while (k < i) {
                        int possible = 0;
                        possible += lengths.get(cuts.get(j)).get(k-1);
                        possible += lengths.get(cuts.get(j+k)).get(i-k-1);
                        if (possible < addition) {
                            addition = possible;
                        }
                        k++;
                    }
                    distance += addition;
                    current.add(distance);
                }
            }

            System.out.printf("The minimum cutting is %d.\n", lengths.get(0).get(lengths.get(0).size()-1));

            /*for (int i = 0; i < cuts.size(); i++) {
                System.out.println(cuts.get(i) + " : " + lengths.get(cuts.get(i)));
            }*/
        }

    }


}
