# Need to go over the design spiral
# Section-8-Practice
## Overview
This program shows how a group of friends that get together on Tuesdays play 2 games of socceer a week
## The Teams
- There are 4 teams
  - They cannot play against themselves
  - They cannot play against the same team consecutively
## The Season
- There are 2 games played per week in a season
  - Games cannot be played if the temperature is below freezing
  - If there are 3 consecutive weeks are freezing, the season is over
  - If the temperature is not freezing
    - The game is played
## The Game Scores
- The 2 games have different scores based on temperature
  - If the temp is 32 degrees F < temp <= 49 degrees F
    - The scores are in the 0 to 5 range
  - If the temp is 49 degrees F < temp <= 66 degrees F
    - The scores are in the 0 to 10 range
  - If the temp is 66 degrees F < temp <= 83 degrees F
    - The scores are in the 0 to 15 range
  - If the temp is temp <= 100 degrees F
    - The scores are in the 0 to 20 range
## The End of the Program
- At the end
  - The program tells you the season is over
  - Then tells you the results of each team's stats during the season
  - And tells you the results of each game of the season
    - Two games in a row will have the same tempurature
