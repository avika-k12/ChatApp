import java.util.ArrayList;
import java.util.Scanner;

public class ChatApp {
    private static ArrayList <User> users;
    private static ArrayList <Message> messages;

    public ChatApp() {
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public static void addUser(User user){
        users.add(user);
    }

    public static void sendMessage(String sender, String receiver, String content){
        boolean foundSender = false;
        boolean foundReceiver = false;

        for (User searchedItem : users){
            if (searchedItem.equals(sender)){
                foundSender = true;
            }
            if (searchedItem.equals(receiver)){
                foundReceiver = true;
            }
        }

        if (foundSender && foundReceiver) {
            Message messageToAdd = new Message(sender, receiver, content);
            messages.add(messageToAdd);
            System.out.println("Your message has been sent!");
        }

        else {
            System.out.println("Your sender or receiver was not found");
        }
    }

    public static void viewMessages(String username){
        for (Message item : messages) {
            if (item.equals(username)) {
                System.out.println("Here is the message that matched your search: " + item);
            } else {
                System.out.println("No messages matched your search.");
            }
        }
        System.out.println("Message checking complete");
    }

    private String findUser(String username){
        for (User item : users){
            if (item.equals(username)){
                return "Your username has been found: " + item;
            }
            else{
                return null;
            }
        }
        return "Finding users check completed";
    }

    public static void main(String[] args){
        ChatApp AvikasAwesomeApp = new ChatApp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name? -> ");
        String name = scanner.nextLine();
        System.out.println("Hi " + name + "! Here is your ChatApp!");
        System.out.println();

        boolean exit = false;
        while (!exit){
            System.out.println("---Menu---");
            System.out.println("1. Add User");
            System.out.println("2. Send Message");
            System.out.println("3. View Messages");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("What is your username? ");
                    String username = scanner.nextLine();
                    User userToAdd = new User(username);
                    addUser(userToAdd);
                case "2":
                    System.out.println("Enter your sender: ");
                    String sender = scanner.nextLine();
                    System.out.println("Enter your receiver: ");
                    String receiver = scanner.nextLine();
                    System.out.println("Enter your content: ");
                    String content = scanner.nextLine();
                    sendMessage(sender, receiver, content);
                case "3":
                    System.out.println("What is your username? ");
                    String usernameForViewing = scanner.nextLine();
                    viewMessages(usernameForViewing);
                case "4":
                    exit = true;
                    System.out.println("Goodbye!");
                default:
                    System.out.println("Invalid option, please try again.");
            }

            scanner.close();
        }
    }
}
