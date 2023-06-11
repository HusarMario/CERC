import java.io.*;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int pocet = 0;

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String result = bufferedReader.readLine();
            if (!treeMap.containsKey(result)) {
                treeMap.put(result,1);
            } else {
                treeMap.put(result, treeMap.get(result) + 1);
                /*if (treeMap.get(result) % 2 == 0) {
                    pocet++;
                }*/
            }
        }

        for (int i = 0; i < n; i++) {
            String result = bufferedReader.readLine();
            if (!treeMap.containsKey(result)) {
                continue;
            }

            if (!map.containsKey(result)) {
                map.put(result,1);
            } else {
                map.put(result, map.get(result) + 1);
            }

            if (map.get(result) <= treeMap.get(result)){
                pocet++;
            }
        }
        System.out.println(pocet);
    }
}
