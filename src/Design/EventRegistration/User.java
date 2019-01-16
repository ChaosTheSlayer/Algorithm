package Design.EventRegistration;
import java.util.List;

/**
 * Event Registration functionality implementation.
 * An event have start date, end data and a capacity
 * We need to implement:
 * Register()
 * Deregister()
 * Notify(), return all the registered users.
 */

/***
 * Follow up: User can bring any number of guests
 */
public class User{
    public int id;
    public String name;

    public List<User> guests;

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void addGuest(User guest)
    {
        guests.add(guest);
    }

    public void removeGuest(User guest)
    {
        guests.remove(guest);
    }
}

