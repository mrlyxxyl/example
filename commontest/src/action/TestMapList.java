package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMapList {
    public static void main(String[] args) {
        Map<PeopleNat, List<StudentNat>> map = new HashMap<PeopleNat, List<StudentNat>>();
        List<StudentNat> students;
        PeopleNat p = null;
        for (int i = 0; i < 10000; i++) {
            p = new PeopleNat("id=" + i, "name=" + i);
            students = new ArrayList<StudentNat>();
            for (int j = 0; j < 3; j++) {
                students.add(new StudentNat("id= " + i + j, "name=" + i + j));
            }
            map.put(p, students);
        }
        PeopleNat ppp  = p;
        map.get(ppp).get(0).setName("fjlkdsjfdsjf");
        System.out.println(map.get(p).get(0).getName());
       /* PeopleNat ptmp;
        List<StudentNat> stmp;
        for (Map.Entry<PeopleNat, List<StudentNat>> entry : map.entrySet()) {
            ptmp = entry.getKey();
            System.out.println("people_id =" + ptmp.getId() + "  people_name=" + ptmp.getName());
            stmp = entry.getValue();
            for (StudentNat student : stmp) {
                System.out.println("-----student_id=" + student.getId() + "    student_name=" + student.getName());
            }
        }*/
    }
}


class PeopleNat {
    private String id;
    private String name;

    PeopleNat(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class StudentNat {
    private String id;
    private String name;

    StudentNat(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

