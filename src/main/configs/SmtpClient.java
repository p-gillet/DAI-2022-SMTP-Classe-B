package src.main.configs;

import src.main.models.Group;
import src.main.models.Person;
import src.main.models.Prank;

import java.io.*;
import java.net.Socket;

/**
 * Classe qui permet de gérer les connexions SMTP et l'envoi d'emails forgés
 * @author Jalube Miguel, Gillet Paul
 */

public class SmtpClient {
    int port;
    String serverAddress;

    /**
     * Constructeur de la classe SmtpClient
     * @param serverAddress l'adresse du serveur
     * @param port le port du serveur
     */
    public SmtpClient(String serverAddress, int port){
        this.serverAddress = serverAddress;
        this.port = port;
    }

    /**
     * Fonction qui permet d'envoyer un email forgé
     * @param prank le prank à envoyer
     * @throws IOException
     */
    public void sendPrank(Prank prank, int numberOfVictims) throws IOException {
        Socket socket;
        Group victims = prank.getVictims();
        Person sender = victims.getPerson((int)(Math.random() * victims.getSize()));
        victims.removePerson(sender);

        for(int i = 0; i < numberOfVictims;++i) {
            Person receiver = victims.getPerson((int)(Math.random() * victims.getSize()));
            victims.removePerson(receiver);
            socket = new Socket(serverAddress, port);
            System.out.println("Connected to server " + serverAddress + " on port " + port);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(reader.readLine());

            writer.write("EHLO " + serverAddress + "\r\n");
            writer.flush();

            writer.write("MAIL FROM:" + "<" + sender.getEmail() + ">" + "\r\n");
            writer.flush();

            writer.write("RCPT TO:" + "<" + receiver.getEmail() + ">" + "\r\n");
            writer.flush();

            writer.write("DATA" + "\r\n");
            writer.flush();

            writer.write("From: " + sender.getEmail() + "\r\n");
            writer.flush();
            writer.write("To: " + receiver.getEmail() + "\r\n");
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
