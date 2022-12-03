package src.main;

import java.io.IOException;
import java.util.Vector;

/**
 * Classe App qui permet de lancer le programme
 * @author Jalube Miguel, Gillet Paul
 */
public class App
{
    public static final String FILE_SEPARATOR = ";";
    public static final int SMTP_PORT =         2525;
    public static final String SMTP_SERVER =    "localhost";
    public static final String VICTIMS_FILE = "src/main/sourceFiles/victims.txt";
    public static final String MESSAGES_FILE = "src/main/sourceFiles/messages.txt";
    public static final int NUMBER_OF_GROUPS = 4;

    public static void main( String[] args ) throws IOException {
        ConfigurationManager config = new ConfigurationManager(
                SMTP_SERVER,
                SMTP_PORT,
                VICTIMS_FILE,
                MESSAGES_FILE
        );
        PrankGenerator prankGenerator = new PrankGenerator(config,FILE_SEPARATOR);

        Vector<Group> groupsVictims = Group.loadGroupsFromFile(config.getVictimsFilePath(), NUMBER_OF_GROUPS);

        SmtpClient smtpClient = new SmtpClient(config.getSmtpServerAddress(), config.getSmtpServerPort());

        for (int i = 0; i < NUMBER_OF_GROUPS; ++i) {
            smtpClient.sendPrank(prankGenerator.generatePrank(groupsVictims.get(i)));
        }

        System.out.println("Done");
    }
}
