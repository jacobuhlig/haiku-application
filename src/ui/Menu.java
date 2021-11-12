package ui;

import java.util.Scanner;

public class Menu {

    public Menu() {
        Scanner scan = new Scanner(System.in);
    }

    public void welcomeUser() {
        System.out.println("Welcome to the haiku application!");
    }

    public void promptUser(int firstSecondOrThird) {
        String firstSecondOrThirdString = switch (firstSecondOrThird) {
            case 0 -> "first";
            case 1 -> "second";
            case 2 -> "third";
            default -> "";
        };
        System.out.println("Please type in " + firstSecondOrThirdString + " line of haiku");
    }
}
