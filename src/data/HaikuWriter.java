package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HaikuWriter {

    public int generateID() {
        return 1;
    }

    public void logHaiku(String nameOfAuthor, ArrayList<String> haiku) {
        int authorID = generateID();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("listOfHaikus/" + "#" + authorID + "_" + nameOfAuthor + ".txt", StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            writer.println(haiku.get(i));
        }
        writer.close();
    }

}
