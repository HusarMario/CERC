package exercise4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Binary {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String line = bufferedReader.readLine();
            int input = Integer.parseInt(line);


            if (input == 0) {
                break;
            } else {
                String binary = Integer.toBinaryString(input);
                if (binary.contains("0")) {

                    int changeableIndex = 0;
                    for (int i = 1; i < binary.length(); i++) {
                        if ((binary.charAt(i) == '1') && (binary.charAt(i - 1) == '0')) {
                            changeableIndex = i;
                        }
                    }

                    int countOnes = 0;
                    int countZeros = 1;
                    for (int i = changeableIndex + 1; i < binary.length(); i++) {
                        if (binary.charAt(i) == '0') {
                            countZeros++;
                        } else {
                            countOnes++;
                        }
                    }

                    String changed = "";
                    if (changeableIndex != 0) {
                        changed = binary.substring(0, changeableIndex - 1);
                    }
                    changed = changed + "1";
                    changed = changed + "0".repeat(countZeros);
                    changed = changed + "1".repeat(countOnes);

                    int output = Integer.parseInt(changed, 2);
                    System.out.println(output);



                } else {
                    String binaryNew = "1" + "0" + "1".repeat((binary.length() - 1));

                    int output = Integer.parseInt(binaryNew, 2);
                    System.out.println(output);
                }
            }
        }
    }
}
