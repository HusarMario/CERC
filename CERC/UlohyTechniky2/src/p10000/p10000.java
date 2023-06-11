package p10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p10000 {
    static int TEST;
    static int POINTS;
    static int END;
    public static void main(String[] args) throws IOException {

        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/p10000/input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        TEST = 0;
        while (true) {
            TEST++;
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n == 0) {
                break;
            }

            ArrayList<Point> points = new ArrayList<>();
            POINTS = 0;
            int start = Integer.parseInt(bufferedReader.readLine());
            for (int i = POINTS; i < start; i++) {
                points.add(new Point(i + 1));
                POINTS++;
            }
            points.get(start - 1).visited = -1;

            while (true) {
                String input = bufferedReader.readLine();
                String[] values = input.split(" ");
                if (Integer.parseInt(values[0]) == 0 && Integer.parseInt(values[1]) == 0) {
                    break;
                }

                if (Integer.parseInt(values[0]) > Integer.parseInt(values[1])) {
                    if (Integer.parseInt(values[0]) > POINTS) {
                        for (int i = POINTS; i < Integer.parseInt(values[0]); i++) {
                            points.add(new Point(i + 1));
                            POINTS++;
                        }
                    }
                } else {
                    if (Integer.parseInt(values[1]) > POINTS) {
                        for (int i = POINTS; i < Integer.parseInt(values[1]); i++) {
                            points.add(new Point(i + 1));
                            POINTS++;
                        }
                    }
                }

                points.get(Integer.parseInt(values[0]) - 1).putNext(points.get(Integer.parseInt(values[1]) - 1));
            }

            END = start;
            int length = 0;
            ArrayList<Point> search = new ArrayList<>();
            search.add(points.get(start - 1));
            ArrayList<Point> actual = new ArrayList<>();
            while (!search.isEmpty()) {
                END = search.get(0).num;
                actual.addAll(search);
                search.clear();

                for (Point point : actual) {
                    if (point.num < END) {
                        END = point.num;
                    }
                    for (Point next : point.next) {
                        if (!search.contains(next)) {
                            search.add(next);
                        }
                    }
                }
                actual.clear();
                length++;
            }

            /*for (Point point : points) {
                System.out.println("Point: " + point.num + " with length " + point.length);
                for (Point next : point.next) {
                    System.out.print(next.num + " ");
                }
                System.out.println();
            }
            System.out.println();*/

            System.out.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n", TEST, start, length - 1, END);
            System.out.println();

        }
    }

    public static class Point {
        int num;
        int visited;
        ArrayList<Point> next;

        public Point(int num) {
            this.num = num;
            this.next = new ArrayList<>();
            this.visited = 0;
        }

        public void putNext(Point point) {
            this.next.add(point);
        }
    }
}
