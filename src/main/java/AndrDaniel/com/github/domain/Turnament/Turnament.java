package AndrDaniel.com.github.domain.Turnament;

import AndrDaniel.com.github.domain.Referee.Referee;
import AndrDaniel.com.github.domain.Score.Score;
import AndrDaniel.com.github.domain.Team.Team;

public class Turnament {
    private final Team team1;
    private final Team team2;
    private final Score score;
    private final Referee referee;


   public Turnament(Team team1,Team team2,Score score, Referee referee) {
      this.team1 = team1;
      this.team2 = team2;
      this.score = score;
      this.referee = referee;
   }

   public Team getTeam1() {
      return team1;
   }

   public Team getTeam2() {
      return team2;
   }

   public Score getScore() {
      return score;
   }

   public Referee getReferee() {
      return referee;
   }


}
