package exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Loto {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean first = true;
        while (true) {

            String input = bufferedReader.readLine();
            if (input.charAt(0) == '0') {
                break;
            } else {
                if (!first) {
                    System.out.println();
                }
            }


            int k;
            if (input.charAt(1) != ' ') {
                k = Integer.parseInt("" + input.charAt(0) + input.charAt(1));
                input = input.substring(3);
            } else {
                k = Integer.parseInt("" + input.charAt(0));
                input = input.substring(2);
            }

            String[] inputs = input.split(" ");
            ArrayList<Integer> set = new ArrayList<>();
            for (String string : inputs) {
                set.add(Integer.parseInt(string));
            }

            showAllPossibilities(set, 0, new ArrayList<Integer>());
            first = false;
        }
    }

    private static void showAllPossibilities(ArrayList<Integer> set, int index, ArrayList<Integer> possibleSet) {

        for (int i = index; i < set.size(); i++) {
            possibleSet.add(set.get(i));
            showAllPossibilities(set, ++index, possibleSet);
            if (possibleSet.size() == 6) {
                int j = 0;
                for (Integer integer : possibleSet) {
                    j++;
                    System.out.print(integer);
                    if (j < 6) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            possibleSet.remove(set.get(i));
        }


    }
}
