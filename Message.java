import java.time.LocalDateTime;

public class Message {
    private static String sender;
    private static String receiver;
    private static String content;
    private static LocalDateTime timeStamp;

    public Message(String sender, String receiver, String content){
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timeStamp = LocalDateTime.now();
    }

    public String getSender(String sender){
        this.sender = sender;
        return "New sender: " + sender;
    }

    public String getReceiver(String receiver){
        this.receiver = receiver;
        return "New receiver: " + receiver;
    }

    public String getContent(String content){
        this.content = content;
        return "New content: " + content;
    }
}
