package org.TodoApp.com.dao;
import org.TodoApp.com.Person;
import java.util.Collection;

public interface PersonDAO {

    Person persist(Person pUser);
    Person findById(int id);
    Person findByEmail(String email);
    Collection<Person> findAll();
    void remove(int id);
}
