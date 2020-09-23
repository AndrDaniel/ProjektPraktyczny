package AndrDaniel.com.github.ui.text;

import AndrDaniel.com.github.domain.Referee.Referee;
import AndrDaniel.com.github.domain.Referee.RefereeService;
import AndrDaniel.com.github.exceptions.OnlyNumberException;
import AndrDaniel.com.github.exceptions.WrongOptionException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TextUI {
    RefereeService refereeService = new RefereeService();

    private void readNewRefereeData(Scanner input) {
        try {
            System.out.print("Podaj imię sędziego: ");
            input.nextLine();
            String firstName = input.nextLine();
            System.out.print("Podaj nazwisko sędziego: ");
            String lastName = input.nextLine();
            Referee referee = refereeService.createNewReferee(firstName, lastName);
            System.out.println("Dodano nowego sędziego: " + referee.getInfo());
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong characters use instead of numbers");

        }
    }

    public static void showSystemInfo() {
    }

    public void showMainMenu() {
        System.out.println("Trwa ładowanie danych...");
        this.refereeService.readAll();
        Scanner input = new Scanner(System.in);
        try {
           mainMenu(input);
        } catch (WrongOptionException | OnlyNumberException e) {
            System.out.println("Wystąpił niespodziewany błąd.");
            System.out.println("Kod błędu: " + e.getCode());
            System.out.println("Komunikat błędu: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Wystąpił niespodziewany błąd.");
            System.out.println("Nieznany kod błędu");
            System.out.println("Komunikat błędu: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void mainMenu(Scanner input) {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        int option = -1;
        while (option != 0) {
            option = getActionForMainMenu(input);
            if (option == 1) {
                performActionReferee(input);
            } else if (option == 2) {
                System.out.println("Dodawanie drużyny");
            } else if (option == 3) {
                System.out.println("Turniej");
            }else if (option == 4) {
                System.out.println("Wyniki");
            }
        }
    }

    private void performActionReferee(Scanner input) {
        int option = -1;
        while (option != 0) {
            option = getActionForReferee(input);
            if (option == 1) {
                System.out.println("Dodawanie sędziego.");
                readNewRefereeData(input);
            } else if (option == 2) {
                System.out.println("Usuwanie sędziego.");
                removeReferee(input);
            } else if (option == 3) {
                System.out.println("Edytowanie sędziego.");
                editReferee(input);
            } else if (option == 4) {
                System.out.println("Wszyscy sędziowie.");
                showAllReferees();
            } else if (option == 0) {
                System.out.println("Cofam do menu głównego. Zapisuję dane.");
                this.refereeService.saveAll();
            } else {
                throw new WrongOptionException("Wrong option in main menu");
            }
        }
    }

    private void editReferee(Scanner input) {
        System.out.println("Podaj id sędziego do edycji: ");
        try {
            int id = input.nextInt();

            System.out.print("Podaj imię sędziego: ");
            input.nextLine();
            String firstName = input.nextLine();
            System.out.print("Podaj nazwisko sędziego: ");
            String lastName = input.nextLine();

            refereeService.editReferee(id, firstName, lastName);
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong characters use instead of numbers");
        }
    }

    private void removeReferee(Scanner input) {
        System.out.println("Podaj id sędziego do usunięcia: ");
        try {
            int id = input.nextInt();
            this.refereeService.removeReferee(id);
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong characters use instead of numbers");
        }
    }

    private void showAllReferees() {
        List<Referee> referees = this.refereeService.getAllReferees();
        for (Referee referee : referees) {
            System.out.println(referee.getInfo());
        }
    }

    private int getActionForMainMenu(Scanner input) {
        System.out.println("1.Sędziowie");
        System.out.println("2.Drużyny");
        System.out.println("3.Turniej ");
        System.out.println("4.Wyniki");
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu");
        }
        return option;
    }

    private int getActionForReferee(Scanner input) {
        System.out.println("1. Dodaj sędziego");
        System.out.println("2. Usuń sędziego");
        System.out.println("3. Edytuj sędziego");
        System.out.println("4. Wypisz wszystkich sędziów");
        System.out.println("0. Wyjście z aplikacji");
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
