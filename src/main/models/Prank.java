package src.main.models;

/**
 * @author Jalube Miguel, Gillet Paul
 */
public class Prank {
    private final Group victims;
    private final String message;

    private final String entete;

    public Prank(Group victims, String message, String entete){
        this.victims = victims;
        this.message = message;
        this.entete = entete;
    }

    public Group getVictims(){
        return victims;
    }

    public String getMessage(){
        return message;
    }

    public String getEntete(){
        return entete;
    }
}
