# Section 8 Practice

This project is a small Java console program that simulates a four-team season. The explanations below follow the code in order and group related lines into sections so it is easier to see what each line is doing.

## What the program does

- Creates four `Team` objects
- Repeats weekly until there are `3` consecutive weeks at `32` degrees or colder
- Generates two games on each playable week
- Uses warmer temperatures to allow higher possible scores
- Updates team wins, losses, draws, goals scored, and goals allowed
- Prints final team totals and every game that was played

## How to run

Compile from the project root:

```powershell
javac src\*.java
```

Run the program:

```powershell
java -cp src Main
```

## Code walkthrough

### `src/Main.java`

#### Imports

- `import java.util.ArrayList;` imports the `ArrayList` class so the program can store a growing list of games that were played.
- `import java.util.Random;` imports the `Random` class so the program can generate random temperatures, team selections, and scores.

#### Class declaration and entry point

- `public class Main  {` declares the `Main` class, which holds the starting point of the program.
- `public static void main(String[] args) {` declares the `main` method, which Java runs first when the program starts.

#### Team setup

- `Team team1 = new Team("Team 1");` creates a `Team` object named `Team 1`.
- `Team team2 = new Team("Team 2");` creates a `Team` object named `Team 2`.
- `Team team3 = new Team("Team 3");` creates a `Team` object named `Team 3`.
- `Team team4 = new Team("Team 4");` creates a `Team` object named `Team 4`.
- `Team [] teams = {team1, team2, team3, team4};` places all four teams into one array so they can be accessed by index later.
- `ArrayList<Game> games_played = new ArrayList<>();` creates an empty list that will hold every `Game` object that actually gets played.

#### Season control variables

- `Random rand = new Random();` creates one random number generator for the entire season.
- `int winter_weeks = 0;` starts a counter for how many cold weeks in a row have happened.
- `int gameID = 1;` starts the game numbering at `1`.

#### Main season loop

- `while (winter_weeks < 3) {` keeps the season running until there have been `3` consecutive cold weeks.

#### Weekly temperature generation

- `//Generate random temp` is a comment that labels the next step.
- `double temp = rand.nextDouble(100);` generates a random temperature from `0.0` up to, but not including, `100.0`.

#### Cold-week check

- `//Decide if game is played or not` is a comment that labels the temperature check.
- `if (temp <= 32) {` checks whether the week is too cold to play.
- `winter_weeks++;` adds `1` to the consecutive cold-week counter.
- `if (winter_weeks == 3) {` checks whether this is the third cold week in a row.
- `System.out.print("There has been 3 consecutive weeks where the temperature too cold to play. ");` prints the first part of the season-ending message without moving to a new line yet.
- `System.out.println("The season is over.\n\n");` prints the rest of the message and then adds blank lines after it.
- `}` closes the `if (winter_weeks == 3)` block.
- `continue;` skips the rest of the current loop iteration and starts the next week immediately.
- `}` closes the cold-week `if` block.

#### Playable week branch

- `else {` begins the code that runs when the temperature is warm enough to play.
- `//Game on` is a comment that labels the playable-week branch.

#### Resetting the cold streak

- `//Reset the winter_weeks` is a comment that labels the reset step.
- `winter_weeks = 0;` resets the consecutive cold-week counter because a playable week breaks the streak.

#### Choosing teams for Game 1

- `//Select Team 4 first` is a comment that labels the first scheduling rule.
- `Team home1 = teams[3];` makes `Team 4` the home team for Game 1 because it is stored at index `3`.
- `//Randomly select another team` is a comment that labels the away-team selection.
- `int awayTeam = rand.nextInt(3);` randomly picks `0`, `1`, or `2`, which correspond to `Team 1`, `Team 2`, or `Team 3`.
- `Team away1 = teams[awayTeam];` uses that random index to choose the away team for Game 1.

#### Choosing teams for Game 2

- `//Select other 2 teams for game 2` is a comment that labels the second matchup setup.
- `Team home2 = null;` declares the home team variable for Game 2 and gives it a temporary `null` value.
- `Team away2 = null;` declares the away team variable for Game 2 and gives it a temporary `null` value.
- `Game game1 = null;` declares the `Game 1` object variable before the score rules decide how it will be built.
- `Game game2 = null;` declares the `Game 2` object variable before the score rules decide how it will be built.

#### Matching the remaining teams

