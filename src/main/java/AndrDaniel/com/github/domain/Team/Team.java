package AndrDaniel.com.github.domain.Team;

public class Team {
    private int id;
    private String teamName;

    public Team(int id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }
}
