package org.TodoApp.com.dao;

import java.util.Collection;
import org.TodoApp.com.model.Person;

public interface PersonDAO {

    Person create(Person pUser);
    Collection<Person> findAll();
    Person findById(int id);
    Collection<Person> findByName(String name);
    Person update(Person person);
    boolean deleteById(int Id);
}
