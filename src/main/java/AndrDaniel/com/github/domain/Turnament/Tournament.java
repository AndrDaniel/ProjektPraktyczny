package AndrDaniel.com.github.domain.Turnament;

import AndrDaniel.com.github.domain.Referee.Referee;
import AndrDaniel.com.github.domain.Score.Score;
import AndrDaniel.com.github.domain.Team.Team;

public class Tournament {
    private final Team team1;
    private final Team team2;
//    private final Score score1;
//    private final Score score2;
    private final Referee referee;




   public Tournament(Team team1, Team team2,  Referee referee) {
      this.team1 = team1;
      this.team2 = team2;
      this.referee = referee;

   }

   public Team getTeam1() {
      return team1;
   }

   public Team getTeam2() {
      return team2;
   }
//   public Score getScore1() {
//      return score1;
//   }
//
//   public Score getScore2() {
//      return score2;
//   }

   public Referee getReferee() {
      return referee;
   }


   public String getInfo() {
         return String.format("%s %s %s",this.team1.getInfo(),this.team2.getInfo(),this.referee.getInfo());
   }
}
