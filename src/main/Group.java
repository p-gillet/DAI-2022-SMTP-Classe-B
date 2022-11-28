package src.main;

import java.io.IOException;
import java.util.Vector;

public class Group {
    private final Vector<Person> people;

    public Group(){
        people = new Vector<Person>();
    }

    public Person getPerson(int pos){
        return people.get(pos);
    }

    public void addPerson(Person p){
        people.add(p);
    }

    public int getSize(){
        return people.size();
    }

    public static Group loadFromFile(String filename) throws IOException {
        Group group = new Group();
        int number = Utilities.countLines(filename);
        for (int i = 0; i < number; i++){
            group.addPerson(Person.loadFromFile(filename, i));
        }
        return group;
    }
}
