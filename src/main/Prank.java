package src.main;

public class Prank {
    private final Person sender;
    private final Group receivers;
    private final String message;

    public Prank(Person sender, Group receivers, String message){
        this.sender = sender;
        this.receivers = receivers;
        this.message = message;
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
}
