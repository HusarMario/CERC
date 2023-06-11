package piggybank;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static ArrayList<Integer> results;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/mincovna/input.txt"));

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            String[] valuesOfPiggyBank = input.split(" ");
            int piggyBankWeight = Integer.parseInt(valuesOfPiggyBank[1]) - Integer.parseInt(valuesOfPiggyBank[0]);
            int numberOfCoins = Integer.parseInt(bufferedReader.readLine());

            ArrayList<Coin> coins = new ArrayList<>();
            for (int j = 0; j < numberOfCoins; j++) {
                input = bufferedReader.readLine();
                String[] valuesOfCoins = input.split(" ");
                coins.add(new Coin(Integer.parseInt(valuesOfCoins[0]), Integer.parseInt(valuesOfCoins[1])));
            }

            if (piggyBankWeight < 0) {
                System.out.println("This is impossible.");
                continue;
            }

            if (piggyBankWeight == 0) {
                System.out.println("The minimum amount of money in the piggy-bank is 0.");
                continue;
            }

            coins.sort(Comparator.comparing(Coin::getBest));
            /*for (Coin coin : coins) {
                System.out.println(coin.value + " " + coin.weight + " " + coin.best);
            }*/

            ArrayList<Result> results = new ArrayList<>();
            for (int j = 0; j < piggyBankWeight + 1; j++) {
                Result result = new Result(j);
                results.add(result);

                if (j == 0) {
                    continue;
                }

                for (Coin coin : coins) {
                    if (j - coin.weight >= 0) {
                        int value = j - coin.weight;
                        if ((value == 0) || (results.get(j - coin.weight).previous != null)) {
                            if (result.money == 0 || result.money > (results.get(j - coin.weight).money) + coin.value) {
                                result.addPrev(results.get(j - coin.weight), coin.value);
                            }
                        }
                    }
                }
            }


            /*for (Result result : results) {
                if (result.previous != null) {
                    System.out.println(result.value + " " + result.previous.value + " " + result.money);
                } else {
                    System.out.println(result.value + " X ");
                }
            }*/

            if (results.get(piggyBankWeight).previous != null) {
                System.out.printf("The minimum amount of money in the piggy-bank is %d.\n", results.get(piggyBankWeight).money);
            } else {
                System.out.println("This is impossible.");
            }
        }
    }

    public static class Coin {
        private final int value;
        private final int weight;
        private double best;

        public Coin(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.best = (double) value / weight;
        }

        public double getBest() {
            return best;
        }
    }

    public static class Result {
        private final int value;
        private Result previous;
        private int money;

        public Result(int value) {
            this.value = value;
            this.previous = null;
            this.money = 0;
        }

        public void addPrev(Result result, int money) {
            this.previous = result;
            this.money = this.previous.money + money;
        }

    }
}
