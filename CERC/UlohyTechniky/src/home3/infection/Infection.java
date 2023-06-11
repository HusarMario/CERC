package home3.infection;

import java.io.*;
import java.util.ArrayList;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Infection {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/home3/infection/input.txt"));

        String input = bufferedReader.readLine();
        String[] firstValues = input.split(" ");

        int numofpeople = Integer.parseInt(firstValues[0]);
        int friendships = Integer.parseInt(firstValues[1]);

        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < numofpeople; i++) {
            people.add(new Person());
        }

        for (int i = 0; i < friendships; i++) {
            String friendship = bufferedReader.readLine();
            String[] friends = friendship.split(" ");
            people.get(Integer.parseInt(friends[0])).addFriend(people.get(Integer.parseInt(friends[1])));
            people.get(Integer.parseInt(friends[1])).addFriend(people.get(Integer.parseInt(friends[0])));
        }

        int tests = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < tests; i++) {
            int first = Integer.parseInt(bufferedReader.readLine());

            ArrayList<Person> healthy = new ArrayList<>(people);
            ArrayList<Person> sick = new ArrayList<>();
            ArrayList<Person> infected = new ArrayList<>();

            infected.add(healthy.get(first));
            healthy.remove(healthy.get(first));

            int day = 0;
            int infection = 0;

            if (infected.get(0).getFriends().isEmpty()) {
                System.out.println(0);
            } else {
                int index = 1;
                while (true) {
                    int count = 0;

                    if (healthy.isEmpty()) {
                        break;
                    }

                    if (infected.isEmpty()) {
                        break;
                    }

                    for (Person person : infected) {
                        for (Person friend : person.getFriends()) {
                            if (healthy.contains(friend)) {
                                healthy.remove(friend);
                                sick.add(friend);
                                count++;
                            }
                        }
                    }

                    infected.clear();
                    infected.addAll(sick);
                    sick.clear();

                    if (count > infection) {
                        infection = count;
                        day = index;
                    }
                    index++;
                }

                System.out.println(infection + " " + day);
            }


        }
    }
}
