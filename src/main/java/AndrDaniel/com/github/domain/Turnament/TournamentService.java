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

    public Tournament createTournament(Team team1, Team team2, int refereeId) {

        int id = team1.getId();
        int id2 = team2.getId();
        Team team1Id = this.teamService.getTeamById(id);
        Team team2Id = this.teamService.getTeamById(id2);
        Referee referee = this.refereeService.getRefereeById(refereeId);

        return this.repo.createTournament(team1Id, team2Id, referee);
    }

    public Referee getRandomElement(List<Referee> list) {
        return this.repo.getRandom(list);

    }

    public List<Tournament> getAllTeams() {
        return repo.getAll();
    }
}
