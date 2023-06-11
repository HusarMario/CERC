package home2.dictionary;

import java.io.*;
import java.util.*;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Dictionary {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/home2/dictionary/input.txt"));

        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            String oldinput = bufferedReader.readLine();
            String newinput = bufferedReader.readLine();

            if ((oldinput.length() == 2) && (newinput.length() == 2)) {
                System.out.println("No changes");
                if (i != t - 1) {
                    System.out.println();
                }
                continue;
            }

            if (oldinput.length() == 2) {
                System.out.print("+");
                newinput = newinput.substring(1, newinput.length() - 1);
                String[] newEntries = newinput.split(",");
                int count  = newEntries.length;

                List<String> newList = new LinkedList<>(Arrays.asList(newEntries));
                newList.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });

                for (String newEntry : newList) {
                    String[] values = newEntry.split(":");
                    System.out.print(values[0]);
                    count--;
                    if (count != 0) {
                        System.out.print(",");
                    }
                }
                System.out.println();
                if (i != t - 1) {
                    System.out.println();
                }
                continue;
            }

            if (newinput.length() == 2) {
                System.out.print("-");
                oldinput = oldinput.substring(1, oldinput.length() - 1);
                String[] oldEntries = oldinput.split(",");
                int count = oldEntries.length;

                List<String> oldList = new LinkedList<>(Arrays.asList(oldEntries));
                oldList.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });

                for (String oldEntry : oldList) {
                    String[] values = oldEntry.split(":");
                    System.out.print(values[0]);
                    count--;
                    if (count != 0) {
                        System.out.print(",");
                    }
                }
                System.out.println();
                if (i != t - 1) {
                    System.out.println();
                }
                continue;
            }

            oldinput = oldinput.substring(1, oldinput.length() - 1);
            newinput = newinput.substring(1, newinput.length() - 1);

            String[] oldEntries = oldinput.split(",");
            String[] newEntries = newinput.split(",");

            List<String> oldList = new LinkedList<>(Arrays.asList(oldEntries));
            oldList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            List<String> newList = new LinkedList<>(Arrays.asList(newEntries));
            newList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            LinkedHashMap<String, String> oldDictionary = new LinkedHashMap<>();
            LinkedHashMap<String, String> newDictionary = new LinkedHashMap<>();

            for (String oldEntry : oldList) {
                String[] values = oldEntry.split(":");
                oldDictionary.put(values[0], values[1]);
            }

            for (String newEntry : newList) {
                String[] values = newEntry.split(":");
                newDictionary.put(values[0], values[1]);
            }



            boolean plus = false;
            for (String key : newDictionary.keySet()) {
                if (!oldDictionary.containsKey(key)) {
                    if (!plus) {
                        System.out.print("+");
                        plus = true;
                    } else {
                        System.out.print(",");
                    }
                    System.out.print(key);
                }
            }
            if (plus) {
                System.out.println();
            }

            boolean minus = false;
            for (String key : oldDictionary.keySet()) {
                if (!newDictionary.containsKey(key)) {
                    if (!minus) {
                        System.out.print("-");
                        minus = true;
                    } else {
                        System.out.print(",");
                    }
                    System.out.print(key);
                }
            }
            if (minus) {
                System.out.println();
            }

            boolean change = false;
            for (String key : newDictionary.keySet()) {
                if ((oldDictionary.containsKey(key)) && (!oldDictionary.get(key).equals(newDictionary.get(key)))) {
                    if (!change) {
                        System.out.print("*");
                        change = true;
                    } else {
                        System.out.print(",");
                    }
                    System.out.print(key);
                }
            }
            if (change) {
                System.out.println();
            }

            if ((!change) && (!plus) && (!minus)) {
                System.out.println("No changes");
            }

            if (i != t - 1) {
                System.out.println();
            }

        }
    }
}
