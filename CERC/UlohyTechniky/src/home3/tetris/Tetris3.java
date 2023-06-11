package home3.tetris;

import java.io.*;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Tetris3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/home3/tetris/input.txt"));

        int test = Integer.parseInt(bufferedReader.readLine());

        for (int a = 0; a < test; a++) {
            String input = bufferedReader.readLine();
            //System.out.println(input);
            if (input.length() < 2) {
                System.out.println(1);
            } else if (input.length() <= 7) {
                if (testTetrisSmall(input)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                boolean found = false;
                for (int i = 0; i < 7; i++) {
                    if (indexing(input, i)) {
                        System.out.println(1);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(0);
                }
            }
        }
    }

    public static boolean indexing(String input, int index) {
        if (!smallInterval(input.substring(0, index))) {
            return false;
        }

        while (index < input.length() - 7) {
            if (!interval(input.substring(index, 7 + index))) {
                return false;
            }
            index += 7;
        }

        return smallInterval(input.substring(index));
    }

    public static boolean interval(String input) {
        if ((input.contains("I")) && (input.contains("J")) && (input.contains("L")) && (input.contains("O")) && (input.contains("S")) && (input.contains("Z")) && (input.contains("T"))) {
            return true;
        }
        return false;
    }

    public static boolean smallInterval(String input) {
        int firstI = 0;
        int firstJ = 0;
        int firstL = 0;
        int firstO = 0;
        int firstS = 0;
        int firstZ = 0;
        int firstT = 0;

        for (int j = 0; j < input.length(); j++) {


            switch (input.charAt(j)) {
                case 'I' : {
                    firstI++;
                    break;
                }
                case 'J' : {
                    firstJ++;
                    break;
                }
                case 'L' : {
                    firstL++;
                    break;
                }
                case 'O' : {
                    firstO++;
                    break;
                }
                case 'S' : {
                    firstS++;
                    break;
                }
                case 'Z' : {
                    firstZ++;
                    break;
                }
                case 'T' : {
                    firstT++;
                    break;
                }
            }
        }

        return (firstI < 2) && (firstJ < 2) && (firstL < 2) && (firstO < 2) && (firstS < 2) && (firstZ < 2) && (firstT < 2);
    }

    public static boolean testTetrisSmall(String input) {
        //System.out.println(input);
        if (input.length() <= 1) {
            return true;
        }

        if ((input.contains("I")) && (input.contains("J")) && (input.contains("L")) && (input.contains("O")) && (input.contains("S")) && (input.contains("Z")) && (input.contains("T"))) {
            return true;
        }

        for (int i = 1; i < input.length(); i++) {
            String firstPart = input.substring(0, i);
            String secondPart = input.substring(i, input.length());
            //System.out.println(input.substring(0, i) + " " + input.substring(i, input.length()));


            boolean first = false;
            int firstI = 0;
            int firstJ = 0;
            int firstL = 0;
            int firstO = 0;
            int firstS = 0;
            int firstZ = 0;
            int firstT = 0;

            for (int j = 0; j < firstPart.length(); j++) {


                switch (firstPart.charAt(j)) {
                    case 'I' : {
                        firstI++;
                        break;
                    }
                    case 'J' : {
                        firstJ++;
                        break;
                    }
                    case 'L' : {
                        firstL++;
                        break;
                    }
                    case 'O' : {
                        firstO++;
                        break;
                    }
                    case 'S' : {
                        firstS++;
                        break;
                    }
                    case 'Z' : {
                        firstZ++;
                        break;
                    }
                    case 'T' : {
                        firstT++;
                        break;
                    }
                }
            }

            if ((firstI < 2) && (firstJ < 2) && (firstL < 2) && (firstO < 2) && (firstS < 2) && (firstZ < 2) && (firstT < 2)) {
                first = true;
            }

            boolean second = false;
            int secondI = 0;
            int secondJ = 0;
            int secondL = 0;
            int secondO = 0;
            int secondS = 0;
            int secondZ = 0;
            int secondT = 0;

            for (int j = 0; j < secondPart.length(); j++) {


                switch (secondPart.charAt(j)) {
                    case 'I' : {
                        secondI++;
                        break;
                    }
                    case 'J' : {
                        secondJ++;
                        break;
                    }
                    case 'L' : {
                        secondL++;
                        break;
                    }
                    case 'O' : {
                        secondO++;
                        break;
                    }
                    case 'S' : {
                        secondS++;
                        break;
                    }
                    case 'Z' : {
                        secondZ++;
                        break;
                    }
                    case 'T' : {
                        secondT++;
                        break;
                    }
                }
            }

            if ((secondI < 2) && (secondJ < 2) && (secondL < 2) && (secondO < 2) && (secondS < 2) && (secondZ < 2) && (secondT < 2)) {
                second = true;
            }

            if (first && second) {
                //System.out.println(firstPart + " " + secondPart);
                return true;
            }
        }
        return false;
    }
}
