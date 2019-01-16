package Design.EventRegistration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
    public Date startDate;
    public Date endDate;
    public int capacity;
    public String name;

    private List<User> registeredUsers = new ArrayList<>();

    public Event(Date startDate, Date endDate, int capacity, String name) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacity = capacity;
        this.name = name;
    }

    public boolean register(User user) {
        if (registeredUsers.size() < capacity) {
            registeredUsers.add(user);
            return true;
        } else {
            return false;
        }
    }

    public void deregister(User user) {
        registeredUsers.remove(user);
    }

    public List<User> notifyUsers(){
        return registeredUsers;
    }

}
