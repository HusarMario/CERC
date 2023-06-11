package home3.fire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Fire {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/home3/fire/input.txt"));

        int tests = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < tests; i++) {
            String input = bufferedReader.readLine();
            String[] values = input.split(" ");

            int rows = Integer.parseInt(values[0]);
            int cols = Integer.parseInt(values[1]);

            ArrayList<int[]> joes = new ArrayList<>();
            ArrayList<int[]> fires = new ArrayList<>();



            char[][] map = new char[rows][cols];
            for (int j = 0; j < rows; j++) {
                String line = bufferedReader.readLine();
                for (int k = 0; k < cols; k++) {
                    map[j][k] = line.charAt(k);

                    if (line.charAt(k) == 'J') {
                        int[] add = new int[2];
                        add[0] = j;
                        add[1] = k;
                        joes.add(add);
                    }

                    if (line.charAt(k) == 'F') {
                        int[] add = new int[2];
                        add[0] = j;
                        add[1] = k;
                        fires.add(add);
                    }

                }
            }



            //System.out.println(Arrays.deepToString(map));
            //calculate(map, rows, cols);
            calculate2(map, rows, cols, joes, fires);

        }
    }

    public static void calculate2(char [][]map, int rows, int cols, ArrayList<int[]> joes, ArrayList<int[]> fires) {
        int index = 0;


        while (true) {
            if (joes.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            index++;

            ArrayList<int[]> joesNew = new ArrayList<>();
            for (int[] joe : joes) {
                if ((joe[0] == 0) || (joe[0] == rows - 1) || (joe[1] == 0) || (joe[1] == cols - 1)) {
                    System.out.println(index);
                    return;
                }
                if ((map[joe[0] - 1][joe[1]] != '#') && (map[joe[0] - 1][joe[1]] != 'F') && (map[joe[0] - 1][joe[1]] != 'J')) {
                    map[joe[0] - 1][joe[1]] = 'J';
                    int[] add = new int[2];
                    add[0] = joe[0] - 1;
                    add[1] = joe[1];
                    joesNew.add(add);
                }
                if ((map[joe[0] + 1][joe[1]] != '#') && (map[joe[0] + 1][joe[1]] != 'F') && (map[joe[0] + 1][joe[1]] != 'J')) {
                    map[joe[0] + 1][joe[1]] = 'J';
                    int[] add = new int[2];
                    add[0] = joe[0] + 1;
                    add[1] = joe[1];
                    joesNew.add(add);
                }
                if ((map[joe[0]][joe[1] - 1] != '#') && (map[joe[0]][joe[1] - 1] != 'F') && (map[joe[0]][joe[1] - 1] != 'J')) {
                    map[joe[0]][joe[1] - 1] = 'J';
                    int[] add = new int[2];
                    add[0] = joe[0];
                    add[1] = joe[1] - 1;
                    joesNew.add(add);
                }
                if ((map[joe[0]][joe[1] + 1] != '#') && (map[joe[0]][joe[1] + 1] != 'F') && (map[joe[0]][joe[1] + 1] != 'J')) {
                    map[joe[0]][joe[1] + 1] = 'J';
                    int[] add = new int[2];
                    add[0] = joe[0];
                    add[1] = joe[1] + 1;
                    joesNew.add(add);
                }
            }
            joes = joesNew;

            ArrayList<int[]> firesNew = new ArrayList<>();
            for (int[] fire : fires) {
                if (fire[0] > 0) {
                    if ((map[fire[0] - 1][fire[1]] != '#') && (map[fire[0] - 1][fire[1]] != 'F')) {
                        boolean findJoe = map[fire[0] - 1][fire[1]] == 'J';
                        map[fire[0] - 1][fire[1]] = 'F';
                        int[] add = new int[2];
                        add[0] = fire[0] - 1;
                        add[1] = fire[1];
                        if (findJoe) {
                            for (int i = 0; i < joes.size(); i++) {
                                if (joes.get(i)[0] == add[0] && joes.get(i)[1] == add[1]) {
                                    joes.remove(joes.get(i));
                                }
                            }
                        }
                        firesNew.add(add);
                    }
                }
                if (fire[0] < rows - 1) {
                    if ((map[fire[0] + 1][fire[1]] != '#') && (map[fire[0] + 1][fire[1]] != 'F')) {
                        boolean findJoe = map[fire[0] + 1][fire[1]] == 'J';
                        map[fire[0] + 1][fire[1]] = 'F';
                        int[] add = new int[2];
                        add[0] = fire[0] + 1;
                        add[1] = fire[1];
                        if (findJoe) {
                            for (int i = 0; i < joes.size(); i++) {
                                if (joes.get(i)[0] == add[0] && joes.get(i)[1] == add[1]) {
                                    joes.remove(joes.get(i));
                                }
                            }
                        }
                        firesNew.add(add);
                    }
                }
                if (fire[1] > 0) {
                    if ((map[fire[0]][fire[1] - 1] != '#') && (map[fire[0]][fire[1] - 1] != 'F')) {
                        boolean findJoe = map[fire[0]][fire[1] - 1] == 'J';
                        map[fire[0]][fire[1] - 1] = 'F';
                        int[] add = new int[2];
                        add[0] = fire[0];
                        add[1] = fire[1] - 1;
                        if (findJoe) {
                            for (int i = 0; i < joes.size(); i++) {
                                if (joes.get(i)[0] == add[0] && joes.get(i)[1] == add[1]) {
                                    joes.remove(joes.get(i));
                                }
                            }
                        }
                        firesNew.add(add);
                    }
                }
                if (fire[1] < cols - 1) {
                    if ((map[fire[0]][fire[1] + 1] != '#') && (map[fire[0]][fire[1] + 1] != 'F')) {
                        boolean findJoe = map[fire[0]][fire[1] + 1] == 'J';
                        map[fire[0]][fire[1] + 1] = 'F';
                        int[] add = new int[2];
                        add[0] = fire[0];
                        add[1] = fire[1] + 1;
                        if (findJoe) {
                            for (int i = 0; i < joes.size(); i++) {
                                if (joes.get(i)[0] == add[0] && joes.get(i)[1] == add[1]) {
                                    joes.remove(joes.get(i));
                                }
                            }
                        }
                        firesNew.add(add);
                    }
                }

            }
            fires = firesNew;

            //for (char[] chars : map) {
            //    System.out.println(chars);
            //}
        }
    }

    public static void calculate(char[][] map, int rows, int cols) {
        int index = 0;



        while (true) {
            boolean foundJ = false;
            index++;

            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    if (map[j][k] == 'J') {
                        foundJ = true;
                        if ((j == 0) || (j == rows - 1) || (k == 0) || (k == cols - 1)) {
                            System.out.println(index);
                            return;
                        } else {
                            if ((map[j - 1][k] != '#') && (map[j - 1][k] != 'F') && (map[j - 1][k] != 'f')) {
                                map[j - 1][k] = 'j';
                            }
                            if ((map[j + 1][k] != '#') && (map[j + 1][k] != 'F') && (map[j + 1][k] != 'f')) {
                                map[j + 1][k] = 'j';
                            }
                            if ((map[j][k - 1] != '#') && (map[j][k - 1] != 'F') && (map[j][k - 1] != 'f')) {
                                map[j][k - 1] = 'j';
                            }
                            if ((map[j][k + 1] != '#') && (map[j][k + 1] != 'F') && (map[j][k + 1] != 'f')) {
                                map[j][k + 1] = 'j';
                            }
                        }
                    }
                    if (map[j][k] == 'f') {
                        map[j][k] = 'F';
                    }
                }
            }

            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    if (map[j][k] == 'F') {
                        if (j != 0) {
                            if ((map[j - 1][k] != '#') && (map[j - 1][k] != 'F')) {
                                map[j - 1][k] = 'f';
                            }
                        }
                        if (j != rows - 1) {
                            if ((map[j + 1][k] != '#') && (map[j + 1][k] != 'F')) {
                                map[j + 1][k] = 'f';
                            }
                        }
                        if (k != 0) {
                            if ((map[j][k - 1] != '#') && (map[j][k - 1] != 'F')) {
                                map[j][k - 1] = 'f';
                            }
                        }
                        if (k != cols - 1) {
                            if ((map[j][k + 1] != '#') && (map[j][k + 1] != 'F')) {
                                map[j][k + 1] = 'f';
                            }
                        }
                    }
                    if (map[j][k] == 'j') {
                        map[j][k] = 'J';
                    }
                }
            }

            //for (char[] chars : map) {
            //    System.out.println(chars);
            //}
            if (!foundJ) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}
