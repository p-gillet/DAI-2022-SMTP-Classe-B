package src.main;

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

    public static Person[] loadFromFile(String filename){
        Person[] people;


        return new Person[0];
    }
}
