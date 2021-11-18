package data;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HaikuWriter {

    //generates an ID based on the number of files in the directory "listOfHaikus"
    public int generateID() {
        File directory = new File("listOfHaikus/");
        int numberOfFiles = directory.list().length;

        return numberOfFiles + 1; //adds 1 to that number, therein incrementing with 1 for each new file
    }

    public void logHaiku(String nameOfAuthor, ArrayList<String> haiku) {
        int authorID = generateID();
        PrintWriter writer = null;
        try {
            //The formatting of the file Name
            writer = new PrintWriter("listOfHaikus/" + "#" + authorID + "_" + nameOfAuthor + ".txt", StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //logs the three lines of the haiku
        for (int i = 0; i < 3; i++) {
            writer.println(haiku.get(i));
        }
        writer.close();
    }

}
