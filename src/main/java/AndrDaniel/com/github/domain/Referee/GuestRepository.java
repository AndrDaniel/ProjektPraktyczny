package AndrDaniel.com.github.domain.Referee;

import java.util.Scanner;

public class GuestRepository {
    private static void createNewReferee(Scanner input) {
        System.out.print("Podaj id: ");
        int id = input.nextInt();
        System.out.print("Podaj imię sędziego: ");
        input.nextLine();
        String firstName = input.nextLine();
        System.out.print("Podaj nazwisko sędziego: ");
        String lastName = input.nextLine();
        Referee referee1 = new Referee(id, firstName, lastName);
        System.out.println(referee1.getInfo());

    }
}
