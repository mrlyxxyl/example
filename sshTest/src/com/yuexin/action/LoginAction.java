package com.yuexin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yuexin.bean.Person;
import com.yuexin.service.PersonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LoginAction extends ActionSupport {

    private PersonService personService;

    private String username;

    public String save() {
        personService = (PersonService) new ClassPathXmlApplicationContext("application.xml").getBean("personService");
        Person person = new Person();
        person.setName(username);
        personService.savePerson(person);
        ActionContext.getContext().put("saveSuccess", "保存成功！");
        return "save";
    }

    public String getPerson() {
        personService = (PersonService) new ClassPathXmlApplicationContext("application.xml").getBean("personService");
        List<Person> persons = personService.getPersons();
        ActionContext.getContext().put("persons", persons);
        return "getbeans";
    }

    public void validateSave() {
        if (username == null || "".equals(username.trim())) {
            this.addFieldError("username", "用户名不得为空！");
        }
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
