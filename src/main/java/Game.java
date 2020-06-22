import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID meczu",nullable = false,length = 10)
    private int gameId;
    @Column(name = "Pierwsza_drużyna",nullable = false,length = 45)
    private String firstTeam;
    @Column(name = "Druga_drużyna",nullable = false,length = 45)
    private String secondTeam;
    @Column(name = "Wynik",nullable = false,length = 20)
    private String score;
    @Column(name = "Wygrana drużyna",nullable = false,length = 35)
    private String wygrany;
    @Column(name = "Sędzia główny",nullable = false,length = 45)
    private String refereeName;
    @Column(name = "Sędzia dodatkowy",length=20)
    private String additionalReferee1;
    @Column(name = "Sędzia dodatkowy",length = 20)
    private String additionalReferee2;

}
