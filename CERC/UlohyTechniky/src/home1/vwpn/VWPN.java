package home1.vwpn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class VWPN {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number;
        while ((number = Integer.parseInt(bufferedReader.readLine())) != 0) {
            System.out.println(countVPWN(number));
        }
    }

    private static String countVPWN(int number) {
        int count = 1;
        int originalNumber = number;
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= (int)Math.sqrt(number); i++) {
            if (number == 1) {
                break;
            }
            boolean prime = true;

            for (Integer integer : primes) {
                if (integer > Math.sqrt(i)) {
                    break;
                }
                if (i % integer == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primes.add(i);

                boolean divide = false;
                while (number % i == 0) {
                    number /= i;
                    divide = true;
                }

                if (divide) {
                    count++;
                }
            }
        }

        if (number == 1) {
            count--;
        }

        for (Integer integer : primes) {
            if (count == integer) {
                return "yes";
            }
        }
        return "no";
    }
}
