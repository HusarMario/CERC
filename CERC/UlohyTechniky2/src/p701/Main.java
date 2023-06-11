package p701;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("src/p701/input.txt"));

        TreeMap<Long,Integer> mapa = new TreeMap<>();
        int[] numberInBytes = new int[1];
        for (int i = 0; i < 1; i++) {
            numberInBytes[i] = 0;
        }
        numberInBytes[0]  = 1;
        int length = 1;
        int e = 0;


        while (scanner.hasNext()) {
            long number = scanner.nextInt();

            while (true) {

                if (mapa.containsKey(number)) {
                    //System.out.println(mapa.get(number));
                    break;
                }


                e++;
                System.out.println(e);

                boolean overruun = false;
                for (int i = (numberInBytes.length - 1); i >= 0 ; i--) {
                    numberInBytes[i] *= 2;

                    if (overruun) {
                        numberInBytes[i] += 1;
                        overruun = false;
                    }

                    if (numberInBytes[i] >= 10) {
                        numberInBytes[i] %= 10;
                        overruun = true;
                    }
                }

                if (overruun) { //addint another block of byte
                    length++;
                    int [] newNumberInBytes = new int[length];
                    for (int i = 0; i < length; i++) {
                        if (i == 0) {
                            newNumberInBytes[i] = 1;
                        } else {
                            newNumberInBytes[i] = numberInBytes[i-1];
                        }
                    }

                    numberInBytes = newNumberInBytes;
                }

                //System.out.print(e + " : ");
                //System.out.println(Arrays.toString(numberInBytes));
                long calculatedNumber = 0;
                for (int i = 0; i < length; i++) {

                    if (i == 10) {
                        break;
                    }

                    if (length % 2 == 0) {
                        if (i >= length/2 - 1) {
                            break;
                        }
                    } else {
                        if (i > length/2 - 1) {
                            break;
                        }
                    }

                    calculatedNumber *= 10;
                    calculatedNumber += numberInBytes[i];
                    //System.out.println(calculatedNumber);

                    if (!mapa.containsKey(calculatedNumber)) {
                        mapa.put(calculatedNumber, e);
                    }
                }
            }
        }
        //System.out.println("TEst");
    }
}
