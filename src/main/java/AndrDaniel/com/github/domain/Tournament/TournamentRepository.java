package AndrDaniel.com.github.domain.Tournament;

import AndrDaniel.com.github.domain.Referee.Referee;
import AndrDaniel.com.github.domain.Referee.RefereeService;
import AndrDaniel.com.github.domain.Team.Team;
import AndrDaniel.com.github.domain.Team.TeamService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TournamentRepository {
    private final List<Tournament> tournaments = new ArrayList<>();
    private final TeamService teamService = new TeamService();
    private final RefereeService refereeService = new RefereeService();




    public Tournament createTournament(Team team1, Team team2, Referee referee,Referee referee1,Referee referee2) {

        Tournament newTournament = new Tournament(team1, team2, referee,referee1,referee2);
        this.tournaments.add(newTournament);
        return newTournament;
    }


    public List<Tournament> getAll() {
        return this.tournaments;
    }

    public void saveAll() {
        String name = "tournaments.csv";

        Path file = Paths.get(System.getProperty("user.home"), "Tournament", name);
        StringBuilder sb = new StringBuilder("");
        for (Tournament tournament : this.tournaments) {
            sb.append(tournament.toCSV());
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
        String name = "tournaments.csv";

        Path file = Paths.get(System.getProperty("user.home"),
                "Tournament", name);
        if (!Files.exists(file)) {
            return;
        }
        try {
            String data = Files.readString(file, StandardCharsets.UTF_8);
            String[] tournamentsAsString = data.split(System.getProperty("line.separator"));
            for (String tournamentAsString : tournamentsAsString) {
                String[] tournamentData = tournamentAsString.split(",");
                int team1Id = Integer.parseInt(tournamentData[0]);
                int team2Id = Integer.parseInt(tournamentData[1]);
                int referee1 = Integer.parseInt(tournamentData[2]);
                int referee2 = Integer.parseInt(tournamentData[3]);
                int referee3 = Integer.parseInt(tournamentData[4]);
                createTournament(
                        this.teamService.getTeamById(team1Id),
                        this.teamService.getTeamById(team2Id),
                        this.refereeService.getRefereeById(referee1),
                        this.refereeService.getRefereeById(referee2),
                        this.refereeService.getRefereeById(referee3));
            }
        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku z danymi.");
            e.printStackTrace();
        }
    }
}
