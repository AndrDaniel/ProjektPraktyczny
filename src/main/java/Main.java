import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = managerFactory.createEntityManager();
       Menu menu1 = new Menu();
        Scanner input = new Scanner(System.in);
       menu1.menu(input);



    }

}

