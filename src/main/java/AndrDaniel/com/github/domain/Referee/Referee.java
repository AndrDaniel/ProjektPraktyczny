package AndrDaniel.com.github.domain.Referee;

public class Referee {
    private final int id;
    private final String firstName;
    private final String lastName;

    public Referee(int id, String firstName, String lastName) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getInfo() {
        return String.format("(%d) %s %s", this.id, this.firstName, this.lastName);
    }

    public int getId() {
        return id;
    }

    String toCSV() {
        return String.format("%d,%s,%s%s",
                this.id,
                this.firstName,
                this.lastName,
                System.getProperty("line.separator"));
    }

}
