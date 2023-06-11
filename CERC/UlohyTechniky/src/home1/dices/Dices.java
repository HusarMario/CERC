package home1.dices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Dices {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String secondLine = bufferedReader.readLine();
            String thirdLine = bufferedReader.readLine();

            int numOfDices = (line.length() + 1) / 4;
            long value = 0;

            for (int i = 0; i < numOfDices; i++) {
                String dice = line.substring(0, 3);
                String secondDice = secondLine.substring(0, 3);

                if (i == numOfDices - 1) {
                    line = line.substring(3);
                    secondLine = secondLine.substring(3);
                } else {
                    line = line.substring(4);
                    secondLine = secondLine.substring(4);
                }

                if (dice.contains("#")) {
                    if (dice.charAt(0) == 'O' && dice.charAt(2) == 'O') {
                        if (secondDice.contains("O")) {
                            if (secondDice.charAt(1) == 'O') {
                                value += 5;
                            } else {
                                value += 6;
                            }
                        } else {
                            value += 4;
                        }
                    } else if (dice.charAt(0) == 'O' || dice.charAt(2) == 'O') {
                        if (secondDice.contains("O")) {
                            value += 3;
                        } else {
                            value += 2;
                        }
                    } else {
                        value += 1;
                    }
                } else {
                    value += 6;
                }
            }
            System.out.println(value);
            bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
