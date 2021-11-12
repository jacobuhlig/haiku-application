package haikuanalysis;

import java.util.ArrayList;

public class HaikuAnalysisEngine {

    public ArrayList<String> getStringsInArrayList(String line) {
        ArrayList<String> strings = new ArrayList<>();

        for(String word : line.split(" ")) {
            strings.add(word);
        }
        return strings;
    }

    public boolean isVowel(char letter) {
        if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
            return true;
        } else {
            return false;
        }
    }

    public int getNumberOfSyllablesInWord(String wordInString) {

        int length = wordInString.length();

        int count = 0;

        //drew inspiration from this site 'https://www.delftstack.com/howto/java/syllable-counter-in-java/'
        for (int i = 0; i < length; i++) {
            String w = wordInString.toLowerCase();
            if(w.contains("a") || w.contains("e") || w.contains("i") || w.contains("o") || w.contains("u")) {
                if(isVowel(w.charAt(i)) && !((w.charAt(i)) == 'e') && (j == w.length()-1)) {
                    count += 1;
                    return false;
                }
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

        if(iteration == 1) {
            if(count == 7) {
                return true;
            }
        } else {
            if(count == 5) {
                return true;
            }
        }
        return false;
    }
}
