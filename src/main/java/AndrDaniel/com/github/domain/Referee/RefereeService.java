package AndrDaniel.com.github.domain.Referee;


import java.util.List;

public class RefereeService {

private final RefereeRepository repo =  new RefereeRepository();

public Referee createNewReferee(String firstName, String lastName){
    return repo.createNewReferee(firstName,lastName);
}

    public List<Referee> getAllReferees() {
    return this.repo.getAll();
    }
    public void saveAll(){
    this.repo.saveAll();
    }

    public void readAll() {
    this.repo.readAll();

    }

    public void removeReferee(int id) {
    this.repo.remove(id);
    }

    public void editReferee(int id, String firstName, String lastName) {
    this.repo.edit(id, firstName, lastName);
    }
}
