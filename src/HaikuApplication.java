import data.HaikuWriter;
import haikuanalysis.HaikuAnalysisEngine;
import ui.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class HaikuApplication {

    private final Menu menu = new Menu();
    private final HaikuAnalysisEngine haikuAnalysisEngine = new HaikuAnalysisEngine();
    private final HaikuWriter haikuWriter = new HaikuWriter();
    private final Scanner scan = new Scanner(System.in);


    public void run() {
        HaikuApplication app = new HaikuApplication();

        app.menu.welcomeUser();
        app.menu.appChoices();

        String choiceInApp = scan.nextLine();

        if (choiceInApp.equals("1")) {
            System.out.println("What is your name?");
            String authorName = scan.nextLine().toLowerCase();
            ArrayList<String> validHaiku = app.haikuAnalysisEngine.haikuOrNotPrompt();
            app.haikuWriter.logHaiku(authorName, validHaiku);
        } else if (choiceInApp.equals("2")) {
            System.out.println("Go to browsing");
        }
    }

    public static void main(String[] args) {
        new HaikuApplication().run(); //fleeing the static context
    }


}
