package exercise1.cubes;

import java.util.Scanner;

public class Cubes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            int x = Integer.parseInt(input);
            if (x == 0) {
                break;
            } else {
                x *= x * x;
                System.out.println(x);
            }

        }
    }
}
