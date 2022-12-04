package src.main.models;
import src.main.configs.ConfigurationManager;
import src.main.configs.Utilities;

import java.io.*;

/**
 * Classe qui génère un prank pour un groupe de personnes
 * @author Jalube Miguel, Gillet Paul
 */
public class PrankGenerator {
    private final ConfigurationManager config;

    /**
     * Constructeur de la classe PrankGenerator
     * @param config configuration de l'application
     */
    public PrankGenerator(ConfigurationManager config) {
        this.config = config;
    }

    /**
     * Génère un prank
     * @param victims liste des victimes
     * @return le prank généré
     * @throws IOException si le fichier des messages n'existe pas
     */
    public Prank generatePrank(Group victims) throws IOException {
        String messageContent;
        int randomLineMsg = (int)(Math.random() * Utilities.countLines(config.getMessagesFilePath()));
        messageContent = Utilities.getLineFromNumber(randomLineMsg, config.getMessagesFilePath());
        String entete = messageContent.split(config.getSeparator())[0];
        String corps = messageContent.split(config.getSeparator())[1];
        return new Prank(victims, corps,entete);
    }
}
