package AndrDaniel.com.github.domain.Team;

public class Team {
    private final int id;
    private final String teamName;

    public Team(int id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public String getInfo() {
        return String.format("Drużyna nr: (%d) %s", this.id, this.teamName);
    }

    String toCSV() {
        return String.format("%d,%s%s",
                this.id,
                this.teamName,
                System.getProperty("line.separator"));
    }

}
