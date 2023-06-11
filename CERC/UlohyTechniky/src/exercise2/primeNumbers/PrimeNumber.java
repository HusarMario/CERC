package exercise2.primeNumbers;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            int wordValue = 0;
            for (int i = 0; i < word.length(); i++) {
                int letterValue = word.charAt(i);
                if (letterValue < 95) {
                    wordValue += letterValue - 64 + 26;
                } else {
                    wordValue += letterValue - 96;
                }
            }

            if (wordValue == 1) {
                System.out.println("It is not a prime word.");
                continue;
            }

            ArrayList<Number> numbers = new ArrayList<Number>();
            for (int i = 0; i < wordValue - 1; i++) {
                numbers.add(new Number(i + 2));
            }

            for (int i = 0; i < wordValue - 1; i++) {
                if (!numbers.get(i).isPrime() && numbers.get(i).isVisible()) {
                    numbers.get(i).setPrime(true);
                    for (int j = i; j < wordValue - 1; j = j + numbers.get(i).getValue()) {
                        if (!numbers.get(j).isPrime() && numbers.get(j).isVisible()) {
                            numbers.get(j).setVisible(false);
                        }
                    }
                }

                if (i == wordValue - 2) {
                    if (numbers.get(i).isPrime()) {
                        System.out.println("It is a prime word.");
                    } else {
                        System.out.println("It is not a prime word.");
                    }
                }
            }


        }


    }
}
