package home2.bitSwitch;

import java.io.*;
import java.util.Arrays;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class BitSwitch {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/home2/bitSwitch/input.txt"));

        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            String code = bufferedReader.readLine();
            String[] values = code.split(" ");
            String[] rValues = new String[values.length];
            for (int r = 0; r < values.length; r++) {
                rValues[values.length - 1 - r] = values[r];
            }

            //System.out.println(Arrays.toString(values));
            //System.out.println(Arrays.toString(rValues));

            int k = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < k; j++) {
                int number = Integer.parseInt(bufferedReader.readLine());


                //System.out.println(number);
                String binary = Integer.toBinaryString(number);

                while (binary.length() != values.length) {
                    binary = "0" + binary;
                }
                //System.out.println(binary);
                char[] newBinary = new char[values.length];
                //System.out.println(newBinary);
                for (int a = 0; a < values.length; a++) {
                    newBinary[newBinary.length - 1 - Integer.parseInt(rValues[a])] = binary.charAt(a);
                }

                //System.out.println(newBinary);
                String newBinaryString = String.valueOf(newBinary);
                //System.out.println(newBinaryString);
                Integer newNumber = Integer.parseInt(newBinaryString, 2);
                System.out.println(newNumber);
                //System.out.println();
            }
        }
    }
}
