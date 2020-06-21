import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = managerFactory.createEntityManager();
       Team team1 = new Team();
       team1.setTeamId(1);
       team1.setTeamName("FC_BRCL");
       team1.setDiscipline(Discipline.VOLLEYBALL);
    }
    }

