package src.main;

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
}
