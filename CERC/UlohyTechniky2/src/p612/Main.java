package p612;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/p612/input.txt"));

        int tests = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < tests; i++) {
            bufferedReader.readLine();
            String input = bufferedReader.readLine();
            String[] values = input.split(" ");
            int size = Integer.parseInt(values[0]);
            int lines = Integer.parseInt(values[1]);

            TreeMap<Integer,Integer> mapa = new TreeMap<>();
            TreeMap<Integer,String> inputs = new TreeMap<>();
            ArrayList<Integer> output = new ArrayList<>();

            for (int j = 0; j < lines; j++) {
                String line = bufferedReader.readLine();

                int a = 0;
                int c = 0;
                int g = 0;
                int t = 0;

                int inversions = 0;
                for (int k = 0; k < size; k++) {


                    switch (line.charAt(k)) {
                        case 'A' : {
                            a++;
                            inversions += c+g+t;
                            break;
                        }
                        case 'C' : {
                            c++;
                            inversions += g+t;
                            break;
                        }
                        case 'G' : {
                            g++;
                            inversions += t;
                            break;
                        }
                        case 'T' : {
                            t++;
                            break;
                        }
                    }
                }

                mapa.put(j,inversions);
                inputs.put(j,line);
                output.add(j);
            }


            /*for (Integer index : mapa.keySet()) {
                System.out.println(index + " " + mapa.get(index) + " " + inputs.get(index));
            }*/

            /*for (Integer value : mapa.values()) {
                System.out.println(value);
            }*/

            output.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (mapa.get(o1) > mapa.get(o2)) {
                        return 1;
                    } else if (mapa.get(o1) < mapa.get(o2)) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });

            for (Integer integer : output) {
                System.out.println(inputs.get(integer));
            }

            if (i != tests - 1) {
                System.out.println();
            }

        }
    }
}
