package AndrDaniel.com.github.domain.Turnament;

import AndrDaniel.com.github.domain.Referee.Referee;
import AndrDaniel.com.github.domain.Score.Score;
import AndrDaniel.com.github.domain.Team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TournamentRepository {
    private final List<Tournament> tournaments = new ArrayList<>();


    public Referee getRandom(List<Referee> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public Tournament createTournament(Team team1, Team team2, Referee referee) {
        Tournament newTournament = new Tournament(team1, team2, referee);
        this.tournaments.add(newTournament);
        return newTournament;
    }

    public List<Tournament> getAll() {
        return this.tournaments;
    }
}
