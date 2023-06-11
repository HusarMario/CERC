package exercise2.carmichael;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Carmichael {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            int n = Integer.parseInt(line);

            if (power(n)) {
                if (!isPrime(n)) {
                    System.out.println("The number " + n + " is a Carmichael number.");
                } else {
                    System.out.println(n + " is normal.");
                }
            } else {
                System.out.println(n + " is normal.");
            }
        }
    }

    private static boolean power(int n) {
        int number;
        for (int i = 2; i < 10; i++) {
            number = i;
            int powered = number;
            for (int j = 1; j < n; j++) {
                powered = powered * number;
                powered = powered % n;
            }
            if (powered != number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(int n) {
        ArrayList<Number> numbers = new ArrayList<Number>();
        for (int i = 0; i < n - 1; i++) {
            numbers.add(new Number(i + 2));
        }

        for (int i = 0; i < n - 1; i++) {
            if (!numbers.get(i).isPrime() && numbers.get(i).isVisible()) {
                numbers.get(i).setPrime(true);
                for (int j = i; j < n - 1; j = j + numbers.get(i).getValue()) {
                    if (!numbers.get(j).isPrime() && numbers.get(j).isVisible()) {
                        numbers.get(j).setVisible(false);
                    }
                }
            }

            if (i == n - 2) {
                return numbers.get(i).isPrime();
            }
        }
        return false;
    }

}
