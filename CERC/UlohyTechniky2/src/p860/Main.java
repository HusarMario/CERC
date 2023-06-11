package p860;

import java.io.*;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/p860/input.txt"));

        TreeMap<String,Integer> mapa = new TreeMap<>();
        int wordCount = 0;
        while (true) {
            String line = bufferedReader.readLine();

            if (line.equals("****END_OF_TEXT****")) {

                if (wordCount == 0) {
                    System.out.println("0" + " -nan" + " -nan");
                    mapa.clear();
                    wordCount = 0;
                    continue;
                }

                System.out.print(wordCount + " ");

                double entropy = 0;
                for (String s : mapa.keySet()) {
                    entropy += mapa.get(s) * (Math.log10(wordCount) - Math.log10(mapa.get(s)));
                }
                entropy /= wordCount;
                System.out.printf(Locale.CANADA, "%.1f ", entropy);

                double maxEnthropy = Math.log10(wordCount);
                double relativeEnthropy = entropy / maxEnthropy * 100;
                if (maxEnthropy == 0) {
                    System.out.println("-nan");
                } else {


                //System.out.println(relativeEnthropy);
                System.out.printf("%d\n", Math.round(relativeEnthropy));
                }


                mapa.clear();
                wordCount = 0;
                continue;
            }

            if (line.equals("****END_OF_INPUT****")) {
                //System.out.println("end");
                break;
            }

            line = line.replace(",", " ");
            line = line.replace(".", " ");
            line = line.replace(":", " ");
            line = line.replace(";", " ");
            line = line.replace("!", " ");
            line = line.replace("?", " ");
            line = line.replace("\"", " ");
            line = line.replace("(", " ");
            line = line.replace(")", " ");

            String[] words = line.split(" ");
            for (String word : words) {
                word = word.toLowerCase(Locale.ROOT);
                if (word.equals("")) {
                    continue;
                }

                if (word.equals(" ")) {
                    continue;
                }

                wordCount++;
                if (!mapa.containsKey(word)) {
                    mapa.put(word,1);
                } else {
                    mapa.put(word,mapa.get(word) + 1);
                }
            }
        }
    }
}
