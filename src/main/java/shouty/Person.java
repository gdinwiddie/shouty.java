package shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final Network network;
    private List<String> messages = new ArrayList<String>();
    private String name = "";
    private int location = 0;

    public Person(String name, Network network) {
        this.name = name;
        this.network = network;
    }

    public List<String> messagesHeard() {
        return messages;
    }

    public void shout(String message) {
        network.broadcast(message, name);
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void tell(String message) {
        messages.add(message);
    }
}