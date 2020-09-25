package AndrDaniel.com.github.domain.Referee;




import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RefereeRepository {
    private final List<Referee> referees = new ArrayList<>();

    public Referee createNewReferee(String firstName, String lastName) {
        Referee newReferee = new Referee(findNewId(), firstName, lastName);
        referees.add(newReferee);
        return newReferee;
    }

    public Referee addExistingReferee(int id, String firstName, String lastName) {
        Referee newReferee = new Referee(id, firstName, lastName);
        referees.add(newReferee);
        return newReferee;
    }

    public List<Referee> getAll() {
        return this.referees;
    }

    void saveAll() {
        String name = "referees.csv";

        Path file = Paths.get(System.getProperty("user.home"), "Tournament", name);
        StringBuilder sb = new StringBuilder("");
        for (Referee ref : this.referees) {
            sb.append(ref.toCSV());
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

    void readAll() {
        String name = "referees.csv";

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
                addExistingReferee(id, refereeData[1], refereeData[2]);
            }
        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku z danymi.");
            e.printStackTrace();
        }

    }

    private int findNewId() {
        int max = 0;
        for (Referee referee : referees) {
            if (referee.getId() > max) {
                max = referee.getId();
            }
        }
        return max + 1;
    }

    public void remove( int id) {
        int refereeToBeRemovedIndex = -1;
        for (int i = 0; i <this.referees.size() ; i++) {
            if (this.referees.get(i).getId() == id) {
                refereeToBeRemovedIndex = i;
                break;
            }
        }
            if(refereeToBeRemovedIndex>-1){
                this.referees.remove(refereeToBeRemovedIndex);
            }
        }


    public void edit(int id, String firstName, String lastName) {
        this.remove(id);
        this.addExistingReferee(id,firstName, lastName);
    }


    public Referee findById(int id) {
        for(Referee referee: referees){
            if(referee.getId() == id){
                return referee;
            }
        }
        return null;
    }

    public Referee getRandomReferee() {
//       List<Referee> copyReferees = new ArrayList<>(referees);
        Random rand = new Random();
        int randomId = rand.nextInt(referees.size());
        Referee referee = referees.get(randomId);
        referees.remove(randomId);
        return referee;
    }
}