- `switch (awayTeam) {` selects the correct Game 2 matchup based on who was chosen to face `Team 4`.
- `case 0:` handles the case where `Team 1` was chosen as Game 1's away team.
- `home2 = teams[1];` sets `Team 2` as the home team for Game 2.
- `away2 = teams[2];` sets `Team 3` as the away team for Game 2.
- `break;` stops the switch after finishing case `0`.
- `case 1:` handles the case where `Team 2` was chosen as Game 1's away team.
- `home2 = teams[0];` sets `Team 1` as the home team for Game 2.
- `away2 = teams[2];` sets `Team 3` as the away team for Game 2.
- `break;` stops the switch after finishing case `1`.
- `case 2:` handles the case where `Team 3` was chosen as Game 1's away team.
- `home2 = teams[0];` sets `Team 1` as the home team for Game 2.
- `away2 = teams[1];` sets `Team 2` as the away team for Game 2.
- `break;` stops the switch after finishing case `2`.
- `}` closes the `switch` block.

#### Creating games and scores from temperature

- `//Generate scores` is a comment that labels the scoring logic.
- `if (temp <= 49){` uses the coldest playable range and limits each team to scores from `0` to `5`.
- `game1 = new Game (gameID, temp, away1, home1, rand.nextInt(6), rand.nextInt(6));` creates Game 1 with the current id, temperature, teams, and two random scores from `0` to `5`.
- `game2 = new Game (gameID + 1, temp, away2, home2, rand.nextInt(6), rand.nextInt(6));` creates Game 2 with the next id and the same score range.
- `}` closes the `temp <= 49` block.
- `else if (temp <= 66){` handles the next warmer range and allows scores from `0` to `10`.
- `game1 = new Game (gameID, temp, away1, home1, rand.nextInt(11), rand.nextInt(11));` creates Game 1 with random scores from `0` to `10`.
- `game2 = new Game (gameID + 1, temp, away2, home2, rand.nextInt(11), rand.nextInt(11));` creates Game 2 with random scores from `0` to `10`.
- `}` closes the `temp <= 66` block.
- `else if (temp <= 83){` handles the next warmer range and allows scores from `0` to `15`.
- `game1 = new Game (gameID, temp, away1, home1, rand.nextInt(16), rand.nextInt(16));` creates Game 1 with random scores from `0` to `15`.
- `game2 = new Game (gameID + 1, temp, away2, home2, rand.nextInt(16), rand.nextInt(16));` creates Game 2 with random scores from `0` to `15`.
- `}` closes the `temp <= 83` block.
- `else if (temp <= 100){` handles the warmest range and allows scores from `0` to `20`.
- `game1 = new Game (gameID, temp, away1, home1, rand.nextInt(21), rand.nextInt(21));` creates Game 1 with random scores from `0` to `20`.
- `game2 = new Game (gameID + 1, temp, away2, home2, rand.nextInt(21), rand.nextInt(21));` creates Game 2 with random scores from `0` to `20`.
- `}` closes the `temp <= 100` block.

#### Advancing the game id

- `gameID += 2;` moves the next available game number forward because two games were just created.

#### Updating goal totals for Game 1

- `//Game 1 Total goals` is a comment that labels the next block.
- `away1.setTotal_goals_scored(away1.getTotal_goals_scored() + game1.getAway_score());` adds Game 1's away score to the away team's season goals scored total.
- `away1.setTotal_goals_allowed(away1.getTotal_goals_allowed() + game1.getHome_score());` adds Game 1's home score to the away team's season goals allowed total.
- `home1.setTotal_goals_scored(home1.getTotal_goals_scored() + game1.getHome_score());` adds Game 1's home score to the home team's season goals scored total.
- `home1.setTotal_goals_allowed(home1.getTotal_goals_allowed() + game1.getAway_score());` adds Game 1's away score to the home team's season goals allowed total.

#### Updating goal totals for Game 2

- `//Game 2 Total goals` is a comment that labels the next block.
- `away2.setTotal_goals_scored(away2.getTotal_goals_scored() + game2.getAway_score());` adds Game 2's away score to the away team's season goals scored total.
- `away2.setTotal_goals_allowed(away2.getTotal_goals_allowed() + game2.getHome_score());` adds Game 2's home score to the away team's season goals allowed total.
- `home2.setTotal_goals_scored(home2.getTotal_goals_scored() + game2.getHome_score());` adds Game 2's home score to the home team's season goals scored total.
- `home2.setTotal_goals_allowed(home2.getTotal_goals_allowed() + game2.getAway_score());` adds Game 2's away score to the home team's season goals allowed total.

#### Saving played games and updating records

- `games_played.add(game1);` stores Game 1 in the season's game list.
- `games_played.add(game2);` stores Game 2 in the season's game list.
- `record_WLT(game1);` updates wins, losses, or draws for the teams in Game 1.
- `record_WLT(game2);` updates wins, losses, or draws for the teams in Game 2.
- `}` closes the `else` block for a playable week.
- `}` closes the `while` loop after the season-ending condition is finally reached.

