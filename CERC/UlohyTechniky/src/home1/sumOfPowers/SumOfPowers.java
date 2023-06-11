package home1.sumOfPowers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class SumOfPowers {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String line;
            line = bufferedReader.readLine();
            if (line.equals("-1")) {
                break;
            }

            String[] input = line.split(" ");
            double number = Integer.parseInt(input[0]);
            double power = Integer.parseInt(input[1]);

            int numberOfDeviders = (int)Math.pow(number, (1 / power));

            int[] listOfDeviders = new int[numberOfDeviders];
            long sumOfDeviders = 0;
            for (int i = 0; i < numberOfDeviders; i++) {
                listOfDeviders[i] = (int)Math.pow(numberOfDeviders - i, power);
                sumOfDeviders += listOfDeviders[i];
            }

            if (sumOfDeviders < number) {
                System.out.println("0");
            } else if (sumOfDeviders == number) {
                System.out.println("1");
            } else {
                int counter = getUniqueSum(0, listOfDeviders, 0, 0, (int)number);
                System.out.println(counter);
            }
        }
        bufferedReader.close();
    }

    private static int getUniqueSum(int count, int[] listOfDeviders, int currentDevider, int value, int number) {

        for (int i = currentDevider; i < listOfDeviders.length; i++) {
            value += listOfDeviders[i];
            if (value > number) {
                value -= listOfDeviders[i];
            } else if (value == number) {
                value -= listOfDeviders[i];
                count++;
            } else {
                if (!(listOfDeviders.length == i + 1)) {
                    count = getUniqueSum(count, listOfDeviders, i + 1, value, number);
                    value -= listOfDeviders[i];
                }
            }
        }
        return count;
    }
}
