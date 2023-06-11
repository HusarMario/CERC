package exercise1.basic;

import java.util.Scanner;

public class Baisc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            System.out.println(++x);
        }
    }
}
