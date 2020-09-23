package AndrDaniel.com.github.domain.Team;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository {
    private final List<Team> teams =new ArrayList<>();
    public Team createNewTeam(String teamName) {
        Team newTeam = new Team(findNewId(),teamName);
        teams.add(newTeam);
        return newTeam;
    }
    public Team addExistingTeam(int id,String teamName) {
        Team newTeam = new Team(id,teamName);
        teams.add(newTeam);
        return newTeam;
    }

    public List<Team> getAll() {
        return this.teams;
    }

    public void saveAll() {
        String name = "teams.csv";

        Path file = Paths.get(System.getProperty("user.home"), "Tournament", name);
        StringBuilder sb = new StringBuilder("");
        for (Team team : this.teams) {
            sb.append(team.toCSV());
        }
        try {
            Path tournament_dir = Paths.get(System.getProperty("user.home"), "Tournament");
            if (!Files.isDirectory(tournament_dir)) {
                Files.createDirectory(tournament_dir);
            }
            Files.writeString(file, sb.toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readAll() {
        String name = "teams.csv";

        Path file = Paths.get(System.getProperty("user.home"),
                "Tournament", name);
        if(!Files.exists(file)){
            return;
        }
        try {
            String data = Files.readString(file, StandardCharsets.UTF_8);
            String[] refereesAsString = data.split(System.getProperty("line.separator"));
            for (String refereeAsString : refereesAsString) {
                String[] refereeData = refereeAsString.split(",");
                int id = Integer.parseInt(refereeData[0]);
                addExistingTeam(id, refereeData[1]);
            }
        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku z danymi.");
            e.printStackTrace();
        }

    }
    private int findNewId() {
        int max = 0;
        for (Team team : teams) {
            if (team.getId() > max) {
                max = team.getId();
            }
        }
        return max + 1;
    }

    public void remove(int id) {
        int refereeToBeRemovedIndex = -1;
        for (int i = 0; i <this.teams.size() ; i++) {
            if (this.teams.get(i).getId() == id) {
                refereeToBeRemovedIndex = i;
                break;
            }
        }
        if(refereeToBeRemovedIndex>-1){
            this.teams.remove(refereeToBeRemovedIndex);
        }
    }

    public void edit(int id, String teamName) {
        this.remove(id);
        this.addExistingTeam(id,teamName);
    }

    public Team getById(int id) {
        for(Team team : teams) {
            if(team.getId() == id){
                return team;
            }
        }
        return null;
    }
}
