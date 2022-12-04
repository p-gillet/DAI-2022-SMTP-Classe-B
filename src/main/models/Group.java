package src.main.models;

import src.main.configs.Utilities;

import java.io.IOException;
import java.util.Vector;

/**
 * Classe Group qui sert à former des groupes de personnes et de les gérer
 * @author Jalube Miguel, Gillet Paul
 */
public class Group {
    private final Vector<Person> people;

    /**
     * Constructeur de la classe Group
     */
    public Group(){
        people = new Vector<>();
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

    /**
     * Méthode qui permet de former un groupe de personnes à partir d'un fichier à lire
     * @param filename le nom du fichier à lire
     * @param groupSize la taille du groupe à former
     * @param groupN le numéro du groupe à former
     * @return le groupe de personnes formé
     * @throws IOException
     */
    public static Group loadFromFile(String filename, int groupSize, int groupN) throws IOException {
        Group group = new Group();
        for (int i = 0; i < groupSize; ++i){
            group.addPerson(Person.loadFromFile(filename, i+groupN*groupSize));
        }
        return group;
    }

    /**
     * Méthode qui permet de former plusieurs groupes de personnes à partir d'un fichier
     * @param filename le nom du fichier à lire
     * @param numberOfGroups le nombre de groupes à former
     * @return un tableau de groupes de personnes
     * @throws IOException
     */
    public static Vector<Group> loadGroupsFromFile(String filename, int numberOfGroups) throws IOException {
        Vector<Group> groups = new Vector<>(numberOfGroups);
        int number = Utilities.countLines(filename);
        int groupSize = number / numberOfGroups;
        int leftOver = number % numberOfGroups;

        if(groupSize < 3){
            throw new IOException("Not enough people in the file to form " + numberOfGroups + " groups");
        }

        for (int i = 0; i < numberOfGroups; ++i) {
            groups.add(i,loadFromFile(filename,groupSize,i));
        }

        // ajout des personnes restantes dans les groupes
        for (int i = 0; i < leftOver; ++i) {
            groups.get(i).addPerson(Person.loadFromFile(filename, groupSize * numberOfGroups + i));
        }
        return groups;
    }

    public void removePerson(Person p){ people.remove(p); }
}
