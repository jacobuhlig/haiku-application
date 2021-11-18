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

    //this method represents the most complicated part of this assignment, the actual counting of the syllables
    //and with what logic should lie behind it
    public int getNumberOfSyllablesInWord(String wordInString) {

        String w = wordInString.toLowerCase();
        int length = w.length();

        int count = 0;

        boolean isSyllable = false;

        //drew inspiration from this site 'https://www.delftstack.com/howto/java/syllable-counter-in-java/'
        for (int i = 0; i < length; i++) {

            //if any of the following vowels are present in the word in question, the second if-statement is entered
            if (w.contains("a") || w.contains("e") || w.contains("i") || w.contains("o") || w.contains("u") || w.contains("y")) {

                //here a lot is going on (I know!)
                //essentially there are to statements that have to be true, if the word isn't "the"
                //the word has to be a vowel, which is checked with the isVowel method. Additionally, if the loop is at the
                //last letter of a word, and that word happens to not be an 'e', the subsequent if-statement is entered
                if (isVowel(w.charAt(i)) && !((w.charAt(i) == 'e') && (i == w.length() - 1)) || w.equals("the")) {

                    //as the boolean isSyllable was initialized as false, count increments by 1
                    //after that, the boolean is changed to true
                    //the reason for this being that two conjoined vowels doesn't equate to an extra syllable
                    //(of course with few exceptions not accounted for in the scope of this program)
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

        //each line is split up into individual words and the number of syllables in each word are accumulated in variable 'count'
        for (int i = 0; i < size; i++) {
            String word = wordsInString.get(i);
            count += getNumberOfSyllablesInWord(word);
        }

        //as a haiku consists of three lines, with 5, 7 and 5 syllables respectively
        //all but the second iteration (index 1) are 5, which explains the logic
        //behind the following if-else statement
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
            boolean validHaiku = haikuOrNot(i, line); //checks if haiku line is valid or not
            if (validHaiku) {
                haikuStrings.add(line);
            }
            if (!validHaiku) { // if the line isn't valid, the method is called again
                System.out.println("Not a valid haiku!");
                System.out.println("Please try again");
                haikuOrNotPrompt();
            }
        }
        return haikuStrings;
    }
}
