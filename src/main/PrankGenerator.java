package src.main;
import java.io.*;

/**
 * Classe qui génère un prank pour un groupe de personnes
 * @author Jalube Miguel, Gillet Paul
 */
public class PrankGenerator {
    private final ConfigurationManager config;
    private final String separator;

    /**
     * Constructeur de la classe PrankGenerator
     * @param config
     * @param separator séparateur de ligne
     */
    public PrankGenerator(ConfigurationManager config, String separator) {
        this.config = config;
        this.separator = separator;
    }

    /**
     * Génère un prank
     * @param victims liste des victimes
     * @return le prank généré
     * @throws IOException
     */
    public Prank generatePrank(Group victims) throws IOException {
        String messageContent;
        int randomLineMsg = (int)(Math.random() * Utilities.countLines(config.getMessagesFilePath()));
        messageContent = Utilities.getLineFromNumber(randomLineMsg, config.getMessagesFilePath());
        String entete = messageContent.split(separator)[0];
        String corps = messageContent.split(separator)[1];
        return new Prank(victims, corps,entete);
    }
}
