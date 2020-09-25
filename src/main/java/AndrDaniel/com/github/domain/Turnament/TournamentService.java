package AndrDaniel.com.github.domain.Turnament;

import AndrDaniel.com.github.domain.Referee.Referee;
import AndrDaniel.com.github.domain.Referee.RefereeService;
import AndrDaniel.com.github.domain.Team.Team;
import AndrDaniel.com.github.domain.Team.TeamService;

import java.util.List;

public class TournamentService {
    private final TournamentRepository repo = new TournamentRepository();
    private final RefereeService refereeService = new RefereeService();
    private final TeamService teamService = new TeamService();

    public Tournament createTournament(Team team1, Team team2, Referee referee,Referee referee1,Referee referee2) {
        return this.repo.createTournament(team1, team2, referee,referee1,referee2);
    }

    public Referee getRandomElement(List<Referee> list) {
        return this.repo.getRandom(list);

    }

    public List<Tournament> getAllTeams() {
        return repo.getAll();
    }
}
