package p824;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(new File("src/p824/input.txt"));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int x = scanner.nextInt();

            if (x == -1) {
                break;
            }

            int y = scanner.nextInt();
            int d = scanner.nextInt();

            int[] directions = new int [8];
            for (int i = 0; i < 8; i++) {
                int dirX = scanner.nextInt();
                int dirY = scanner.nextInt();
                int direction = scanner.nextInt();

                if (dirX > x) {
                    if (dirY > y) {
                        directions[7] = direction;
                        continue;
                    }
                    if (dirY < y) {
                        directions[5] = direction;
                        continue;
                    }
                    if (dirY == y) {
                        directions[6] = direction;
                        continue;
                    }
                }
                if (dirX < x) {
                    if (dirY > y) {
                        directions[1] = direction;
                        continue;
                    }
                    if (dirY < y) {
                        directions[3] = direction;
                        continue;
                    }
                    if (dirY == y) {
                        directions[2] = direction;
                        continue;
                    }
                }

                if (dirX == x) {
                    if (dirY > y) {
                        directions[0] = direction;
                        continue;
                    }
                    if (dirY < y) {
                        directions[4] = direction;
                        continue;
                    }
                }
            }

            //System.out.println(Arrays.toString(directions));



            d -= 1;
            if (d == -1) {
                d = 7;
            }

            d -= 1;
            if (d == -1) {
                d = 7;
            }


            while (true) {
                if (directions[d] == 1) {
                    System.out.println(d);
                    break;
                }

                d += 1;
                if (d == 8) {
                    d = 0;
                }

            }
        }
    }
}
