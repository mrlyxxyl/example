package action;

import model.User;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<User> set = new HashSet<User>();
        User user = new User();
        user.setId(1);
        user.setName("ddd");
        set.add(user);
        for (User user1 : set) {
            System.out.println(user1.getName());
        }
    }
}
