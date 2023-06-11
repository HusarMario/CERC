package home1.joggling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Joggling {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] balls = new String[3];
            balls[0] = line.substring(0, line.indexOf(" "));
            line = line.substring(line.indexOf(" ") + 1);
            balls[1] = line.substring(0, line.indexOf(" "));
            line = line.substring(line.indexOf(" ") + 1);
            balls[2] = line.substring(0, line.indexOf(" "));
            line = line.substring(line.indexOf(" ") + 1);
            long k = Long.parseLong(line);

            k = k % 6;

            switch ((int)k) {
                case 1 : {
                    System.out.println(balls[1] + " " + balls [0] + " " + balls[2]);
                    break;
                }
                case 2 : {
                    System.out.println(balls[1] + " " + balls [2] + " " + balls[0]);
                    break;
                }
                case 3 : {
                    System.out.println(balls[2] + " " + balls [1] + " " + balls[0]);
                    break;
                }
                case 4 : {
                    System.out.println(balls[2] + " " + balls [0] + " " + balls[1]);
                    break;
                }
                case 5 : {
                    System.out.println(balls[0] + " " + balls [2] + " " + balls[1]);
                    break;
                }
                case 0 : {
                    System.out.println(balls[0] + " " + balls [1] + " " + balls[2]);
                    break;
                }
            }
        }
        bufferedReader.close();
    }
}