#### Printing final season results

- `//Season is over` is a comment that labels the post-season output.
- `System.out.println("*********RESULTS*********\n\n");` prints a results heading followed by blank lines.
- `for (Team team : teams) {` loops through every team in the array.
- `team.print_stats();` tells each team to print its season totals.
- `}` closes the team loop.
- `for (Game game : games_played) {` loops through every game that was stored in the list.
- `game.print_stats();` tells each game to print its details.
- `}` closes the game loop.
- `}` closes the `main` method.

#### `record_WLT` helper method

- `public static void record_WLT(Game game) {` declares a helper method that updates win, loss, and draw totals for one game.
- `if (game.getAway_score() > game.getHome_score()) {` checks whether the away team won.
- `game.getAway().setWins_total(game.getAway().getWins_total() + 1);` adds one win to the away team.
- `game.getHome().setLosses_total(game.getHome().getLosses_total() + 1);` adds one loss to the home team.
- `}` closes the away-win block.
- `else if (game.getHome_score() > game.getAway_score()) {` checks whether the home team won instead.
- `game.getHome().setWins_total(game.getHome().getWins_total() + 1);` adds one win to the home team.
- `game.getAway().setLosses_total(game.getAway().getLosses_total() + 1);` adds one loss to the away team.
- `}` closes the home-win block.
- `else {` handles the tie case when both scores are equal.
- `game.getHome().setDraws_total(game.getHome().getDraws_total() + 1);` adds one draw to the home team.
- `game.getAway().setDraws_total(game.getAway().getDraws_total() + 1);` adds one draw to the away team.
- `}` closes the tie block.
- `}` closes the `record_WLT` method.
- `}` closes the `Main` class.

### `src/Team.java`

#### Class and data fields

- `public class Team {` declares the `Team` class.
- `// Data Fields` is a comment that labels the instance variables.
- `private String name;` stores the team's name.
- `private int wins_total;` stores how many wins the team has.
- `private int losses_total;` stores how many losses the team has.
- `private int draws_total;` stores how many draws the team has.
- `private int total_goals_scored;` stores how many total goals the team has scored.
- `private int total_goals_allowed;` stores how many total goals the team has allowed.

#### Constructor

- `// Constructors` is a comment that labels the constructor section.
- `public Team(String name) {` declares a constructor that requires a team name when a `Team` object is created.
- `this.name = name;` copies the constructor argument into the object's `name` field.
- `}` closes the constructor.

#### Getters and setters

- `// Getters and Setters` is a comment that labels the accessor methods.
- `public String getName() {` opens a method that returns the team name.
- `return name;` sends the `name` field back to the caller.
- `}` closes `getName`.
- `public void setName(String name) {` opens a method that changes the team name.
- `this.name = name;` replaces the current `name` with the new value.
- `}` closes `setName`.
- `public int getWins_total() {` opens a method that returns the team's win total.
- `return wins_total;` sends the win total back to the caller.
- `}` closes `getWins_total`.
- `public void setWins_total(int wins_total) {` opens a method that changes the team's win total.
- `this.wins_total = wins_total;` stores the new win total.
- `}` closes `setWins_total`.
- `public int getLosses_total() {` opens a method that returns the team's loss total.
- `return losses_total;` sends the loss total back to the caller.
- `}` closes `getLosses_total`.
- `public void setLosses_total(int losses_total) {` opens a method that changes the team's loss total.
- `this.losses_total = losses_total;` stores the new loss total.
- `}` closes `setLosses_total`.
- `public int getDraws_total() {` opens a method that returns the team's draw total.
- `return draws_total;` sends the draw total back to the caller.
- `}` closes `getDraws_total`.
- `public void setDraws_total(int draws_total) {` opens a method that changes the team's draw total.
- `this.draws_total = draws_total;` stores the new draw total.
- `}` closes `setDraws_total`.
- `public int getTotal_goals_scored() {` opens a method that returns the team's total goals scored.
- `return total_goals_scored;` sends the goals scored total back to the caller.
- `}` closes `getTotal_goals_scored`.
- `public void setTotal_goals_scored(int total_goals_scored) {` opens a method that changes the team's total goals scored.
- `this.total_goals_scored = total_goals_scored;` stores the new goals scored total.
- `}` closes `setTotal_goals_scored`.
- `public int getTotal_goals_allowed() {` opens a method that returns the team's total goals allowed.
- `return total_goals_allowed;` sends the goals allowed total back to the caller.
- `}` closes `getTotal_goals_allowed`.
- `public void setTotal_goals_allowed(int total_goals_allowed) {` opens a method that changes the team's total goals allowed.
- `this.total_goals_allowed = total_goals_allowed;` stores the new goals allowed total.
- `}` closes `setTotal_goals_allowed`.

