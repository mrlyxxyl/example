package dao;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PersonDao {

    public void save() {
        System.out.println("personDao --- save()");
    }
/*
    public void init(){
        System.out.println("init");
    }

    public void close(){

    }*/
}
