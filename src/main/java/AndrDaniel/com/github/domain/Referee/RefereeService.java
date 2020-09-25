package AndrDaniel.com.github.domain.Referee;


import AndrDaniel.com.github.domain.Team.Team;

import java.util.List;

public class RefereeService {

    private final static RefereeRepository repo = new RefereeRepository();

    public Referee createNewReferee(String firstName, String lastName) {
        return repo.createNewReferee(firstName, lastName);
    }

    public List<Referee> getAllReferees() {
        return repo.getAll();
    }

    public void saveAll() {
        repo.saveAll();
    }

    public void readAll() {
        repo.readAll();

    }

    public void removeReferee(int id) {
        repo.remove(id);
    }

    public void editReferee(int id, String firstName, String lastName) {
        repo.edit(id, firstName, lastName);
    }

    public Referee getRefereeById(int id) {
         return  this.repo.findById(id);
    }
    public Referee getRandomReferee() {
        return this.repo.getRandomReferee();

    }
}
