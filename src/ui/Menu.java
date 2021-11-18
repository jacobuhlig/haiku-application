package ui;

public class Menu {

    public void welcomeUser() {
        System.out.println("Welcome to the haiku application!");
    }

    public void appChoices() {
        System.out.println("Press 1: create haiku");
        System.out.println("Press 2: browse haikus");
    }

    //optimized switch statement
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
