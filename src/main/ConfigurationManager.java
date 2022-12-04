package src.main;

import java.io.IOException;

/**
 * Classe ConfigurationManager qui permet de gérer les paramètres de configuration de l'application
 * @author Jalube Miguel, Gillet Paul
 */
public class ConfigurationManager {
    private String smtpServerAddress;
    private int smtpServerPort;
    private String victimsFilePath;
    private String messagesFilePath;
    private int numberOfGroups;
    private String separator;

    private Person sender;

    /**
     * Constructeur de la classe ConfigurationManager
     * @param smtpServerAddress adresse du serveur SMTP
     * @param smtpServerPort port du serveur SMTP
     * @param victimsFilePath chemin du fichier contenant les victimes
     * @param messagesFilePath chemin du fichier contenant les messages(prank)
     */
    public ConfigurationManager(String smtpServerAddress, int smtpServerPort,
                                String victimsFilePath,
                                String messagesFilePath, int numberOfGroups,
                                String separator) {
        this.smtpServerAddress = smtpServerAddress;
        this.smtpServerPort = smtpServerPort;
        this.victimsFilePath = victimsFilePath;
        this.messagesFilePath = messagesFilePath;
        this.numberOfGroups = numberOfGroups;
        this.separator = separator;

    }

    public String getSmtpServerAddress(){
        return smtpServerAddress;
    }

    public int getSmtpServerPort(){
        return smtpServerPort;
    }

    public String getVictimsFilePath(){
        return victimsFilePath;
    }

    public String getMessagesFilePath(){
        return messagesFilePath;
    }

    public void setSmtpServerAddress(String smtpServerAddress){
        this.smtpServerAddress = smtpServerAddress;
    }

    public void setSmtpServerPort(int smtpServerPort){
        this.smtpServerPort = smtpServerPort;
    }

    public void setVictimsFilePath(String victimsFilePath){
        this.victimsFilePath = victimsFilePath;
    }

    public void setMessagesFilePath(String messagesFilePath){
        this.messagesFilePath = messagesFilePath;
    }

    public Person getSender(){
        return sender;
    }

    public void setSender(Person sender){
        this.sender = sender;
    }

      public int getNumberOfGroups(){
         return numberOfGroups;
      }

      public void setNumberOfGroups(int numberOfGroups){
         this.numberOfGroups = numberOfGroups;
      }

      public String getSeparator(){
         return separator;
      }

      public void setSeparator(String separator){
         this.separator = separator;
      }

    public static ConfigurationManager loadFromFile(String filename) throws IOException {
        String separator = Utilities.getLineFromNumber(0, filename);
        int smtpServerPort = Integer.parseInt(Utilities.getLineFromNumber(1,
           filename));
        String smtpServerAddress = Utilities.getLineFromNumber(2, filename);
        String victimsFilePath = Utilities.getLineFromNumber(3, filename);
        String messagesFilePath = Utilities.getLineFromNumber(4, filename);
        int numberOfGroups = Integer.parseInt(Utilities.getLineFromNumber(5,
           filename));
        return new ConfigurationManager(smtpServerAddress, smtpServerPort,
           victimsFilePath, messagesFilePath, numberOfGroups, separator);
    }
}
