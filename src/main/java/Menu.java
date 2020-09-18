import java.util.Scanner;

public class Menu {
    public static void menu(Scanner in) {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Turniej ");
        System.out.println("     2. Sędziowie");
        System.out.println("     3. Drużyny");

        int w = in.nextInt();


        if (w == 1) {
            System.out.println("turniej");
            ;
        } else if (w == 2) {
            System.out.println("sędziowie");
        } else if (w == 3) {
//            TeamService service = new TeamService();
//service.teamManagement();

        }
    }
}