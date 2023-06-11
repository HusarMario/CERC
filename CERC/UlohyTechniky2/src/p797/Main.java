package p797;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("src/p797/input.txt"));

        while (scanner.hasNext()) {
            int tunelLength = scanner.nextInt();
            int leftLength = scanner.nextInt();
            int rightLength = scanner.nextInt();
            int leftSpeed = scanner.nextInt();
            int rightSpeed = scanner.nextInt();
            int leftRate = scanner.nextInt();
            int rightRate = scanner.nextInt();
            int lowInterval = scanner.nextInt();
            int highInterval = scanner.nextInt();


        }
    }
}
