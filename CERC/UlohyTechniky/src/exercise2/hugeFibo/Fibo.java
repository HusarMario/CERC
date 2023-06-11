package exercise2.hugeFibo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Fibo {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTestCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfTestCases; ++i) {
            int number = Integer.parseInt(reader.readLine());

            int result = getFibo(2, number, 0, 1);
            System.out.printf("%06d\n", result);
        }
        reader.close();
    }

    private static int getFibo(int n, int number, int prev2, int prev) {
        //if (number < 2) {
        if (number == n - 2) {
            return prev2;
        } else if (number == n - 1) {
            return prev;
        } else {
            while (true) {
                int value = prev + prev2;
                value = value % 1000000;
                if (n == number) {
                    return value;
                } else {
                    n++;
                    prev2 = prev;
                    prev = value;
                }
            }
        }
//        } else {
//            int newNumber;
//            if (number % 2 == 1) {
//                newNumber = (number + 1) / 2;
//                int firstPart = (getFibo(n, newNumber, prev2, prev));
//                int secondPart = firstPart * firstPart;
//                int thirdPart = (getFibo(n - 1, newNumber, prev2, prev));
//                int fourthPart = thirdPart * thirdPart;
//                return secondPart + fourthPart;
//            } else {
//                newNumber = number / 2;
//                int firstPart = getFibo(n, newNumber - 1, prev2, prev) * 2;
//                int secondPart = getFibo(n, number, prev2, prev);
//                int thirdPart = firstPart + secondPart;
//                return thirdPart * secondPart;
//            }
//        }

    }
}

