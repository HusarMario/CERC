package exercise1.football;

import java.util.Scanner;

public class Football {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMatches = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfMatches; i++) {

            Team[] teams = new Team[4];
            for (int j = 0; j < 4; j++) {
                String input = scanner.nextLine();
                String shortcut = "" + input.charAt(0) + input.charAt(1) + input.charAt(2);
                String name = "" + input.replaceFirst(shortcut + " ", "");
                teams[j] = new Team(name, shortcut);
            }

            scanner.nextLine();

            Match[] matches = new Match[12];
            for (int j = 0; j < 12; j++) {
                String input = scanner.nextLine();
                String home = input.substring(0, input.indexOf(" -"));
                String score = "" + input.charAt(input.length() - 3) + input.charAt(input.length() - 2) + input.charAt(input.length() - 1);
                String out = input.substring(input.indexOf("- "), input.indexOf(" " + score));
                out = out.replaceFirst("- ", "");
                matches[j] = new Match(home, out, score);
            }

            for (int j = 0; j < 12; j++) {
                for (int k = 0; k < 4; k++) {
                    if (teams[k].getName().equals(matches[j].getHome())) {
                        teams[k].attachMatch(matches[j]);
                        break;
                    }
                }
            }

            teams[0].order(teams[1], teams[2], teams[3]);
            teams[1].order(teams[0], teams[2], teams[3]);
            teams[2].order(teams[0], teams[1], teams[3]);
            teams[3].order(teams[0], teams[1], teams[2]);

            System.out.println("+---+---+---+---+---+");
            System.out.printf("|   |%s|%s|%s|%s|\n", teams[0].getShortcut(), teams[1].getShortcut(), teams[2].getShortcut(), teams[3].getShortcut());
            System.out.println("+---+---+---+---+---+");
            System.out.printf("|%s| x |%s|%s|%s|\n", teams[0].getShortcut(), teams[0].getMatches()[0].getScore(), teams[0].getMatches()[1].getScore(), teams[0].getMatches()[2].getScore());
            System.out.println("+---+---+---+---+---+");
            System.out.printf("|%s|%s| x |%s|%s|\n", teams[1].getShortcut(), teams[1].getMatches()[0].getScore(), teams[1].getMatches()[1].getScore(), teams[1].getMatches()[2].getScore());
            System.out.println("+---+---+---+---+---+");
            System.out.printf("|%s|%s|%s| x |%s|\n", teams[2].getShortcut(), teams[2].getMatches()[0].getScore(), teams[2].getMatches()[1].getScore(), teams[2].getMatches()[2].getScore());
            System.out.println("+---+---+---+---+---+");
            System.out.printf("|%s|%s|%s|%s| x |\n", teams[3].getShortcut(), teams[3].getMatches()[0].getScore(), teams[3].getMatches()[1].getScore(), teams[3].getMatches()[2].getScore());
            System.out.println("+---+---+---+---+---+");

            if (i != numberOfMatches - 1) {
                System.out.println();
                scanner.nextLine();
            }
        }
    }
}

