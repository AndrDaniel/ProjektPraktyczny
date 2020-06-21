import java.util.Scanner;

public class Menu {
    public static int menu(){
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Turniej ");
        System.out.println("     2. Sędziowie");
        System.out.println("     3. Drużyny");
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }
}
