package src.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Utilities {
    static String[] splitString(String string, String separator){
        return string.split(separator);
    }

    static String getLineFromNumber(int number, String filename) throws IOException {
        String line = "";

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        for (int i = 0; i < number; i++) reader.readLine();
        line = reader.readLine();
        reader.close();

        return line;
    }

    // Count number of lines of the messages file
    static int countLines(String filename) throws IOException {
        int totalLines = 0;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (reader.readLine() != null) totalLines++;
        reader.close();
        return totalLines;
    }
}
