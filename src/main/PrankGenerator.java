package src.main;
import java.io.*;
import java.util.*;
import java.math.*;

public class PrankGenerator {
    private final ConfigurationManager config;

    public PrankGenerator(ConfigurationManager config){
        this.config = config;
    }

    public Prank generatePrank(Group victims) throws IOException {
        String messageContent;
        int randomLineMsg = (int)(Math.random() * Utilities.countLines(config.getMessagesFilePath()));
        messageContent = Utilities.getLineFromNumber(randomLineMsg, config.getMessagesFilePath());
        String entete = messageContent.split(";")[0];
        String corps = messageContent.split(";")[1];
        return new Prank(config.getSender(), victims, corps,entete);
    }
}
