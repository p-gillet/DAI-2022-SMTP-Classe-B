package src.main;

public class Person {
    private String firstName;
    private String lastName;
    private String email;

    public Person(String email){
        this.email = email;
    }

    public Person(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

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
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                String[] parts = data.split(" ");
                String firstName = parts[0];
                String lastName = parts[1];
                String email = parts[2];
                people = new Person(firstName, lastName, email);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return people;
    }
}
