package p11110;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/p11110/input.txt"));

        while (true) {
            String input = bufferedReader.readLine();
            int n = Integer.parseInt(input);
            if (n == 0) {
                break;
            }

            if (n == 1) {
                System.out.println("good");
                continue;
            }

            Square square = new Square(n);
            ArrayList<Cell> firstCells = new ArrayList<>();
            String[] inputs;
            boolean problem = false;

            for (int i = 0; i < n - 1; i++) {
                input = bufferedReader.readLine();
                inputs = input.split(" ");

                if (inputs.length % 2 != 0) {
                    problem = true;
                    break;
                }

                int duplicate = duplicates(inputs, n);

                if (inputs.length - duplicate != n*2) {
                    problem = true;
                    break;
                }

                for (int j = 0; j < inputs.length; j = j + 2) {
                    Cell cell = square.addCell(i + 1, Integer.parseInt(inputs[j]) - 1, Integer.parseInt(inputs[j + 1]) - 1);
                    if (j == 0) {
                        firstCells.add(cell);
                    }
                }
            }
            if (problem) {
                System.out.println("wrong");
                continue;
            }

            boolean end = true;
            //square.showCell();
            firstCells.add(square.connect());
            for (Cell cell : firstCells) {
                count = n;
                if (!square.equidivision(cell)) {
                    end = false;
                    break;
                }
            }

            if (end) {
                System.out.println("good");
            } else {
                System.out.println("wrong");
            }
            //System.out.println();
        }


    }

    public static class Cell {
        private int partition;
        private int x;
        private int y;
        
        private Cell up;
        private Cell down;
        private Cell left;
        private Cell right;

        private boolean checked;

        public Cell(int partition, int x, int y) {
            this.partition = partition;
            this.x = x - 1;
            this.y = y - 1;
            this.checked = false;
        }
    }

    public static class Square {
        private Cell model[][];

        public Square(int n) {
            this.model = new Cell[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    this.model[i][j] = new Cell(n, i, j);
                }
            }
        }

        public Cell addCell(int partition, int i, int j) {
            this.model[i][j].partition = partition;
            return this.model[i][j];
        }

        public void showCell() {
            for (Cell[] cells : model) {
                for (Cell cell : cells) {
                    System.out.print(cell.partition + " ");
                }
                System.out.println();
            }
        }
        
        public Cell connect() {
            Cell cell = null;
            for (int i = 0; i < model.length; i++) {
                for (int j = 0; j < model[i].length; j++) {
                    if (model[i][j].partition == model.length) {
                        cell = model[i][j];
                    }

                    if (i != 0) {
                        model[i][j].up = model[i - 1][j];
                    }

                    if (i != model.length - 1) {
                        model[i][j].down = model[i + 1][j];
                    }

                    if (j != 0) {
                        model[i][j].left = model[i][j - 1];
                    }

                    if (j != model[i].length - 1) {
                        model[i][j].right = model[i][j + 1];
                    }
                }
            }
            return cell;
        }

        public boolean equidivision(Cell cell) {
            cell.checked = true;
            count--;
            if (count == 0) {
                return true;
            }

            if (cell.up != null && cell.up.partition == cell.partition && !cell.up.checked) {
                equidivision(cell.up);
            }

            if (cell.down != null && cell.down.partition == cell.partition && !cell.down.checked) {
                equidivision(cell.down);
            }

            if (cell.right != null && cell.right.partition == cell.partition && !cell.right.checked) {
                equidivision(cell.right);
            }

            if (cell.left != null && cell.left.partition == cell.partition && !cell.left.checked) {
                equidivision(cell.left);
            }

            return count == 0;
        }
    }

    private static int duplicates(String[] inputs, int n) {
        int duplicate = 0;

        for (int i = 0; i < inputs.length; i = i + 2) {
            for (int j = 0; j < inputs.length; j = j + 2) {
                if (Objects.equals(inputs[i], inputs[j]) && Objects.equals(inputs[i + 1], inputs[j + 1])) {
                    duplicate += 2;
                    break;
                }
            }
        }

        duplicate -= n * 2;

        return duplicate;
    }
}
