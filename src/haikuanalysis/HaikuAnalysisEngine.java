package haikuanalysis;

import ui.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class HaikuAnalysisEngine {
    private final Menu menu = new Menu();
    private final Scanner scan = new Scanner(System.in);

    public ArrayList<String> getStringsInArrayList(String line) {
        ArrayList<String> strings = new ArrayList<>();

        for (String word : line.split(" ")) {
            strings.add(word);
        }
        return strings;
    }

    public boolean isVowel(char letter) {
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y') {
            return true;
        } else {
            return false;
        }
    }

    public int getNumberOfSyllablesInWord(String wordInString) {

        String w = wordInString.toLowerCase();
        int length = w.length();

        int count = 0;

        boolean isSyllable = false;

        //drew inspiration from this site 'https://www.delftstack.com/howto/java/syllable-counter-in-java/'
        for (int i = 0; i < length; i++) {
            if (w.contains("a") || w.contains("e") || w.contains("i") || w.contains("o") || w.contains("u") || w.contains("y")) {
                if (isVowel(w.charAt(i)) && !((w.charAt(i) == 'e') && (i == w.length() - 1)) || w.equals("the")) {
                    if (!isSyllable) {
                        count++;
                        isSyllable = true;
                    }
                } else {
                    isSyllable = false;
                }
            } else {
                count++;
                break;
            }
        }
        return count;
    }

    public boolean haikuOrNot(int iteration, String line) {

        ArrayList<String> wordsInString = getStringsInArrayList(line);
        int size = wordsInString.size();

        int count = 0;

        for (int i = 0; i < size; i++) {
            String word = wordsInString.get(i);
            count += getNumberOfSyllablesInWord(word);
        }

        if (iteration == 1) {
            if (count == 7) {
                return true;
            }
        } else {
            if (count == 5) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> haikuOrNotPrompt() {
        HaikuAnalysisEngine engine = new HaikuAnalysisEngine();
        ArrayList<String> haikuStrings = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            engine.menu.promptUser(i);
            String line = scan.nextLine();
            boolean validHaiku = haikuOrNot(i, line);
            if (validHaiku) {
                haikuStrings.add(line);
            }
            if (!validHaiku) {
                System.out.println("Not a valid haiku!");
                System.out.println("Please try again");
                haikuOrNotPrompt();
            }
        }
        return haikuStrings;
    }
}
