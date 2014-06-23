package action;

import com.yuexin.bean.Person;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class FatherChildAction {

    private List<Person> persons;

    public FatherChildAction() {
        persons = new ArrayList<Person>();
        persons.add(new Person(1, "nanmeiying1"));
        persons.add(new Person(2, "nanmeiying2"));
        persons.add(new Person(3, "nanmeiying3"));
        persons.add(new Person(4, "nanmeiying4"));
    }

    public void click() {
        persons.add(new Person(5, "yuexin"));
    }

    public void dd(){
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

}
