package home3.takeabreak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Break {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/home3/takeabreak/input.txt"));

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


            //System.out.println(Arrays.toString(lines));

            ArrayList<Integer> startsBreak = new ArrayList<>();
            ArrayList<Integer> endsBreak = new ArrayList<>();


            if (!lines.get(0).startsWith("10:00")) {
                startsBreak.add(0);
                String end = lines.get(0).substring(0, 5); //TODO
                String endHours = end.substring(1, 2);
                String endMinutes = end.substring(3, 5);
                int intEndHours = Integer.parseInt(endHours);
                intEndHours *= 60;
                int intEndMinutes = Integer.parseInt(endMinutes);
                intEndMinutes += intEndHours;


                endsBreak.add(intEndMinutes);
            }

            for (String s : lines) {
                String start = s.substring(6, 11);
                String startHours = start.substring(1, 2);
                String startMinutes = start.substring(3, 5);
                int intStartHours = Integer.parseInt(startHours);
                intStartHours *= 60;
                int intStartMinutes = Integer.parseInt(startMinutes);
                intStartMinutes += intStartHours;
                startsBreak.add(intStartMinutes);

                if (!s.equals(lines.get(0))) {
                    String end = s.substring(0, 5);
                    String endHours = end.substring(1, 2);
                    String endMinutes = end.substring(3, 5);
                    int intEndHours = Integer.parseInt(endHours);
                    intEndHours *= 60;
                    int intEndMinutes = Integer.parseInt(endMinutes);
                    intEndMinutes += intEndHours;
                    endsBreak.add(intEndMinutes);
                }
            }
            endsBreak.add(480);

            //System.out.println(startsBreak);
            //System.out.println(endsBreak);

            int index = -1;
            int max = 0;
            for (int i = 0; i < startsBreak.size(); i++) {
                if (endsBreak.get(i) - startsBreak.get(i) != 0) {
                    int result = endsBreak.get(i) - startsBreak.get(i);
                    if (result > max) {
                        max = result;
                        index = i;
                    }
                }
            }

            //System.out.println(index + " " + max);
            //System.out.println();

            int startAnswer = 1000;
            startAnswer += (startsBreak.get(index) / 60) * 100;
            startAnswer += (startsBreak.get(index) % 60);
            String stringStartAnswer = Integer.toString(startAnswer);
            String finalStringStartAnswer = "";
            finalStringStartAnswer = stringStartAnswer.charAt(0) + "" + stringStartAnswer.charAt(1) + ":" + stringStartAnswer.charAt(2) + "" + stringStartAnswer.charAt(3);
            //System.out.println(finalStringStartAnswer);

            if (max < 60) {
                System.out.printf("Day #%d: the longest nap starts at %s and will last for %d minutes.\n", day, finalStringStartAnswer, max);
            } else {
                System.out.printf("Day #%d: the longest nap starts at %s and will last for %d hours and %d minutes.\n", day, finalStringStartAnswer, (max / 60), (max % 60));
            }
        }
    }
}
