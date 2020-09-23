package AndrDaniel.com.github;//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import AndrDaniel.com.github.ui.text.TextUI;


public class App {
   private static final TextUI textUI = new TextUI();

    public static void main(String[] args) {
//        EntityManagerFactory managerFactory =
//                Persistence.createEntityManagerFactory("mysqlPU");
//        EntityManager entityManager = managerFactory.createEntityManager();
//       Menu menu1 = new Menu();
//        Scanner input = new Scanner(System.in);
//       menu1.menu(input);
textUI.showMainMenu();

    }




}

