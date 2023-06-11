package p11504;

import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Connection> ordered = new ArrayList<>();
    public static ArrayList<Connection> finished = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/p11504/input.txt"));

        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            String line = bufferedReader.readLine();
            String[] values = line.split(" ");

            int numOfDominos = Integer.parseInt(values[0]);
            int numOfConnections = Integer.parseInt(values[1]);

            TreeMap<Integer, Connection> map = new TreeMap<>();
            TreeMap<Integer, Connection> repeat = new TreeMap<>();
            finished.clear();
            ordered.clear();


            for (int j = 0; j < numOfConnections; j++) {
                values = bufferedReader.readLine().split(" ");
                int from = Integer.parseInt(values[0]);
                int to = Integer.parseInt(values[1]);

                if (!map.containsKey(from)) {
                    map.put(from,new Connection(from));
                    repeat.put(from,new Connection(from));
                }

                if (!map.containsKey(to)) {
                    map.put(to,new Connection(to));
                    repeat.put(to,new Connection(to));
                }

                map.get(from).put(map.get(to));
                repeat.get(from).put(repeat.get(to));
            }

            int pocet = numOfDominos - map.size();
            for (Connection value : map.values()) {
                if (!value.complete) {
                    DFSorder(value);
                }
            }

            Collections.reverse(ordered);
            int index = 0;
            while (true) {
                if (finished.size() == map.size()) {
                    break;
                }

                Connection connection = repeat.get(ordered.get(index).index);
                if (!connection.complete) {
                    DFSfinish(connection);
                    pocet++;
                }

                index++;
            }

            System.out.println(pocet);
        }
    }

    public static class Connection {
        ArrayList<Connection> input;
        ArrayList<Connection> output;
        int index;
        int level;
        boolean complete;

        public Connection(int index) {
            this.index = index;
            this.level = 0;
            input = new ArrayList<>();
            output = new ArrayList<>();
            complete = false;
        }

        public void put(Connection connection) {
            if (output.contains(connection)) {
                return;
            }

            output.add(connection);
            connection.input.add(this);
        }
    }

    public static void DFSorder(Connection connection) {
        connection.complete = true;

        for (Connection next : connection.output) {
            if (!next.complete) {
                DFSorder(next);
            }
        }

        ordered.add(connection);
    }

    public static void DFSfinish(Connection connection) {
        connection.complete = true;

        for (Connection next : connection.output) {
            if (!next.complete) {
                DFSfinish(next);
            }
        }

        finished.add(connection);
    }
}
