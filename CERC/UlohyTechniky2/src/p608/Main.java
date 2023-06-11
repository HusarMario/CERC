package p608;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/p608/input.txt")));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {

            TreeMap<Character, String> coins = new TreeMap<>();
            char letter = 'A';
            for (int j = 0; j < 12; j++) {
                coins.put(letter++, "undefined");
            }


            for (int j = 0; j < 3; j++) {
                String input = bufferedReader.readLine();
                String[] values = input.split(" ");

                for (int k = 0; k < values[0].length(); k++) {
                    if (values[2].equals("even")) {
                        coins.put(values[0].charAt(k), "even");
                        coins.put(values[1].charAt(k), "even");
                    } else {
                        for (Character character : coins.keySet()) {
                            if (!values[0].contains((character.toString())) && (!values[1].contains(character.toString()))) {
                                coins.put(character,"even");
                            }
                        }
                    }

                    if (values[2].equals("down")) {
                        if (!coins.get(values[0].charAt(k)).equals("even")) {
                            if (coins.get(values[0].charAt(k)).equals("up")) {
                                coins.put(values[0].charAt(k), "even");
                            } else{
                                coins.put(values[0].charAt(k), "down");
                            }
                        }

                        if (!coins.get(values[1].charAt(k)).equals("even")) {
                            if (coins.get(values[1].charAt(k)).equals("down")) {
                                coins.put(values[1].charAt(k), "even");
                            } else{
                                coins.put(values[1].charAt(k), "up");
                            }
                        }
                    }

                    if (values[2].equals("up")) {
                        if (!coins.get(values[0].charAt(k)).equals("even")) {
                            if (coins.get(values[0].charAt(k)).equals("down")) {
                                coins.put(values[0].charAt(k), "even");
                            } else{
                                coins.put(values[0].charAt(k), "up");
                            }
                        }

                        if (!coins.get(values[1].charAt(k)).equals("even")) {
                            if (coins.get(values[1].charAt(k)).equals("up")) {
                                coins.put(values[1].charAt(k), "even");
                            } else{
                                coins.put(values[1].charAt(k), "down");
                            }
                        }
                    }
                }
            }

            for (Character character : coins.keySet()) {
                if (!coins.get(character).equals("even")) {
                    if (coins.get(character).equals("up")) {
                        System.out.printf("%c is the counterfeit coin and it is heavy.\n", character);
                    } else {
                        System.out.printf("%c is the counterfeit coin and it is light.\n", character);
                    }
                }
            }
        }
    }
}