#### Printing team stats

- `public void print_stats() {` declares a method that prints the team's final totals.
- `System.out.println(this.name);` prints the team's name on its own line.
- `System.out.print("Wins: " + this.wins_total + ", ");` prints the win total and keeps the cursor on the same line.
- `System.out.print("Losses: " + this.losses_total + ", ");` prints the loss total and keeps the cursor on the same line.
- `System.out.println("Draws: " + this.draws_total);` prints the draw total and then moves to the next line.
- `System.out.print("Goals scored: " + this.total_goals_scored + ", ");` prints the goals scored total and keeps the cursor on the same line.
- `System.out.println("Goals allowed: " + this.total_goals_allowed + "\n");` prints the goals allowed total and then adds a blank line after the team.
- `}` closes `print_stats`.
- `}` closes the `Team` class.

### `src/Game.java`

#### Class and data fields

- `public class Game {` declares the `Game` class.
- `//Data Fields` is a comment that labels the instance variables.
- `private int id;` stores the game's id number.
- `private double temperature;` stores the temperature for the week the game was played.
- `private Team away;` stores a reference to the away team.
- `private Team home;` stores a reference to the home team.
- `private int away_score;` stores the away team's score.
- `private int home_score;` stores the home team's score.

#### Constructor

- `//Constructors` is a comment that labels the constructor section.
- `public Game(int id, double temperature, Team away, Team home, int away_score, int home_score) {` declares a constructor that needs all game details up front.
- `this.id = id;` stores the passed-in game id.
- `this.temperature = temperature;` stores the passed-in temperature.
- `this.away = away;` stores the away team reference.
- `this.home = home;` stores the home team reference.
- `this.away_score = away_score;` stores the away score.
- `this.home_score = home_score;` stores the home score.
- `}` closes the constructor.

#### Getters and setters

- `//Getters and Setters` is a comment that labels the accessor section.
- `public int getId() {` opens a method that returns the game id.
- `return id;` sends the id back to the caller.
- `}` closes `getId`.
- `public void setId(int id) {` opens a method that changes the game id.
- `this.id = id;` stores the new id.
- `}` closes `setId`.
- `public double getTemperature() {` opens a method that returns the game's temperature.
- `return temperature;` sends the temperature back to the caller.
- `}` closes `getTemperature`.
- `public void setTemperature(double temperature) {` opens a method that changes the game's temperature.
- `this.temperature = temperature;` stores the new temperature.
- `}` closes `setTemperature`.
- `public Team getHome() {` opens a method that returns the home team.
- `return home;` sends the home team reference back to the caller.
- `}` closes `getHome`.
- `public void setHome(Team home) {` opens a method that changes the home team reference.
- `this.home = home;` stores the new home team reference.
- `}` closes `setHome`.
- `public Team getAway() {` opens a method that returns the away team.
- `return away;` sends the away team reference back to the caller.
- `}` closes `getAway`.
- `public void setAway(Team away) {` opens a method that changes the away team reference.
- `this.away = away;` stores the new away team reference.
- `}` closes `setAway`.
- `public int getAway_score() {` opens a method that returns the away score.
- `return away_score;` sends the away score back to the caller.
- `}` closes `getAway_score`.
- `public void setAway_score(int away_score) {` opens a method that changes the away score.
- `this.away_score = away_score;` stores the new away score.
- `}` closes `setAway_score`.
- `public int getHome_score() {` opens a method that returns the home score.
- `return home_score;` sends the home score back to the caller.
- `}` closes `getHome_score`.
- `public void setHome_score(int home_score) {` opens a method that changes the home score.
- `this.home_score = home_score;` stores the new home score.
- `}` closes `setHome_score`.

#### Printing game stats

- `public void print_stats() {` declares a method that prints one game's details.
- `System.out.println("Game #" + id);` prints the game number.
- `System.out.printf(...)` prints the temperature using two decimal places and then moves to the next line.
- `System.out.println("Away Team: " + away.getName() + ", Goals Scored: " + getAway_score());` prints the away team's name and score.
- `System.out.println("Home Team: " + home.getName() + ", Goals Scored: " + getHome_score() + "\n");` prints the home team's name and score and then adds a blank line.
- `}` closes `print_stats`.
- `}` closes the `Game` class.

## Notes

- Blank lines in the source code only separate steps for readability.
- Comments beginning with `//` explain the programmer's intent but do not change how the program runs.
- Most of the repeated methods in `Team` and `Game` are standard getters and setters used to read or update object data.
