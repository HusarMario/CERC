package p677;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static ArrayList<ArrayList<Point>> ANSWERS = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(new File("src/p677/input.txt"));

        while (true) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            ArrayList<Point> points = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        points.add(new Point(j + 1));
                    }

                    if (scanner.nextInt() == 1) {
                        points.get(i).connections.add(points.get(j));
                    }
                }
            }

            /*for (Point point : points) {
                System.out.println(point.index);
                System.out.println(point.connections);
                System.out.println();
            }*/

            ANSWERS.clear();
            ArrayList<Point> pAnswer = new ArrayList<>();
            pAnswer.add(points.get(0));
            deepSearch(k, pAnswer);

            if (ANSWERS.isEmpty()) {
                System.out.println("no walk of length " + k);
            } else {
                for (ArrayList<Point> answer : ANSWERS) {
                    System.out.print("(");
                    for (Point point : answer) {
                        if (point.index != 1) {
                            System.out.print(",");
                        }
                        System.out.print(point.index);
                    }
                    System.out.print(")");
                    System.out.println();
                }
            }



            if (scanner.hasNext()) {
                scanner.nextInt();
                System.out.println();
            } else {
                break;
            }
        }
    }

    public static class Point {
        int index;
        ArrayList<Point> connections;

        public Point(int index) {
            this.index = index;
            this.connections = new ArrayList<>();
        }
    }

    public static void deepSearch(int k, ArrayList<Point> pAnswer) {
        if (k == 0) {
            ArrayList<Point> answer = new ArrayList<>(pAnswer);
            ANSWERS.add(answer);
            return;
        }

        for (Point point1 : pAnswer.get(pAnswer.size()-1).connections) {
            if (pAnswer.contains(point1)) {
                continue;
            }
            pAnswer.add(point1);
            deepSearch(k-1,pAnswer);
            pAnswer.remove(point1);
        }
    }
}
