package AndrDaniel.com.github.domain.Referee;

public class Referee {
    public int id;
    public String firstName;
    public String lastName;

    public Referee(int id, String firstName, String lastName) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
public String getInfo(){
        return String.format("Dodano nowego sędziego: (%d) %s %s", this.id, this.firstName, this.lastName);
}

}
