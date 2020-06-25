import javax.persistence.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

@Column(name = "Nazwa drużyny",nullable = false,length = 45)
    private String teamName;
    @Column(name = "Dyscyplina",nullable = false,length = 45)
    private Discipline discipline;


    public Team(int teamId, String teamName, Discipline discipline) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.discipline = discipline;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }


    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", discipline=" + discipline +
                '}';
    }
}
