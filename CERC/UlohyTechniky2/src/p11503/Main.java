package p11503;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/p11503/input.txt"));

        int Tcases = Integer.parseInt(bufferedReader.readLine());


        for (int i = 0; i < Tcases; i++) {

            ArrayList<Connection> connections = new ArrayList<>();
            TreeMap<String, Integer> indexesOfNames = new TreeMap<>();
            int numOfConnections = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < numOfConnections; j++) {
                String[] values = bufferedReader.readLine().split(" ");

                String first = values[0];
                String second = values[1];

                if (!indexesOfNames.containsKey(first)) {
                    indexesOfNames.put(first, connections.size());
                    connections.add(new Connection(connections.size()));
                    connections.get(connections.size() - 1).names.add(first);
                }

                if (!indexesOfNames.containsKey(second)) {
                    indexesOfNames.put(second, connections.size());
                    connections.add(new Connection(connections.size()));
                    connections.get(connections.size() - 1).names.add(second);
                }

                if (indexesOfNames.get(first).intValue() != indexesOfNames.get(second).intValue()) {
                    int direction = indexesOfNames.get(first);
                    int source = indexesOfNames.get(second);

                    for (int k = 0; k < connections.get(source).names.size(); k++) {
                        indexesOfNames.replace(connections.get(source).names.get(k), direction);
                        connections.get(direction).names.add(connections.get(source).names.get(k));
                    }

                    connections.get(source).names.clear();
                }

                System.out.println(connections.get(indexesOfNames.get(first)).names.size());

            }
        }
    }

    public static class Connection {
        int index;
        ArrayList<String> names;

        public Connection(int index) {
            this.index = index;
            this.names = new ArrayList<>();
        }
    }
}
