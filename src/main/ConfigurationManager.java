package src.main;

public class ConfigurationManager {
    private String smtpServerAddress;
    private int smtpServerPort;
    private String victimsFilePath;
    private String messagesFilePath;

    private Person sender;

    public ConfigurationManager(String smtpServerAddress, int smtpServerPort, String victimsFilePath, String messagesFilePath, Person sender){
        this.smtpServerAddress = smtpServerAddress;
        this.smtpServerPort = smtpServerPort;
        this.victimsFilePath = victimsFilePath;
        this.messagesFilePath = messagesFilePath;
        this.sender = sender;
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
}
