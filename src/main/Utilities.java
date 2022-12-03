package src.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe qui contient des méthodes utiles à la lecture de fichiers
 * @author Jalube Miguel, Gillet Paul
 */
public abstract class Utilities {
    /**
     * Fonction qui sert à splitter une chaine de caractère en fonction d'un séparateur
     * @param string la chaine de caractère à splitter
     * @param separator le séparateur
     * @return un tableau de chaine de caractère
     */
    static String[] splitString(String string, String separator){
        return string.split(separator);
    }

    /**
     * Fonction qui sert à lire une ligne d'un fichier
     * @param number nombre de ligne à lire
     * @param filename  le nom du fichier
     * @return un string contenant la ligne lue
     * @throws IOException
     */
    static String getLineFromNumber(int number, String filename) throws IOException {
        String line = "";

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        for (int i = 0; i < number; i++) reader.readLine();
        line = reader.readLine();
        reader.close();

        return line;
    }

    /**
     * Fonction qui retourne le nombre de ligne d'un fichier
     * @param filenam le nom du fichier
     * @return le nombre de ligne du fichier
     * @throws IOException
     */
    static int countLines(String filename) throws IOException {
        int totalLines = 0;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (reader.readLine() != null) totalLines++;
        reader.close();
        return totalLines;
    }
}
