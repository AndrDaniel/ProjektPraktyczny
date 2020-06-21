import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class TeamService {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        String hotelName = "Zarządzanie drużynami";
        System.out.println(hotelName);
        Scanner input = new Scanner(System.in);
        int option = getActionFromUser(input);
        if (option == 1) {
            Team newTeam= createNewTeam(input);
        } else if (option == 2) {

        } else if (option == 3) {
            System.out.println("Wybrano opcję 3.");
        } else {
            System.out.println("Wybrano niepoprawną akcję.");
        }
    }



    public static int getActionFromUser(Scanner in) {
        System.out.println("1. Dodaj nową drużynę.");
        System.out.println("2. Usuń drużynę.");
        System.out.println("3. Zgłoś drużynę do meczu.");
        System.out.println("4. Usuń drużynę z meczu.");
        int option = 0;
        try {
            option = in.nextInt();
        } catch (Exception e) {
            System.out.println("Niepoprawne dane wejsciowe, wprowadz liczbę.");
            e.printStackTrace();
        }
        return option;
    }
    public static Team createNewTeam(Scanner input) {
        System.out.println("Tworzymy nową drużynę.");
        try {
            System.out.println("Podaj nazwę: ");
            String teamName = input.next();
            System.out.println("Podaj ID: ");
           int teamID = input.nextInt();
            System.out.println("Podaj dyscyplinę:");
            System.out.println("\t1 Siatkówka");
            System.out.println("\t2 Dwa ognie");
            System.out.println("\t3 Przeciąganie liny");
            int disciplineOption = input.nextInt();
           Discipline discipline =Discipline.VOLLEYBALL;
            if (disciplineOption == 1) {
                discipline =Discipline.VOLLEYBALL;
            } else if (disciplineOption == 2) {
                discipline = Discipline.DODGE_BALL;
            }else if (disciplineOption == 3) {
                discipline =Discipline.TUG_OF_WAR;
            }
            Team newTeam = new Team(teamID, teamName, discipline);
            newTeam.setTeamName(teamName);
            newTeam.setTeamId(teamID);
            newTeam.setDiscipline(discipline);
            System.out.println(newTeam);
            return newTeam;
        } catch (Exception e) {
            System.out.println("Zły wiek, używaj liczb.");
            return null;
        }
    }

    static private Discipline chooseDiscipline(Scanner input) {
        System.out.println("Dyscypliny: ");
        System.out.println("\t1. VOLLEYBALL");
        System.out.println("\t2. DODGE_BALL");
        System.out.println("\t3. TUG_OF_WAR");
        Discipline discipline = Discipline.VOLLEYBALL;
        int disciplineOption = input.nextInt();
        if (disciplineOption == 1) {
            discipline = Discipline.VOLLEYBALL;
        } else if (disciplineOption == 2) {
            discipline = Discipline.DODGE_BALL;
        } else if (disciplineOption == 3) {
            discipline = Discipline.TUG_OF_WAR;
        }
        return discipline;
    }
    }

