package p10100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10100 {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/p10100/input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int repeat = 0;
        String input;
        while((input = bufferedReader.readLine()) != null) {
            repeat++;
            String first = input;
            String second = bufferedReader.readLine();

            if (first.length() == 0 || second.length() == 0) {
                System.out.printf("%2d. Blank!\n", repeat);
                continue;
            }

            boolean medzera = false;
            StringBuilder firstString = new StringBuilder();
            for (int i = 0; i < first.length(); i++) {
                if ((first.charAt(i) > 47 && first.charAt(i) < 58) || (first.charAt(i) > 64 && first.charAt(i) < 91) || (first.charAt(i) > 96 && first.charAt(i) < 123)) {
                    firstString.append(first.charAt(i));
                    medzera = true;
                } else {
                    if (medzera) {
                        firstString.append(" ");
                        medzera = false;
                    }
                }
            }

            medzera = false;
            StringBuilder secondString = new StringBuilder();
            for (int i = 0; i < second.length(); i++) {
                if ((second.charAt(i) > 47 && second.charAt(i) < 58) || (second.charAt(i) > 64 && second.charAt(i) < 91) || (second.charAt(i) > 96 && second.charAt(i) < 123)) {
                    secondString.append(second.charAt(i));
                    medzera = true;
                } else {
                    if (medzera) {
                        secondString.append(" ");
                        medzera = false;
                    }
                }
            }

            //System.out.println(firstString);
            //System.out.println(secondString);

            //System.out.println(Arrays.toString(first.split( "")));
            //System.out.println(Arrays.toString(second.split("")));

            String[] firstValues = String.valueOf(firstString).split(" ");
            String[] secondValues = String.valueOf(secondString).split(" ");

            //System.out.println(Arrays.toString(firstValues));
            //System.out.println(Arrays.toString(secondValues));

            Tab[][] map = new Tab[secondValues.length + 1][firstValues.length + 1];

            for (int i = 0; i < secondValues.length + 1; i++) {
                if (i == 0) {
                    for (int j = 0; j < firstValues.length + 1; j++) {
                        if (j == 0) {
                            map[i][j] = new Tab("X");
                        } else {
                            if (firstValues[j-1].charAt(0) == ' ') {
                                firstValues[j-1] = firstValues[j-1].substring(1);
                            }
                            map[i][j] = new Tab(firstValues[j-1]);
                        }
                    }
                } else if (i == 1) {
                    for (int j = 0; j < firstValues.length + 1; j++) {
                        if (j == 0) {
                            if (secondValues[i-1].charAt(0) == ' ') {
                                secondValues[i-1] = firstValues[i-1].substring(1);
                            }
                            map[i][j] = new Tab(secondValues[i-1]);
                        } else if (j==1) {
                            if (map[i-1][j].word.equals(map[i][0].word))  {
                                map[i][j] = new Tab(1);
                            } else {
                                map[i][j] = new Tab(0);
                            }
                        } else {
                            if (map[i-1][j].word.equals(map[i][0].word))  {
                                map[i][j] = new Tab(1 + map[i][j-1].value);
                            } else {
                                map[i][j] = new Tab(map[i][j-1].value);
                            }
                        }
                    }
                } else {
                    for (int j = 0; j < firstValues.length + 1; j++) {
                        if (j == 0) {
                            map[i][j] = new Tab(secondValues[i-1]);
                        } else if (j == 1) {
                            if (map[0][j].word.equals(map[i][0].word))  {
                                map[i][j] = new Tab(1);
                            } else {
                                map[i][j] = new Tab(map[i-1][j].value);
                            }
                        } else  {
                            if (map[0][j].word.equals(map[i][0].word))  {
                                map[i][j] = new Tab(1 + map[i-1][j-1].value);
                            } else {
                                if (map[i-1][j].value >= map[i][j-1].value) {
                                    map[i][j] = new Tab(map[i-1][j].value);
                                } else  {
                                    map[i][j] = new Tab(map[i][j-1].value);
                                }
                            }
                        }
                    }
                }
            }

            /*for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (i == 0 || j == 0) {
                        System.out.print(map[i][j].word + " ");
                    } else {
                        System.out.print(map[i][j].value + " ");
                    }
                }
                System.out.println();
            }*/

            System.out.printf("%2d. Length of longest match: %d\n", repeat, map[secondValues.length][firstValues.length].value);
        }
    }

    public static class Tab {
        String word;
        int value;

        public Tab(String word) {
            this.word = word;
            this.value = 0;
        }

        public Tab(int value) {
            this.word = null;
            this.value = value;
        }
    }
}
