//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import AndrDaniel.com.github.domain.Referee.Referee;
import AndrDaniel.com.github.exceptions.OnlyNumberException;
import AndrDaniel.com.github.exceptions.WrongOptionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
//        EntityManagerFactory managerFactory =
//                Persistence.createEntityManagerFactory("mysqlPU");
//        EntityManager entityManager = managerFactory.createEntityManager();
//       Menu menu1 = new Menu();
//        Scanner input = new Scanner(System.in);
//       menu1.menu(input);
        Scanner input = new Scanner(System.in);
        try{
            performAction(input);
        }
        catch(WrongOptionException | OnlyNumberException e){
            System.out.println("Wystąpił niespodziewany błąd.");
            System.out.println("Kod błędu: " + e.getCode());
            System.out.println("Komunikat błędu: " + e.getMessage());
        }catch(Exception e){
            System.out.println("Wystąpił niespodziewany błąd.");
            System.out.println("Nieznany kod błędu");
            System.out.println("Komunikat błędu: " + e.getMessage());
        }finally {
            System.out.println("Wychodzę z aplikacji.");
        }


    }

    private static void performAction(Scanner input) {
        int option = getActionFromUser(input);


        if (option == 1) {
            System.out.println("Wybrano opcję 1.");
        } else if (option == 2) {
            System.out.println("Wybrano opcję 2.");
            createNewReferee(input);
        } else if (option == 3) {
            System.out.println("Wybrano opcję 3.");
        } else {
            throw new WrongOptionException("Wrong option in main menu");
        }
    }

    private static Referee createNewReferee(Scanner input) {
        try {
                System.out.print("Podaj id: ");
                int id = input.nextInt();
                System.out.print("Podaj imię sędziego: ");
                input.nextLine();
                String firstName = input.nextLine();
                System.out.print("Podaj nazwisko sędziego: ");
                String lastName = input.nextLine();
                Referee referee = new Referee(id, firstName, lastName);
                System.out.println(referee.getInfo());
                return referee;

        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong characters use instead of numbers");

        }
    }

    private static int getActionFromUser(Scanner input) {
        System.out.println("1. Dodaj nową drużynę");
        System.out.println("2. Dodaj sędziego");
        System.out.println("Wybierz opcję: ");
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
throw new OnlyNumberException("Use only numbers in main menu");
        }
        return option;
    }



}

