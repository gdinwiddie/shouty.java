package shouty;

import java.util.HashMap;
import java.util.Map;

public class Shouty implements Network {
    private static Map<String, Person> personsByName = new HashMap<String, Person>();
    private int shoutingRange = 1000;

    public Person addPerson(String name) {
        personsByName.put(name, new Person(name, this));
        return personsByName.get(name);
    }

    public Person getPerson(String name) {
        Person person = personsByName.get(name);
        if (null == person) {
            System.err.println("No person named " + name);
            addPerson(name);
            person = personsByName.get(name);
            person.setLocation(Integer.MAX_VALUE);
        }
        return person;
    }

    public void movePerson(String name1, int meters, String name2) {
        final Person person1 = getPerson(name1);
        final Person person2 = getPerson(name2);
        person1.setLocation(meters + person2.getLocation());
    }

    @Override
    public void broadcast(String message, String from) {
        Person shouter = getPerson(from);
        final int origin = shouter.getLocation();

        for (String name : personsByName.keySet()) {
            final Person listener = getPerson(name);
            if (listener.getLocation() - origin < shoutingRange) {
                listener.tell(message);
            }
        }
    }
}
