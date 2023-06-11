import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(new File("src/input.txt"));

        int test = scanner.nextInt();
        for (int i = 0; i < test; i++) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int numOfCities = scanner.nextInt();
            int numOfPersonel = scanner.nextInt();

            City[] cities = new City[numOfCities];

            int pocet = 0;
            for (int j = 0; j < numOfPersonel; j++) {
                int a = scanner.nextInt() - 1;
                int b = scanner.nextInt() - 1;
                if (!treeMap.containsKey(a)) {
                    cities[a] = new City(a);
                    treeMap.put(a,a);
                }
                if (!treeMap.containsKey(b)) {
                    cities[b] = new City(b);
                    treeMap.put(b,b);
                }


                if (!Objects.equals(treeMap.get(a), treeMap.get(b))) {

                    pocet++;
                }
            }

            System.out.println(pocet);


        }
    }

    public  static class City {
        int index;
        ArrayList<City> connected;

        public City(int index) {
            this.index = index;
            connected = new ArrayList<>();
        }
    }

    public static class Personel {
        City from;
        City to;

        public Personel(City from, City to) {
            this.from = from;
            this.to = to;
        }
    }
}
