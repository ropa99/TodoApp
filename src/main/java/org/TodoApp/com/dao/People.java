package org.TodoApp.com.dao;

import java.util.Collection;
import org.TodoApp.com.model.Person;

public interface People {
    public Person create(Person person);
    public Collection<Person> findAll();
    public Person findById(int personId);
    public Collection<Person> findByName(String name);
    public Person update(Person person);
    public boolean deleteById(int personId);
}
