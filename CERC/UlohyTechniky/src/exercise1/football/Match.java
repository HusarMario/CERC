package exercise1.football;

public class Match {
    private String home;
    private String out;
    private String score;

    public Match(String home, String out, String score) {
        this.home = home;
        this.out = out;
        this.score = score;
    }

    public String getHome() {
        return this.home;
    }

    public String getOut() {
        return this.out;
    }

    public String getScore() {
        return this.score;
    }
}
