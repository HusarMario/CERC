package p729;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(new File("src/p729/input.txt"));

        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            int n = scanner.nextInt();
            int h = scanner.nextInt();

            int[] bits = new int[n];
            for (int j = 0; j < n; j++) {
                if (j < (n-h)) {
                    bits[j] = 0;
                } else {
                    bits[j] = 1;
                }
            }



            int ones = h;
            for (int bit : bits) {
                System.out.print(bit);
            }
            System.out.println();

            if (n == h) {
                if (i != k-1) {
                    System.out.println();
                }
                continue;
            }

            while (true) {
                int addition = 1;
                for (int j = n-1; j > -1; j--) {
                    if (addition == 0) {
                        break;
                    }
                    if (bits[j] == 0) {
                        bits[j] = 1;
                        addition = 0;
                        ones++;
                    } else {
                        bits[j] = 0;
                        ones--;
                    }
                }

                if (addition == 1) {
                    break;
                } else {
                    if (ones == h) {
                        for (int bit : bits) {
                            System.out.print(bit);
                        }
                        System.out.println();
                    }
                }
            }
            if (i != k-1) {
                System.out.println();
            }


        }
    }
}
