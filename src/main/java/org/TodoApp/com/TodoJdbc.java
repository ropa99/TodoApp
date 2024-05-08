package org.TodoApp.com;

import org.TodoApp.com.daoimpl.PersonDAOImpl;

public class TodoJdbc {
    public static void main(String[] args) {

        PersonDAOImpl p = new PersonDAOImpl();
        //org.TodoApp.com.model.Person p1 = new org.TodoApp.com.model.Person("Kalle", "Anka");
        //Person p2 = new Person("Anders", "Andersson");
        //org.TodoApp.com.model.Person person_1 = p.create(p1);
        //Person person_2 = p.create(p2);
       // org.TodoApp.com.model.Person p3 = new org.TodoApp.com.model.Person("Kalle", "Test");
        //org.TodoApp.com.model.Person person_3 = p.create(p3);


      /*java.util.List personLista = new java.util.ArrayList<>();
      personLista.add(p.findAll());
      System.out.println(personLista);
      */
        //boolean b = p.deleteById(2);

       // Person person = p.findById(1);
       // System.out.println(person);
        //Person p3 = new Person(1,"Kalle","Långben");
        //p.update(p3);
        java.util.List personLista = new java.util.ArrayList<>();
        personLista.add(p.findByName("Kalle"));
        System.out.println(personLista);




    }
}
