package src.main;

import java.io.IOException;

public class Person {
    private String firstName;
    private String lastName;
    private String email;

    // constructor
    public Person(String email){
        this.email = email;
    }

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
