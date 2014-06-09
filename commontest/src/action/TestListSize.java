package action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestListSize {
    public static void main(String[] args) {
        List<Animal> list = new ArrayList<Animal>();
        for (int i = 0; i < 200000; i++) {
            list.add(new Animal(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        }
        System.out.println(list.size());
    }
}

class Animal {
    private String id;
    private String name;

    Animal(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
