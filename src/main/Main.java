package src.main;

import java.io.IOException;
import java.util.Vector;

/**
 * Classe App qui permet de lancer le programme
 * @author Jalube Miguel, Gillet Paul
 */
public class Main
{
    public static void main( String[] args ) throws IOException {
        ConfigurationManager config = ConfigurationManager.loadFromFile("src/main/config.txt");
        PrankGenerator prankGenerator = new PrankGenerator(config,
           config.getSeparator());

        Vector<Group> groupsVictims =
           Group.loadGroupsFromFile(config.getVictimsFilePath(), config.getNumberOfGroups());

        SmtpClient smtpClient = new SmtpClient(config.getSmtpServerAddress(), config.getSmtpServerPort());

        for (int i = 0; i < config.getNumberOfGroups(); ++i) {
            smtpClient.sendPrank(prankGenerator.generatePrank(groupsVictims.get(i)));
        }

        System.out.println("Done");
    }
}
