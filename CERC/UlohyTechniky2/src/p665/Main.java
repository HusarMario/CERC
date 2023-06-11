package p665;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(new File("src/p665/input.txt"));

        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            int coins = scanner.nextInt();
            int comparisions = scanner.nextInt();

            TreeMap<Integer, Character> mapa = new TreeMap<>();
            for (int j = 0; j < coins; j++) {
                mapa.put(j+1, '0');
            }


            for (int j = 0; j < comparisions; j++) {
                int coinCount = scanner.nextInt();

                ArrayList<Integer> leftSide = new ArrayList<>();
                ArrayList<Integer> rightSide = new ArrayList<>();
                for (int k = 0; k < coinCount; k++) {
                    leftSide.add(scanner.nextInt());
                }
                for (int k = 0; k < coinCount; k++) {
                    rightSide.add(scanner.nextInt());
                }

                String comparator = scanner.next();
                //System.out.println(comparator);

                switch (comparator.charAt(0)) {
                    case '<' : {
                        for (Integer integer : mapa.keySet()) {
                            if (!leftSide.contains(integer) && !rightSide.contains(integer)) {
                                mapa.put(integer,'=');
                            }
                        }
                        for (Integer integer : leftSide) {
                            char sign = mapa.get(integer);
                            if (sign == '0') {
                                mapa.put(integer,'<');
                                continue;
                            }
                            if (sign == '>') {
                                mapa.put(integer,'=');
                            }
                        }
                        for (Integer integer : rightSide) {
                            char sign = mapa.get(integer);
                            if (sign == '0') {
                                mapa.put(integer,'>');
                                continue;
                            }
                            if (sign == '<') {
                                mapa.put(integer,'=');
                            }
                        }
                        break;
                    }
                    case '>' : {
                        for (Integer integer : mapa.keySet()) {
                            if (!leftSide.contains(integer) && !rightSide.contains(integer)) {
                                mapa.put(integer,'=');
                            }
                        }
                        for (Integer integer : leftSide) {
                            char sign = mapa.get(integer);
                            if (sign == '0') {
                                mapa.put(integer,'>');
                                continue;
                            }
                            if (sign == '<') {
                                mapa.put(integer,'=');
                            }
                        }
                        for (Integer integer : rightSide) {
                            char sign = mapa.get(integer);
                            if (sign == '0') {
                                mapa.put(integer,'<');
                                continue;
                            }
                            if (sign == '>') {
                                mapa.put(integer,'=');
                            }
                        }
                        break;
                    }
                    case '=' : {
                        for (Integer integer : leftSide) {
                            mapa.put(integer,'=');
                        }
                        for (Integer integer : rightSide) {
                            mapa.put(integer,'=');
                        }
                        break;
                    }
                }
            }

            int answer = 0;
            int alternate = 0;
            boolean comparison = false;
            for (Integer integer : mapa.keySet()) {
                if (mapa.get(integer) == '>' || mapa.get(integer) == '<') {
                    comparison = true;
                    if (answer == 0) {
                        answer = integer;
                    } else {
                        answer = -1;
                    }
                }

                if (mapa.get(integer) == '0') {
                    if (alternate == 0) {
                        alternate = integer;
                    } else {
                        alternate = -1;
                    }
                }
            }

            if (!comparison) {
                System.out.println(Math.max(alternate, 0));
            } else {
                System.out.println(Math.max(answer, 0));
            }


            if (i != tests - 1) {
                System.out.println();
            }
        }
    }
}
