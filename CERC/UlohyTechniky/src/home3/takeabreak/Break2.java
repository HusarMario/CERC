package home3.takeabreak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Break2 {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/home3/takeabreak/input.txt"));

        String line;
        int day = 0;
        while ((line = bufferedReader.readLine()) != null) {
            day++;
            int numOfLines = Integer.parseInt(line);
            ArrayList<String> lines = new ArrayList<>();


            for (int i = 0; i < numOfLines; i++) {
                String input = bufferedReader.readLine();
                input = input.substring(0, 11);
                lines.add(input);
            }

            Collections.sort(lines);


            System.out.println((lines));

            ArrayList<Integer> startsBreak = new ArrayList<>();
            ArrayList<Integer> endsBreak = new ArrayList<>();


        }
    }
}
