import data.HaikuWriter;
import haikuanalysis.HaikuAnalysisEngine;
import ui.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class HaikuApplication {

    //Instantiating relevant classes
    private final Menu menu = new Menu();
    private final HaikuAnalysisEngine haikuAnalysisEngine = new HaikuAnalysisEngine();
    private final HaikuWriter haikuWriter = new HaikuWriter();
    private final Scanner scan = new Scanner(System.in);


    public void run() {
        HaikuApplication app = new HaikuApplication(); //an instance of the class to keep the code object-oriented

        app.menu.welcomeUser();
        app.menu.appChoices(); //browsing feature hasn't been fledged out at this point

        String choiceInApp = scan.nextLine();

        if (choiceInApp.equals("1")) {
            System.out.println("What is your name?");
            String authorName = scan.nextLine().toLowerCase();

            //individual sentences are saved in ArrayList, if they are deemed valid by the method
            ArrayList<String> validHaiku = app.haikuAnalysisEngine.haikuOrNotPrompt();

            //this method call uses name of author (previously gathered) and the ArrayList with the three valid haiku sentences
            app.haikuWriter.logHaiku(authorName, validHaiku);

        } else if (choiceInApp.equals("2")) {
            System.out.println("Go to browsing"); //placeholder for what could be a browsing feature
        }
    }

    public static void main(String[] args) {
        new HaikuApplication().run(); //fleeing the static context
    }

}
