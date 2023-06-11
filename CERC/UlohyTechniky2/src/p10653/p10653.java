package p10653;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class p10653 {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(new File("src/p10653/input.txt"));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            if (rows == 0 && cols == 0) {
                break;
            }

            Point[][] map = new Point[rows][cols];

            int mines = scanner.nextInt();
            if (mines == 0) {
                int startX = scanner.nextInt();
                int startY = scanner.nextInt();
                int finishX = scanner.nextInt();
                int finishY = scanner.nextInt();

                int diffX = Math.abs(startX - finishX);
                int diffY = Math.abs(startY - finishY);

                System.out.println(diffX + diffY);
                continue;
            }

            for (int i = 0; i < mines; i++) {
                int row = scanner.nextInt();
                int repeat = scanner.nextInt();
                for (int j = 0; j < repeat; j++) {
                    int col = scanner.nextInt();
                    map[row][col] = new Point(row, col, false); //bez pouzitia dijkstry -> zmen potom
                }
            }

            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            int finishX = scanner.nextInt();
            int finishY = scanner.nextInt();
            map[startX][startY] = new Point(startX, startY, true);
            map[finishX][finishY] = new Point(finishX, finishY, true);
            Point start = map[startX][startY];
            Point finish = map[finishX][finishY];

            ArrayList<Point> search = new ArrayList<>();
            ArrayList<Point> next = new ArrayList<>();
            next.add(start);
            int distance = 0;

            while (!next.isEmpty()) {
                search.addAll(next);
                next.clear();
                distance++;

                boolean found = false;
                for (Point actual : search) {

                    if (actual.x != 0) {
                        if (map[actual.x - 1][actual.y] == null) {
                            Point created = new Point(actual.x - 1, actual.y, true);
                            map[actual.x - 1][actual.y] = created;
                            next.add(created);
                        } else {
                            if (map[actual.x - 1][actual.y].equals(finish)) {
                                System.out.println(distance);
                                found = true;
                                break;
                            }
                        }
                    }

                    if (actual.y != 0) {
                        if (map[actual.x][actual.y - 1] == null) {
                            Point created = new Point(actual.x, actual.y - 1, true);
                            map[actual.x][actual.y - 1] = created;
                            next.add(created);
                        } else {
                            if (map[actual.x][actual.y - 1].equals(finish)) {
                                System.out.println(distance);
                                found = true;
                                break;
                            }
                        }
                    }

                    if (actual.x != rows - 1) {
                        if (map[actual.x + 1][actual.y] == null) {
                            Point created = new Point(actual.x + 1, actual.y, true);
                            map[actual.x + 1][actual.y] = created;
                            next.add(created);
                        } else {
                            if (map[actual.x + 1][actual.y].equals(finish)) {
                                System.out.println(distance);
                                found = true;
                                break;
                            }
                        }
                    }

                    if (actual.y != cols - 1) {
                        if (map[actual.x][actual.y + 1] == null) {
                            Point created = new Point(actual.x, actual.y + 1, true);
                            map[actual.x][actual.y + 1] = created;
                            next.add(created);
                        } else {
                            if (map[actual.x][actual.y + 1].equals(finish)) {
                                System.out.println(distance);
                                found = true;
                                break;
                            }
                        }
                    }
                }

                if (found) {
                    break;
                }

                search.clear();
            }
        }
    }

    public static class Point {
        int x;
        int y;
        boolean clear;

        public Point(int x, int y, boolean clear) {
            this.x = x;
            this.y = y;
            this.clear = clear;
        }
    }
}
