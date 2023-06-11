package exercise4;

import java.io.*;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class QueenProblem {
    private static int[][] pole =  {{0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0}};

    private static int usedrow;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        //File file = new File("src/exercise4/input.txt");
        //BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < k; i++) {
            bufferedReader.readLine();
            resetPole();
            String input = bufferedReader.readLine();
            String[] values = input.split(" ");
            int col = Integer.parseInt(values[0]) - 1;
            int row = Integer.parseInt(values[1]) - 1;
            usedrow = row;

            pole[row][col] = 1;

            System.out.println("SOLN       COLUMN      ");
            System.out.println(" #      1 2 3 4 5 6 7 8");
            System.out.println();
            inputQueen(0);
            System.out.println();

        }
    }

    private static void resetPole() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                pole[i][j] = 0;
            }
        }
        count = 0;
    }

    private static boolean inputQueen(int row) {
        if (row == usedrow) {
            if (usedrow == 7) {
                showPole();
                return false;
            } else {
                inputQueen(row + 1);
            }
        }

        for (int i = 0; i < 8; i++) {
            if (canBePut(row, i)) {
                pole[row][i] = 1;
                if (row + 1 < 8) {
                    inputQueen(row + 1);
                } else {
                    showPole();
                }
                pole[row][i] = 0;
            }
        }
        return false;
    }

    private static boolean canBePut(int row, int col) {
        for (int i = 0; i < 8; i++) {
            if ((pole[row][i]) == 1) {
                return false;
            }
            if ((pole[i][col] == 1)) {
                return false;
            }
        }

        int helpRow = row;
        int helpCol = col;
        while (helpRow > 0 && helpCol > 0) {
            helpRow--;
            helpCol--;
        }
        while (helpRow < 8 && helpCol < 8 ) {
            if (pole[helpRow][helpCol] == 1) {
                return false;
            }
            helpRow++;
            helpCol++;
        }

        helpRow = col;
        helpCol = row;
        while (helpRow > 0 && helpCol < 7) {
            helpRow--;
            helpCol++;
        }
        while (helpRow < 8 && helpCol > -1 ) {
            if (pole[helpRow][helpCol] == 1) {
                return false;
            }
            helpRow++;
            helpCol--;
        }
        return true;

    }

    private static void showPole() {
        count++;
        if (count < 10) {
            System.out.print(" " + count + "     ");
        } else {
            System.out.print(count + "     ");
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pole[i][j] == 1) {
                    System.out.print(" " + (j + 1));

                }
            }
        }
        System.out.println();

        /*for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(pole[i]));
        }
        System.out.println();*/
    }

    private static void show() {
        for (int j = 0; j < 8; j++) {
            for (int l = 0; l < 8; l++) {
                System.out.print(pole[j][l]);
            }
            System.out.println();

        }
        System.out.println();
    }
}
