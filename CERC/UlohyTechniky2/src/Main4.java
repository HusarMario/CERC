import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("src/input.txt"));

        long n = scanner.nextInt();
        long k = scanner.nextInt();

        if (k >= n) {
            System.out.println(n);
        } else {

            int podiel = 2;
            while (true) {
                long zvysok = n % podiel;
                if (zvysok != 0) {
                    continue;
                }
                long suma = n / podiel;
                if (suma <= k) {
                    System.out.println(zvysok);
                    break;
                } else {
                    podiel++;
                }
            }
        }
    }


}
