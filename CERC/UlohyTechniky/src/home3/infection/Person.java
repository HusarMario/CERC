package home3.infection;

import java.util.ArrayList;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Person {
    private final ArrayList<Person> friends;

    public Person() {
        this.friends = new ArrayList<>();
    }

    public void addFriend(Person person) {
        this.friends.add(person);
    }

    public ArrayList<Person> getFriends() {
        return this.friends;
    }
}
