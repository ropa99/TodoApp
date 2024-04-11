package org.TodoApp.com.daoimpl;
import org.TodoApp.com.dao.PersonDAO;
import org.TodoApp.com.model.Person;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
public class PersonDAOCollection implements PersonDAO {

    private  final List<Person> personList = new ArrayList<>();

    public PersonDAOCollection(){

    }

    public PersonDAOCollection(Person person) {

        this.persist(person);
    }

    @Override
    public Person persist(Person pUser) {
        if(!personList.add(pUser)){
            pUser = null;
        }
        return pUser;
    }

    @Override
    public Person findById(int id) {

        Person pId = null;
        for(Person pers: personList){
            if (pers.getId() == id) {
                pId = pers;
            }

        }

        return pId;

    }

    @Override
    public Person findByEmail(String email) {
        if(email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email Can not be null or empty");
        Person pEmail = null;
        for(Person pers: personList){
            if (pers.getEmail().equalsIgnoreCase(email)) {
                pEmail = pers;
            }

        }

        return pEmail;
    }

    @Override
    public Collection<Person> findAll() {
        //return personList;
        return new java.util.ArrayList<>(personList);
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
