package p620;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/p620/input.txt" + "")));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < k; i++) {
            String celluar = bufferedReader.readLine();

            if (valid(celluar)) {
                if (celluar.length() == 1) {
                    System.out.println("SIMPLE");
                    continue;
                }

                if (celluar.charAt(celluar.length()-1) == 'B') {
                    System.out.println("FULLY-GROWN");
                } else {
                    System.out.println("MUTAGENIC");
                }
            } else {
                System.out.println("MUTANT");
            }
        }
    }

    public static boolean valid(String cell) {
        if (cell.length() == 0) {
            return false;
        }

        if (cell.length() == 1) {
            return cell.charAt(0) == 'A';
        }

        if (cell.charAt(cell.length()-1) == 'B') {
            if (cell.charAt(cell.length()-2) == 'A') {
                String shortened = cell.substring(0,cell.length()-2);
                return valid(shortened);
            } else {
                return false;
            }
        } else {
            if (cell.charAt(0) == 'B') {
                String shortened = cell.substring(1,cell.length()-1);
                return valid(shortened);
            } else {
                return false;
            }
        }
    }
}
