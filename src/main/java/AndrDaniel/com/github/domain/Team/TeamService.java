package AndrDaniel.com.github.domain.Team;



import java.util.List;

public class TeamService {
    private final static TeamRepository repo = new TeamRepository();

    public Team createNewTeam(String teamName) {
        return repo.createNewTeam(teamName);
    }

    public List<Team> getAllTeams() {
        return repo.getAll();
    }

    public void saveAll() {
        repo.saveAll();
    }

    public void readAll() {
        repo.readAll();
    }

    public void removeTeam(int id) {
        repo.remove(id);
    }

    public void editTeam(int id, String teamName) {
        repo.edit(id, teamName);
    }

    public Team getTeamById(int team1Id) {
        return repo.getById(team1Id);
    }

    public Team getRandomTeam() {
        return this.repo.getRandomTeam();

    }
}
