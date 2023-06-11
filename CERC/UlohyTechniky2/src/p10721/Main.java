package p10721;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static long SOLUTIONS = 0;
    public static int WIDTH = 0;
    public static int BARS = 0;
    public static int BARWIDTH = 0;
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("src/p10721/input.txt"));

        while (scanner.hasNext()) {
            WIDTH = scanner.nextInt();
            BARS = scanner.nextInt();
            BARWIDTH = scanner.nextInt();

            if (BARS * BARWIDTH < WIDTH) {
                System.out.println(0);
                continue;
            }

            if (BARS * BARWIDTH == WIDTH) {
                System.out.println(1);
                continue;
            }

            if (WIDTH < BARS) {
                System.out.println(0);
                continue;
            }

            if (WIDTH == BARS) {
                System.out.println(1);
                continue;
            }

            solve(1,1,1);
            System.out.println(SOLUTIONS);
        }
    }

    public static void solve(int width, int bars, int barwidth) {
        if (width == WIDTH) {
            SOLUTIONS++;
            return;
        }

        if (bars != BARS) {
            solve(width + 1, bars + 1, 1);
        }

        if (barwidth != BARWIDTH) {
            solve(width + 1, bars, barwidth + 1);
        }
    }
}
