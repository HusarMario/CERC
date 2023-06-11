package p10074;

import java.io.*;

public class p10074 {
    public static int VALUE;
    public static int N;
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/p10074/input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = 1;
        while (true) {
            String input = bufferedReader.readLine();
            String[] values = input.split(" ");

            if (Integer.parseInt(values[0]) == 0 && Integer.parseInt(values[1]) == 0) {
                break;
            }

            VALUE = 0;
            Piece[][] map = new Piece[Integer.parseInt(values[0])][Integer.parseInt(values[1])];
            for (int i = 0; i < Integer.parseInt(values[0]); i++) {
                input = bufferedReader.readLine();
                String[] mapReader = input.split(" ");
                for (int j = 0; j < Integer.parseInt(values[1]); j++) {
                    map[i][j] = new Piece((Integer.parseInt(mapReader[j]) != 1));

                    if(!map[i][j].empty) {
                        continue;
                    }

                    if (i == 0 || !map[i-1][j].empty)  {
                        map[i][j].topLen = 0;
                    } else {
                        map[i][j].topLen = map[i - 1][j].topLen + 1;
                        map[i][j].tempTopLen = map[i][j].topLen;
                        if (map[i][j].topLen + 1 > map[i][j].value) {
                            map[i][j].value = map[i][j].topLen + 1;
                        }
                    }

                    if (j == 0 || !map[i][j-1].empty) {
                        map[i][j].leftLen = 0;
                    } else {
                        map[i][j].leftLen = map[i][j - 1].leftLen + 1;
                        map[i][j].tempLeftLen = map[i][j].leftLen;
                        if (map[i][j].leftLen + 1 > map[i][j].value) {
                            map[i][j].value = map[i][j].leftLen + 1;
                        }
                    }

                    for (int k = 1; k <= map[i][j].topLen; k++) {
                        if (map[i][j].leftLen == 0) {
                            break;
                        }

                        if (map[i-k][j].leftLen == 0) {
                            break;
                        }

                        if (map[i-k][j].leftLen < map[i][j].tempLeftLen) {
                            map[i][j].tempLeftLen = map[i-k][j].leftLen;
                        }

                        if (((map[i][j].tempLeftLen + 1) * (k + 1)) > map[i][j].value) {
                            map[i][j].value = (map[i][j].tempLeftLen + 1) * (k + 1);
                        }
                    }

                    for (int k = 1; k <= map[i][j].leftLen; k++) {
                        if (map[i][j].topLen == 0) {
                            break;
                        }

                        if (map[i][j-k].topLen == 0) {
                            break;
                        }

                        if (map[i][j-k].topLen < map[i][j].tempTopLen) {
                            map[i][j].tempTopLen = map[i][j-k].topLen;
                        }

                        if (((map[i][j].tempTopLen + 1) * (k + 1)) > map[i][j].value) {
                            map[i][j].value = (map[i][j].tempTopLen + 1) * (k + 1);
                        }
                    }

                    if (map[i][j].value > VALUE) {
                        VALUE = map[i][j].value;
                    }
                }
            }

            /*for (Piece[] pieces : map) {
                for (Piece piece : pieces) {
                    //System.out.print("[" + piece.leftLen + " " + piece.value + " " + piece.topLen + "]");
                    //System.out.print("[" + piece.value + "]");
                    System.out.printf("[%2d] ", piece.value);
                }
                System.out.println();
            }*/

            System.out.println(VALUE);
        }
    }

    public static class Piece {
        boolean empty;
        int value;
        int topLen;
        int leftLen;
        int tempTopLen;
        int tempLeftLen;

        public Piece(boolean empty) {
            this.empty = empty;
            if (this.empty) {
                this.value = 1;
            } else {
                this.value = 0;
            }
            this.topLen = 0;
            this.leftLen = 0;
            this.tempLeftLen = 0;
            this.tempTopLen = 0;
        }
    }
}
