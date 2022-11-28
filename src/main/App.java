package src.main;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{
    public static final int SMTP_PORT =         2525;
    public static final String SMTP_SERVER =    "localhost";
    public static final String VICTIMS_FILE =   "src/main/victims.txt";
    public static final String MESSAGES_FILE =  "src/main/messages.txt";
    public static final String SENDER_EMAIL =   "miguel.jalube@heig-vd.ch";
    public static final String SENDER_FNAME =   "Miguel";
    public static final String SENDER_LNAME =   "Jalube";

    public static void main( String[] args ) throws IOException {
        ConfigurationManager config = new ConfigurationManager(
                SMTP_SERVER,
                SMTP_PORT,
                VICTIMS_FILE,
                MESSAGES_FILE,
                new Person(SENDER_FNAME, SENDER_LNAME, SENDER_EMAIL)
        );
        PrankGenerator prankGenerator = new PrankGenerator(config);
        Group victims = Group.loadFromFile(config.getVictimsFilePath());

        SmtpClient smtpClient = new SmtpClient(config.getSmtpServerAddress(), config.getSmtpServerPort());
        smtpClient.sendPrank(prankGenerator.generatePrank(victims));

        System.out.println("Done");
    }
}
