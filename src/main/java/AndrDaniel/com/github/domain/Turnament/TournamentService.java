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

    public Tournament createTournament(int team1Id, int team2Id, int refereeId) {

        //TODO handle null room
        Team team1 = this.teamService.getTeamById(team1Id);
        Team team2 = this.teamService.getTeamById(team2Id);
        Referee referee = this.refereeService.getRefereeById(refereeId);

       return this.repo.createTournament(team1, team2, referee);
    }

    public Referee getRandomElement(List<Referee> list) {
        return this.repo.getRandom(list);

    }

    public List<Tournament> getAllTeams() {
        return repo.getAll();
    }
}
