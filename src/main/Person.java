package src.main;

import java.io.IOException;

/**
 * Classe Person qui contient les informations d'une personne et les méthodes qui servent à les recupérer
 * @author Jalube Miguel, Gillet Paul
 */
public class Person {
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Constructeur de la classe Person
     * @param email email de la personne
     */
    public Person(String email){
        this.email = email;
    }

    /**
     * Constructeur de la classe Person
     * @param firstName prénom de la personne
     * @param lastName nom de la personne
     * @param email email de la personne
     */
    public Person(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Méthode qui permet de récupérer les informations d'une personne depuis un fichier
     * @param filename nom du fichier à lire
     * @param pos position de la personne dans le fichier
     * @return Personne
     * @throws IOException
     */
    public static Person loadFromFile(String filename, int pos) throws IOException {
        Person person;
        Utilities.getLineFromNumber(pos, filename);
        String[] personInfo = Utilities.splitString(Utilities.getLineFromNumber(pos, filename), ";");
        if (personInfo.length == 3){
            person = new Person(personInfo[0], personInfo[1], personInfo[2]);
        } else {
            person = new Person(personInfo[0]);
        }
        return person;
    }
}
