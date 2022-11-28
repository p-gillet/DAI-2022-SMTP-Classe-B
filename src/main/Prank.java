package src.main;

public class Prank {
    private final Person sender;
    private final Group receivers;
    private final String message;

    private final String entete;

    public Prank(Person sender, Group receivers, String message, String entete){
        this.sender = sender;
        this.receivers = receivers;
        this.message = message;
        this.entete = entete;
    }

    public Person getSender(){
        return sender;
    }

    public Group getReceivers(){
        return receivers;
    }

    public String getMessage(){
        return message;
    }

    public String getEntete(){
        return entete;
    }
}
