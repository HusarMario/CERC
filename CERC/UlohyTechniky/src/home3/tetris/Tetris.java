package home3.tetris;

import java.io.*;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Tetris {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/home3/tetris/input.txt"));

        int test = Integer.parseInt(bufferedReader.readLine());

        for (int a = 0; a < test; a++) {
            String input = bufferedReader.readLine();

            int i = 0;
            int l = 0;
            int j = 0;
            int t = 0;
            int o = 0;
            int s = 0;
            int z = 0;
            char prev = 'x';
            boolean pair = false;
            boolean doublepair = false;

            if (input.length() < 7) {
                for (int b = 0; b < input.length(); b++) {
                    if (prev == input.charAt(b)) {
                        if (pair) {
                            doublepair = true;
                        }
                        pair = true;
                    }
                    prev = input.charAt(b);

                    switch (input.charAt(b)) {
                        case 'I' : {
                            i++;
                            break;
                        }
                        case 'L' : {
                            l++;
                            break;
                        }
                        case 'J' : {
                            j++;
                            break;
                        }
                        case 'T' : {
                            t++;
                            break;
                        }
                        case 'O' : {
                            o++;
                            break;
                        }
                        case 'S' : {
                            s++;
                            break;
                        }
                        case 'Z' : {
                            z++;
                            break;
                        }
                    }
                }

                if ((i < 3) && (l < 3) && (j < 3) && (t < 3) && (o < 3) && (s < 3) && (z < 3) && (!doublepair)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                boolean safe = true;
                for (int b = 0; b < input.length() - 6; b++) {

                    prev = 'x';
                    pair = false;
                    doublepair = false;

                    i = 0;
                    l = 0;
                    j = 0;
                    t = 0;
                    o = 0;
                    s = 0;
                    z = 0;

                    if (prev == input.charAt(b)) {
                        if (pair) {
                            doublepair = true;
                        }
                        pair = true;
                    }
                    prev = input.charAt(b);
                    switch (input.charAt(b)) {
                        case 'I' : {
                            i++;
                            break;
                        }
                        case 'L' : {
                            l++;
                            break;
                        }
                        case 'J' : {
                            j++;
                            break;
                        }
                        case 'T' : {
                            t++;
                            break;
                        }
                        case 'O' : {
                            o++;
                            break;
                        }
                        case 'S' : {
                            s++;
                            break;
                        }
                        case 'Z' : {
                            z++;
                            break;
                        }
                    }
                    if (prev == input.charAt(b + 1)) {
                        if (pair) {
                            doublepair = true;
                        }
                        pair = true;
                    }
                    prev = input.charAt(b + 1);
                    switch (input.charAt(b + 1)) {
                        case 'I' : {
                            i++;
                            break;
                        }
                        case 'L' : {
                            l++;
                            break;
                        }
                        case 'J' : {
                            j++;
                            break;
                        }
                        case 'T' : {
                            t++;
                            break;
                        }
                        case 'O' : {
                            o++;
                            break;
                        }
                        case 'S' : {
                            s++;
                            break;
                        }
                        case 'Z' : {
                            z++;
                            break;
                        }
                    }
                    if (prev == input.charAt(b + 2)) {
                        if (pair) {
                            doublepair = true;
                        }
                        pair = true;
                    }
                    prev = input.charAt(b + 2);
                    switch (input.charAt(b + 2)) {
                        case 'I' : {
                            i++;
                            break;
                        }
                        case 'L' : {
                            l++;
                            break;
                        }
                        case 'J' : {
                            j++;
                            break;
                        }
                        case 'T' : {
                            t++;
                            break;
                        }
                        case 'O' : {
                            o++;
                            break;
                        }
                        case 'S' : {
                            s++;
                            break;
                        }
                        case 'Z' : {
                            z++;
                            break;
                        }
                    }
                    if (prev == input.charAt(b + 3)) {
                        if (pair) {
                            doublepair = true;
                        }
                        pair = true;
                    }
                    prev = input.charAt(b + 3);
                    switch (input.charAt(b + 3)) {
                        case 'I' : {
                            i++;
                            break;
                        }
                        case 'L' : {
                            l++;
                            break;
                        }
                        case 'J' : {
                            j++;
                            break;
                        }
                        case 'T' : {
                            t++;
                            break;
                        }
                        case 'O' : {
                            o++;
                            break;
                        }
                        case 'S' : {
                            s++;
                            break;
                        }
                        case 'Z' : {
                            z++;
                            break;
                        }
                    }
                    if (prev == input.charAt(b + 4)) {
                        if (pair) {
                            doublepair = true;
                        }
                        pair = true;
                    }
                    prev = input.charAt(b + 4);
                    switch (input.charAt(b + 4)) {
                        case 'I' : {
                            i++;
                            break;
                        }
                        case 'L' : {
                            l++;
                            break;
                        }
                        case 'J' : {
                            j++;
                            break;
                        }
                        case 'T' : {
                            t++;
                            break;
                        }
                        case 'O' : {
                            o++;
                            break;
                        }
                        case 'S' : {
                            s++;
                            break;
                        }
                        case 'Z' : {
                            z++;
                            break;
                        }
                    }
                    if (prev == input.charAt(b + 5)) {
                        if (pair) {
                            doublepair = true;
                        }
                        pair = true;
                    }
                    prev = input.charAt(b + 5);
                    switch (input.charAt(b + 5)) {
                        case 'I' : {
                            i++;
                            break;
                        }
                        case 'L' : {
                            l++;
                            break;
                        }
                        case 'J' : {
                            j++;
                            break;
                        }
                        case 'T' : {
                            t++;
                            break;
                        }
                        case 'O' : {
                            o++;
                            break;
                        }
                        case 'S' : {
                            s++;
                            break;
                        }
                        case 'Z' : {
                            z++;
                            break;
                        }
                    }
                    if (prev == input.charAt(b + 6)) {
                        if (pair) {
                            doublepair = true;
                        }
                        pair = true;
                    }
                    prev = input.charAt(b + 6);
                    switch (input.charAt(b + 6)) {
                        case 'I' : {
                            i++;
                            break;
                        }
                        case 'L' : {
                            l++;
                            break;
                        }
                        case 'J' : {
                            j++;
                            break;
                        }
                        case 'T' : {
                            t++;
                            break;
                        }
                        case 'O' : {
                            o++;
                            break;
                        }
                        case 'S' : {
                            s++;
                            break;
                        }
                        case 'Z' : {
                            z++;
                            break;
                        }
                    }

                    if  (!(i < 3) || !(l < 3) || !(j < 3) || !(t < 3) || !(o < 3) || !(s < 3) || !(z < 3) || (doublepair)) {
                        System.out.println(0);
                        System.out.println(input.charAt(b));
                        System.out.println(input.charAt(b + 1));
                        System.out.println(input.charAt(b + 2));
                        System.out.println(input.charAt(b + 3));
                        System.out.println(input.charAt(b + 4));
                        System.out.println(input.charAt(b + 5));
                        System.out.println(input.charAt(b + 6));
                        safe = false;
                        break;
                    }
                }
                if (safe) {
                    System.out.println(1);
                }
            }
        }
    }
}
