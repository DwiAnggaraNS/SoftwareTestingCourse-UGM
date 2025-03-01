import java.util.HashSet;
import java.util.Set;

public class UserManager {
    Set<String> users;

    public UserManager() {
        users = new HashSet<>();
    }

    public void addUser(String username) {
        users.add(username);
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    public boolean isUserExist(String username) {
        return users.contains(username);
    }

    public void clearUsers(){
        users.clear();
    }
}
