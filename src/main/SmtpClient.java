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
        String sender = prank.getSender().getEmail();
        Socket socket;
        Group victims = prank.getReceivers();
        int size = victims.getSize();

        for (int i = 0; i < size; i++) {
            socket = new Socket(serverAddress, port);
            System.out.println("Connected to server " + serverAddress + " on port " + port);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(reader.readLine());

            writer.write("EHLO " + serverAddress + "\r\n");
            writer.flush();

            writer.write("MAIL FROM:" +"<"+ prank.getSender().getEmail() +">"+ "\r\n");
            writer.flush();

            writer.write("RCPT TO:" + "<" + victims.getPerson(i).getEmail() + ">" + "\r\n");
            writer.flush();

            writer.write("DATA" + "\r\n");
            writer.flush();

            writer.write("From: " + prank.getSender().getEmail() + "\r\n");
            writer.flush();
            writer.write("To: " + victims.getPerson(i).getEmail() + "\r\n");
            writer.flush();
            writer.write("Subject: " + prank.getEntete() + "\r\n");
            writer.flush();
            writer.write("\r\n");
            writer.flush();
            String corps = prank.getMessage();
            writer.write(corps + "\r\n");
            writer.flush();
            writer.write(".\r\n");
            writer.flush();

            System.out.println(reader.readLine());
            writer.write("quit\r\n");
            writer.flush();

            socket.close();
        }

    }
}
