package home2.cogwheels;

import java.io.*;
import java.util.ArrayList;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Cogwheels {
    @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/home2/cogwheels/input.txt"));

        int testCases = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < testCases; i++) {
            boolean clockWise = true;
            int numOfWheels = Integer.parseInt(bufferedReader.readLine());
            ArrayList<Integer> radius = new ArrayList<>();
            for (int j = 0; j < numOfWheels; j++) {
                radius.add(Integer.parseInt(bufferedReader.readLine()));
            }
            int clockTurn = radius.get(0);
            for (Integer rad : radius) {
                int radClockTurn = clockTurn;
                int currrad = rad;
                boolean redoGCF = true;

                if (radClockTurn % currrad == 0) {
                    System.out.print(radClockTurn / currrad + " ");
                } else {
                    while (redoGCF) {
                        int gcm = greatestCommonFactor(radClockTurn, currrad);
                        if (gcm == 1) {
                            redoGCF = false;
                        }
                        radClockTurn /= gcm;
                        currrad /= gcm;
                    }
                    System.out.print(radClockTurn + "/" + currrad + " ");
                }





                if (clockWise) {
                    System.out.println("clockwise");
                    clockWise = false;
                } else {
                    System.out.println("counterclockwise");
                    clockWise = true;
                }
            }
        }


    }

    private static int greatestCommonFactor (int number1, int number2) {

        while ((number2 != 0) && (number1 != 0)) {
            if (number1 > number2) {
                number1 -= number2;
            } else {
                number2 -= number1;
            }
        }
        if (number1 == 0) {
            return number2;
        } else {
            return number1;
        }
    }


}
