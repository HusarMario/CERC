package p10397;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(new File("src/p10397/input.txt"));
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int numOfBuildings = scanner.nextInt();
            TreeMap<Integer,Integer> connections = new TreeMap<>();
            ArrayList<Building> buildings = new ArrayList<>();
            ArrayList<Cable> cables = new ArrayList<>();

            for (int i = 0; i < numOfBuildings; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                Building building = new Building(i,x,y);
                buildings.add(building);
                for (int j = 0; j < i; j++) {
                    Building direction = buildings.get(j);
                    double distance = Math.sqrt(Math.pow(building.x - direction.x,2) + Math.pow(building.y - direction.y,2));
                    Cable cable = new Cable(i,j,distance);
                    cables.add(cable);
                    building.cables.add(cable);
                }
            }

            //System.out.println();

            ArrayList<Building> united = new ArrayList<>();
            int numOfCables = scanner.nextInt();
            for (int i = 0; i < numOfCables; i++) {
                int firstIndex = scanner.nextInt() - 1;
                int secondIndex = scanner.nextInt() - 1;

                int higher = Math.max(firstIndex,secondIndex);
                int lower = Math.min(firstIndex,secondIndex);

                if (higher == lower) {
                    continue;
                }

                buildings.get(higher).cables.get(lower).distance = 0;
            }

            //System.out.println();

            cables.sort(new Comparator<Cable>() {
                @Override
                public int compare(Cable o1, Cable o2) {
                    return Double.compare(o1.distance, o2.distance);
                }
            });

            /*for (Cable cable : cables) {
                System.out.println(cable.distance);
            }*/

            double totalDistance = 0;
            for (Cable cable : cables) {
                //if (united.size() == numOfBuildings) {
                    //break;
                //}
                Building one = buildings.get(cable.one);
                Building two = buildings.get(cable.two);

                if (united.isEmpty()) {
                    united.add(one);
                }

                if (united.contains(one) || united.contains(two)) {
                    if (united.contains(one) && united.contains(two)) {
                        continue;
                    }

                    if (united.contains(one)) {
                        united.add(two);
                        united.addAll(two.connected);
                        totalDistance += cable.distance;
                        continue;
                    }

                    if (united.contains(two)) {
                        united.add(one);
                        united.addAll(one.connected);
                        totalDistance += cable.distance;
                        continue;
                    }
                }

                if (one.connected.contains(two)) {
                    continue;
                }

                totalDistance += cable.distance;
                Set<Building> set = new LinkedHashSet<>();
                set.add(one);
                set.add(two);
                set.addAll(one.connected);
                set.addAll(two.connected);
                one.connected.clear();
                two.connected.clear();
                for (Building building : set) {
                    building.connected.addAll(set);
                }
            }
            System.out.printf(Locale.US, "%.2f\n", totalDistance);
        }
    }

    public static class Building {
        int tag;
        int x;
        int y;
        ArrayList<Cable> cables;
        ArrayList<Building> connected;

        public Building(int tag, int x, int y) {
            this.tag = tag;
            this.x = x;
            this.y = y;
            cables = new ArrayList<>();
            connected = new ArrayList<>();
        }
    }

    public static class Cable {
        int one;
        int two;
        double distance;

        public Cable(int one, int two, double distance) {
            this.one = one;
            this.two = two;
            this.distance = distance;
        }
    }
}
