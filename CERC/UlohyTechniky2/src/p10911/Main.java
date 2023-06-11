package p10911;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static double ANSWER = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/p10911/input.txt"));

        int index = 1;
        while (true) {
            int n = Integer.parseInt(bufferedReader.readLine());
            n = n * 2;
            if (n == 0) {
                return;
            }

            ArrayList<Person> people = new ArrayList<>();
            ArrayList<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = bufferedReader.readLine();
                String[] values = line.split(" ");
                String name = values[0];
                int x = Integer.parseInt(values[1]);
                int y = Integer.parseInt(values[2]);
                Person added = new Person(name, x, y);
                people.add(added);

                for (int j = 0; j < i; j++) {
                    Person person = people.get(j);

                    if (person.equals(added)) {
                        continue;
                    }

                    double distance = Math.sqrt(Math.pow(added.x - person.x,2) + (Math.pow(added.y - person.y,2)));
                    Pair pair = new Pair(person,added,distance);
                    person.distances.add(pair);
                    added.distances.add(pair);
                    pairs.add(pair);
                }

            }

            pairs.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return Double.compare(o1.distance, o2.distance);
                }
            });

            ANSWER = Integer.MAX_VALUE;
            //System.out.println('A');
            //dajHodnotu(pairs, new ArrayList<>(people));
            //System.out.println("Priblizne " + ANSWER);
            //hladajPar(people,0);
            //System.out.println(ANSWER);

            preskumajDvojice(pairs,people,0);

            System.out.printf(Locale.US,"Case %d: %.2f\n",index,ANSWER);
            index++;
        }
    }

    public static void preskumajDvojice(ArrayList<Pair> pairs, ArrayList<Person> people, double answer) {
        if (people.size() == 0) {
            if (answer < ANSWER) {
                ANSWER = answer;
            }
            return;
        }

        if (answer > ANSWER) {
            return;
        }

        Person person = people.get(0);
        ArrayList<Pair> used = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i++) {
            if (!people.contains(pairs.get(i).a) || (!people.contains(pairs.get(i).b))) {
                continue;
            }

            if (!pairs.get(i).a.equals(person) && !pairs.get(i).b.equals(person)) {
                continue;
            }


            used.add(pairs.get(i));
            double newAnswer = answer + pairs.get(i).distance;

            if (newAnswer > ANSWER) {
                continue;
            }

            ArrayList<Person> newPeople = new ArrayList<>(people);
            newPeople.remove(pairs.get(i).a);
            newPeople.remove(pairs.get(i).b);

            ArrayList<Pair> newPairs = new ArrayList<>(pairs);
            newPairs.removeAll(used);
            newPairs.removeAll(pairs.get(i).a.distances);
            newPairs.removeAll(pairs.get(i).b.distances);

            preskumajDvojice(newPairs,newPeople,newAnswer);

        }

    }

    public static void dajHodnotu(ArrayList<Pair> pairs, ArrayList<Person> people) {
        for (Pair pair : pairs) {
            if (people.isEmpty()) {
                return;
            }

            if (!people.contains(pair.a)) {
                continue;
            }

            if (!people.contains(pair.b)) {
                continue;
            }

            ANSWER += pair.distance;
            people.remove(pair.a);
            people.remove(pair.b);
        }
    }

    public static void hladajPar(ArrayList<Person> people, double answer) {
        if (answer > ANSWER) {
            return;
        }

        if (people.size() == 0) {
            if (answer < ANSWER) {
                ANSWER = answer;
            }
        }

        ArrayList<Person> used = new ArrayList<>();
        for (Person person : people) {
            for (Pair pair : person.distances) {
                if (used.contains(pair.b)) {
                    continue;
                }

                if (!people.contains(pair.b)) {
                    continue;
                }

                //System.out.println(pair.a + " " + pair.b);
                double newAnswer = answer + pair.distance;
                if (newAnswer > ANSWER) {
                    continue;
                }

                ArrayList<Person> next = new ArrayList<>(people);
                next.remove(pair.a);
                next.remove(pair.b);
                hladajPar(next,newAnswer);
            }
            used.add(person);
        }
    }

    public static class Person {
        String name;
        int x;
        int y;
        ArrayList<Pair> distances;

        public Person(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.distances = new ArrayList<>();
        }
    }

    public static class Pair {
        Person a;
        Person b;
        double distance;

        public Pair(Person a, Person b, double distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }
    }
}
