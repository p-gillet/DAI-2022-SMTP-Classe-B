package src.main;

import java.io.*;
import java.net.Socket;

public class SmtpClient {
    int port;
    String serverAddress;

    public SmtpClient(String serverAddress, int port){
        this.serverAddress = serverAddress;
        this.port = port;
    }

    public void sendPrank(Prank prank) throws IOException {
        Socket socket;
        socket = new Socket(serverAddress, port);
        System.out.println("Connected to server " + serverAddress + " on port " + port);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Group victims = prank.getReceivers();
        // Send HELO
        for (int i = 0; i < victims.getSize(); i++) {
            writer.write("telnet " + serverAddress + " " + port);
            writer.write("EHLO " + serverAddress);
            writer.write("MAIL FROM: " + "<miguel.jalube@heig.vd>");
            writer.write("RCPT TO: " + "<" + victims.getPerson(i).getEmail() + ">");
            writer.write("DATA");
            writer.write("From: " + "<" + prank.getSender().getEmail() + ">");
            writer.write("To: " + "<" + victims.getPerson(i).getEmail() + ">");
            writer.write("Subject: " + prank.getSubject());
            writer.write(prank.getMessage());
            writer.write(".");
            writer.write("QUIT");
            writer.flush();
        }
    }
}
