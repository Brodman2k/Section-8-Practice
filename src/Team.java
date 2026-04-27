public class Team {

    // Data Fields
    private String name;
    private int wins_total;
    private int losses_total;
    private int draws_total;
    private int total_goals_scored;
    private int total_goals_allowed;

    // Constructors
    public Team(String name) {
        this.name = name;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins_total() {
        return wins_total;
    }

    public void setWins_total(int wins_total) {
        this.wins_total = wins_total;
    }

    public int getLosses_total() {
        return losses_total;
    }

    public void setLosses_total(int losses_total) {
        this.losses_total = losses_total;
    }

    public int getDraws_total() {
        return draws_total;
    }

    public void setDraws_total(int draws_total) {
        this.draws_total = draws_total;
    }

    public int getTotal_goals_scored() {
        return total_goals_scored;
    }

    public void setTotal_goals_scored(int total_goals_scored) {
        this.total_goals_scored = total_goals_scored;
    }

    public int getTotal_goals_allowed() {
        return total_goals_allowed;
    }

    public void setTotal_goals_allowed(int total_goals_allowed) {
        this.total_goals_allowed = total_goals_allowed;
    }

    public void print_stats() {
        System.out.println(this.name);
        System.out.print("Wins: " + this.wins_total + ", ");
        System.out.print("Losses: " + this.losses_total + ", ");
        System.out.println("Draws: " + this.draws_total);
        System.out.print("Goals scored: " + this.total_goals_scored + ", ");
        System.out.println("Goals allowed: " + this.total_goals_allowed + "\n");
    }
}
