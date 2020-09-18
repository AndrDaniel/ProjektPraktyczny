package AndrDaniel.com.github.domain.Turnament;

import AndrDaniel.com.github.domain.Referee.Referee;
import AndrDaniel.com.github.domain.Score.Score;
import AndrDaniel.com.github.domain.Team.Team;

public class Turnament {
    private Team [] team;
    private Score score;
    private Referee referee;


   public Turnament(Team[] team,Score score, Referee referee) {
      this.team = team;
      this.score = score;
      this.referee = referee;
   }

   public Team[] getTeam() {
      return team;
   }

   public Score getScore() {
      return score;
   }

   public Referee getReferee() {
      return referee;
   }


}
