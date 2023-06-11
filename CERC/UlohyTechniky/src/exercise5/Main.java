package exercise5;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/exercise5/input.txt"));

        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            HashMap<Integer, ArrayList<Integer>> stations = new HashMap<>();
            String[] values = bufferedReader.readLine().split(" ");

            int firstStation = 0;
            boolean firstStationFound = false;

            for (int j = 0; j < Integer.parseInt(values[1]); j++) {
                String[] input = bufferedReader.readLine().split(" ");

                if (!firstStationFound) {
                    firstStation = Integer.parseInt(input[0]);
                    firstStationFound = true;
                }


                if (!stations.containsKey(Integer.parseInt(input[0]))) {
                    stations.put(Integer.parseInt(input[0]), new ArrayList<>());
                }

                if (!stations.containsKey(Integer.parseInt(input[1]))) {
                    stations.put(Integer.parseInt(input[1]), new ArrayList<>());
                }


                stations.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
                stations.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
            }

            ArrayList<Integer> collected = new ArrayList<>();
            ArrayList<Integer> next = new ArrayList<>();
            next.add(firstStation);
            boolean reachable = false;
            while (!next.isEmpty()) {
                int searched = next.get(0);
                next.remove(0);
                collected.add(searched);


                if (collected.size() == Integer.parseInt(values[0])) {
                    reachable = true;
                    break;
                }

                for (int j = 0; j < stations.get(searched).size(); j++) {
                    if ((!next.contains(stations.get(searched).get(j))) && (!collected.contains(stations.get(searched).get(j)))) {
                        next.add(stations.get(searched).get(j));
                    }
                }
            }

            if (reachable) {
                System.out.println("reachable");
            } else {
                System.out.println("not reachable");
            }
        }
    }
}
