# Section 8 Practice

This project is a small Java console program that simulates a four-team season. Each week the program generates a random temperature, decides whether games can be played, updates team records, and prints the final results when the season ends.

## What the program does

- Creates four teams: `Team 1`, `Team 2`, `Team 3`, and `Team 4`
- Simulates weekly temperature from `0.0` to `100.0` degrees Fahrenheit
- Cancels a week if the temperature is `32F` or below
- Ends the season after `3` consecutive canceled weeks
- Plays `2` games on each playable week
- Tracks wins, losses, draws, goals scored, and goals allowed
- Prints final team stats and a full game log

## Scheduling rules

- `Team 4` is always the home team in Game 1
- The away team in Game 1 is randomly chosen from `Team 1`, `Team 2`, or `Team 3`
- Game 2 uses the two remaining teams
- This is how the teams
  1) Don't play against themselves
  2) Don't play against the same team consecutively

## Scoring rules

The number of possible goals increases as the temperature gets warmer:

- `33F-49F`: each team can score `0-5` goals
- `50F-66F`: each team can score `0-10` goals
- `67F-83F`: each team can score `0-15` goals
- `84F-100F`: each team can score `0-20` goals

## Project structure

- `src/Main.java` - runs the season simulation and updates records
- `src/Team.java` - stores season totals for each team
- `src/Game.java` - stores game data and prints game results

## Team Stats Printout
- The Team.java has what is used to create stats for each team
  - private String name is used to name each team
  - private int wins_total is the amount of wins the team have
  - private int losses_total is the amount of losses the team have
  - private int draws_total is the amount of draws the team have
  - private int total_goals_scored is the amount of goals the team scored
  - private int total_goals_allowed is the amount of goals the team allowed to score on them
 

## How the games are run


## Example output

Because the program uses random values, results change every time it runs. A typical run looks like this:

```text
There has been 3 consecutive weeks where the temperature too cold to play. The season is over.

*********RESULTS*********

Team 1
Wins: 5, Losses: 4, Draws: 3
Goals scored: 96, Goals allowed: 84
```

## Notes

- The classes are in the default package
- No external libraries are required
- Output is different on every run because the schedule, temperature, and scores are random
- The Printf method used in the Game.java of the program changes the way it prints the temperature
  - The Temperature is a double, so you have to:
    1) Type the text first in the quotation marks
    2) %.2F
    3) comma then temperture variable
