package AndrDaniel.com.github.ui.text;

import AndrDaniel.com.github.domain.Referee.Referee;
import AndrDaniel.com.github.domain.Referee.RefereeService;
import AndrDaniel.com.github.domain.Team.Team;
import AndrDaniel.com.github.domain.Team.TeamService;
import AndrDaniel.com.github.domain.Turnament.Tournament;
import AndrDaniel.com.github.domain.Turnament.TournamentService;
import AndrDaniel.com.github.exceptions.OnlyNumberException;
import AndrDaniel.com.github.exceptions.WrongOptionException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TextUI {
    RefereeService refereeService = new RefereeService();
    TeamService teamService = new TeamService();
    TournamentService tournamentService = new TournamentService();



    public void showMainMenu() {
        System.out.println("Trwa ładowanie danych...");
        this.refereeService.readAll();
        this.teamService.readAll();
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
                performActionTeam(input);
            } else if (option == 3) {
                System.out.println("Turniej");
                performActionTournament(input);
            } else if (option == 4) {
                System.out.println("Wyniki");
            } else if (option == 0) {
                System.out.println("Wychodzę z aplikacji. Zapisuję dane.");
                this.refereeService.saveAll();
                this.teamService.saveAll();
            }
        }
    }

    private void readNewTournamentData(Scanner input) {
        try {
            System.out.print("Podaj id pierwszej drużyny: ");
            int team1Id = input.nextInt();
            System.out.print("Podaj id drugiej drużyny: ");
            int team2Id = input.nextInt();
            System.out.println("Podaj id sędziego: ");
            int refereeId = input.nextInt();

            Tournament tournament = this.tournamentService.createTournament(team1Id, team2Id,refereeId);
            if(tournament!=null){
                System.out.println("Udało się stworzyć turniej");
            }
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong characters use instead of numbers");

        }
    }

    private void readNewTeamData(Scanner input) {
        try {
            System.out.print("Podaj nazwę drużyny: ");
            input.nextLine();
            String firstName = input.nextLine();
            Team team = teamService.createNewTeam(firstName);
            System.out.println("Dodano nową drużynę: " + team.getInfo());
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong characters use instead of numbers");

        }
    }

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

    private void performActionTournament(Scanner input) {
        int option = -1;
        while (option != 0) {
            option = getActionForTournament(input);
            if (option == 1) {
                System.out.println("Turniej");
                readNewTournamentData(input);
            } else if (option == 2) {
                System.out.println("Wszystkie mecze turnieju.");
                showAllTeamsFromTournament(input);
            } else if (option == 0) {
                System.out.println("Cofam do menu głównego. Zapisuję dane.");
                this.refereeService.saveAll();
            } else {
                throw new WrongOptionException("Wrong option in main menu");
            }
        }
    }

    private void showAllTeamsFromTournament(Scanner input) {
        List<Tournament> tournaments = this.tournamentService.getAllTeams();
        for (Tournament tournament : tournaments) {
            System.out.println(tournament.getInfo());
        }
    }

    private void performActionTeam(Scanner input) {
        int option = -1;
        while (option != 0) {
            option = getActionForTeam(input);
            if (option == 1) {
                System.out.println("Dodawanie drużyny.");
               readNewTeamData(input);
            } else if (option == 2) {
                System.out.println("Usuwanie drużyny.");
                removeTeam(input);
            } else if (option == 3) {
                System.out.println("Edytowanie drużyny.");
                editTeam(input);
            } else if (option == 4) {
                System.out.println("Wszystkie drużyny");
                showAllTeams();
            } else if (option == 0) {
                System.out.println("Cofam do menu głównego. Zapisuję dane.");
                this.teamService.saveAll();
            } else {
                throw new WrongOptionException("Wrong option in main menu");
            }
        }
    }

    private int getActionForTeam(Scanner input) {
        System.out.println("1. Dodaj drużynę.");
        System.out.println("2. Usuń drużynę.");
        System.out.println("3. Edytuj drużynę.");
        System.out.println("4. Wypisz wszystkie drużyny.");
        System.out.println("0. Cofnięcie do menu głównego.");
        System.out.println("Wybierz opcję: ");
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu");
        }
        return option;
    }

    private void showAllTeams() {
        List<Team> teams = this.teamService.getAllTeams();
        for (Team team : teams) {
            System.out.println(team.getInfo());
        }
    }

    private void editTeam(Scanner input) {
        System.out.println("Podaj id drużyny do edycji: ");
        try {
            int id = input.nextInt();

            System.out.print("Podaj nazwę drużyny: ");
            input.nextLine();
            String firstName = input.nextLine();
          teamService.editTeam(id, firstName);
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong characters use instead of numbers");
        }
    }

    private void removeTeam(Scanner input) {
        System.out.println("Podaj id drużyny do usunięcia: ");
        try {
            int id = input.nextInt();
            this.teamService.removeTeam(id);
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Wrong characters use instead of numbers");
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
        System.out.println("0.Wyjście z aplikacji.");
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu");
        }
        return option;
    }

    private int getActionForReferee(Scanner input) {
        System.out.println("1. Dodaj sędziego.");
        System.out.println("2. Usuń sędziego.");
        System.out.println("3. Edytuj sędziego.");
        System.out.println("4. Wypisz wszystkich sędziów.");
        System.out.println("0. Cofnięcie do menu głównego.");
        System.out.println("Wybierz opcję: ");
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberException("Use only numbers in main menu");
        }
        return option;
    }

    private int getActionForTournament(Scanner input) {
        System.out.println("1.Stwórz turniej.");
        System.out.println("2.Wyświetl mecze w turnieju.");
        System.out.println("0.Cofnięcie do menu głównego.");
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
