public class Game {

    //Data Fields
    private int id;
    private double temperature;
    private Team away;
    private Team home;
    private int away_score;
    private int home_score;

    //Constructors
    public Game(int id, double temperature, Team away, Team home, int away_score, int home_score) {
        this.id = id;
        this.temperature = temperature;
        this.away = away;
        this.home = home;
        this.away_score = away_score;
        this.home_score = home_score;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public int getAway_score() {
        return away_score;
    }

    public void setAway_score(int away_score) {
        this.away_score = away_score;
    }

    public int getHome_score() {
        return home_score;
    }

    public void setHome_score(int home_score) {
        this.home_score = home_score;
    }

    public void print_stats() {
        System.out.println("Game #" + id);
        System.out.printf("Temperature: %.2f°F\n", temperature);
        System.out.println("Away Team: " + away.getName() + ", Goals Scored: " + getAway_score());
        System.out.println("Home Team: " + home.getName() + ", Goals Scored: " + getHome_score() + "\n");
    }
}
