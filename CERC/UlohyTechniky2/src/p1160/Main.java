package p1160;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/p1160/input.txt"));


        String line;
        while ((line = bufferedReader.readLine()) != null) {

            ArrayList<Connection> connections = new ArrayList<>();
            TreeMap<Integer, Integer> indexesOfConnection = new TreeMap<>();
            int skips = 0;

            while (!line.equals("-1")) {

                String[] values = line.split(" ");
                int from = Integer.parseInt(values[0]);
                int to = Integer.parseInt(values[1]);

                if (!indexesOfConnection.containsKey(from)) {
                    indexesOfConnection.put(from, connections.size());
                    connections.add(new Connection(connections.size()));
                    connections.get(connections.size() - 1).numbers.add(from);
                }

                if (!indexesOfConnection.containsKey(to)) {
                    indexesOfConnection.put(to, connections.size());
                    connections.add(new Connection(connections.size()));
                    connections.get(connections.size() - 1).numbers.add(to);
                }

                if (indexesOfConnection.get(from).intValue() != indexesOfConnection.get(to).intValue()) {
                    int direction = indexesOfConnection.get(from);
                    int source = indexesOfConnection.get(to);

                    for (int i = 0; i < connections.get(source).numbers.size(); i++) {
                        indexesOfConnection.replace(connections.get(source).numbers.get(i), direction);
                        connections.get(direction).numbers.add(connections.get(source).numbers.get(i));
                    }

                    connections.get(source).numbers.clear();
                } else {
                    skips++;
                }

                line = bufferedReader.readLine();
            }

            System.out.println(skips);
            bufferedReader.readLine();
        }
    }

    public static class Connection {
        int index;
        ArrayList<Integer> numbers;

        public Connection(int index) {
            this.index = index;
            this.numbers = new ArrayList<>();
        }
    }
}
