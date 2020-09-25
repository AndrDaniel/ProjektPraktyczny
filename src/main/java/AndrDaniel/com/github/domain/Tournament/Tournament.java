package AndrDaniel.com.github.domain.Tournament;

import AndrDaniel.com.github.domain.Referee.Referee;

import AndrDaniel.com.github.domain.Team.Team;

public class Tournament {
    private final Team team1;
    private final Team team2;
    private final Referee referee;
    private final Referee referee1;
    private final Referee referee2;


    public Tournament(Team team1, Team team2, Referee referee, Referee referee1, Referee referee2) {
        this.team1 = team1;
        this.team2 = team2;
        this.referee = referee;
        this.referee1 = referee1;
        this.referee2 = referee2;

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


//    public String getInfo() {
//        return String.format(" Drużyna pierwsza nr:%s - Drużyna druga nr:%s. Sędzia główny:%s, Sędzia asystujący pierwszy:%s, Sędzia asystujący drugi:%s", team1.getInfo(), team2.getInfo(), referee.getInfo(), referee1.getInfo(), referee2.getInfo());
//    }
    public String getInfo() {
        return String.format("%s %s %s %s %s", team1.getInfo(), team2.getInfo(), referee.getInfo(), referee1.getInfo(), referee2.getInfo());
    }

    String toCSV() {
        return String.format("%s,%s,%s,%s,%s%s",
                this.team1.getId(),
                this.team2.getId(),
                this.referee.getId(),
                this.referee1.getId(),
                this.referee2.getId(),
                System.getProperty("line.separator"));
    }
}
