package exercise1.football;

public class Team {
    private String name;
    private String shortcut;
    private Match[] matches;
    private int attachedMatches;

    public Team(String name, String shortcut) {
        this.name = name;
        this.shortcut = shortcut;
        this.matches = new Match[3];
        this.attachedMatches = 0;
    }

    public void attachMatch(Match match) {
        this.matches[this.attachedMatches] = match;
        this.attachedMatches++;
    }

    public void order(Team team0, Team team1, Team team2) {
        Match[] newMatches = new Match[3];

        for (int i = 0; i < 3; i++) {
            if (team0.getName().equals(this.matches[i].getOut())) {
                newMatches[0] = this.matches[i];
            } else if (team1.getName().equals(this.matches[i].getOut())) {
                newMatches[1] = this.matches[i];
            } else if (team2.getName().equals(this.matches[i].getOut())) {
                newMatches[2] = this.matches[i];
            }
        }

        this.matches = newMatches;
    }

    public String getName() {
        return this.name;
    }

    public String getShortcut() {
        return this.shortcut;
    }

    public Match[] getMatches() {
        return this.matches;
    }
}
