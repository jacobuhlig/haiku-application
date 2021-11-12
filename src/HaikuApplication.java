import haikuanalysis.HaikuAnalysisEngine;
import ui.Menu;

import java.util.Scanner;

public class HaikuApplication {

    private final Menu menu = new Menu();
    private final HaikuAnalysisEngine haikuAnalysisEngine = new HaikuAnalysisEngine();
    private final Scanner scan = new Scanner(System.in);


    public void run() {
        HaikuApplication app = new HaikuApplication();

        app.menu.welcomeUser();

        for (int i = 0; i < 3; i++) {
            app.menu.promptUser(i);
            String line = scan.nextLine();
            boolean validHaiku = app.haikuAnalysisEngine.haikuOrNot(i, line);
            if (validHaiku) {
                System.out.println("true");
            }
            if (!validHaiku) {
                System.out.println("false");
            }
        }
    }


    public static void main(String[] args) {
        new HaikuApplication().run(); //fleeing the static context
    }


}
