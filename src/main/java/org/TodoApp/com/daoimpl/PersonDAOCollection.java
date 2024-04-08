package org.TodoApp.com.daoimpl;
import org.TodoApp.com.dao.PersonDAO;
import org.TodoApp.com.Person;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
public class PersonDAOCollection implements PersonDAO {

    private  final List<Person> personList;

    public PersonDAOCollection(Person person) {
        personList = new ArrayList<>();
        personList.add(person);
    }

    @Override
    public Person persist(Person pUser) {
        personList.add(pUser);
        return pUser;
    }

    @Override
    public Person findById(int id) {

        Person pId = null;
        Iterator<Person> it = personList.iterator();
        while(it.hasNext()){
            if (it.next().getId() == id) {
                pId = it.next();
            }
        }

        return pId;

    }

    @Override
    public Person findByEmail(String email) {
        if(email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email Can not be null or empty");
        Person pEmail = null;

        Iterator<Person> it = personList.iterator();
        while(it.hasNext()){
            if (it.next().getEmail().equalsIgnoreCase(email)) {
                pEmail = it.next();
            }
        }

        return pEmail;
    }

    @Override
    public Collection<Person> findAll() {
        return personList;
    }

    @Override
    public void remove(int id) {

        Iterator<Person> it = personList.iterator();
        while(it.hasNext()){
            if (it.next().getId() == id) {
                it.remove();
            }
        }


    }
}
