package org.TodoApp.com;
import org.TodoApp.com.daoimpl.*;
import org.TodoApp.com.model.*;
import java.util.*;


public class TodoApp
{
    public static void main( String[] args )
    {
      /* org.TodoApp.com.model.Person p = new org.TodoApp.com.model.Person("Kalle","Karlsson","hej@gmail.com");
        System.out.println(p);
        org.TodoApp.com.model.TodoItem tdi = new org.TodoApp.com.model.TodoItem("Möte","Spela kort", java.time.LocalDate.now(),p);
        System.out.println(tdi);
        org.TodoApp.com.model.TodoItemTask tdit = new org.TodoApp.com.model.TodoItemTask(tdi,p);
        System.out.println(tdit);
        org.TodoApp.com.model.AppUser appu = new org.TodoApp.com.model.AppUser("Donald Duck","password", org.TodoApp.com.model.AppRole.ROLE_APP_ADMIN);
        System.out.println(appu);
        org.TodoApp.com.model.Person pCredentials = new org.TodoApp.com.model.Person("Bamse","skalman","hoj@hej.com",new org.TodoApp.com.model.AppUser("Bamse-liten","secretpwd", org.TodoApp.com.model.AppRole.ROLE_APP_USER));
        System.out.println(pCredentials);
        */
        //Part 3
      /*  AppUser appUser_1 = new AppUser("Kalle Anka","SecretPassword", org.TodoApp.com.model.AppRole.ROLE_APP_USER);
        AppUser appUser_2 = new AppUser("Musse Pigg","SecretPassword", org.TodoApp.com.model.AppRole.ROLE_APP_USER);
        AppUser appUser_3 = new AppUser("Janne Långben","SecretPassword", org.TodoApp.com.model.AppRole.ROLE_APP_USER);
        AppUserDAOCollection aUser = new AppUserDAOCollection();
        aUser.persist(appUser_1);
        aUser.persist(appUser_2);
        aUser.persist(appUser_3);

        */
        //Collection<AppUser> retValue = aUser.findAll();
        //AppUser retAppuser = aUser.findByUSerName("Musse Pigg");
        //System.out.println(retAppuser.getUsername());
        /* java.util.Iterator<AppUser> it = retValue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/
        Person p1 = new Person("Kalle","Anka","email");
        Person p2 = new Person("Musse","Pigg","email");
        Person p3 = new Person("Janne","Långben","email");
        PersonDAOCollection p = new PersonDAOCollection();
        p.persist(p1);
        p.persist(p2);
        p.persist(p3);


       // p.remove(2);
        /*Collection<Person> retVal = p.findAll();
        Iterator<Person> it = retVal.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

        //Person retVal =p.findByEmail("email");
        //Person retVal = p.findById(1);
        //Person retVal = p.findById(1);
        //System.out.println(retVal.getFirstName());
        TodoltemDAOCollection todo = new org.TodoApp.com.daoimpl.TodoltemDAOCollection();

        TodoItem to1 = new org.TodoApp.com.model.TodoItem("Hej","Springa", java.time.LocalDate.now().plusDays(10),p1);
        TodoItem to2 = new org.TodoApp.com.model.TodoItem("Hej Hej","Springa", java.time.LocalDate.now().plusDays(12),p2);
        TodoItem to3 = new org.TodoApp.com.model.TodoItem("Hej Hej Hej","Springa", java.time.LocalDate.now().plusDays(13),p3);
        todo.persist(to1);
        todo.persist(to2);
        todo.persist(to3);

        //Collection<TodoItem> retVal = todo.findAll();

        //todo.remove(5);
        /*Collection<TodoItem> retVal = todo.findAll();
        Iterator<TodoItem> it = retVal.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/
        //TodoItem to = todo.findById(6);
        //System.out.println(to.getCreator().getFirstName());
        Collection<TodoItem> retVal = todo.findByTitleContains("Hej");
        Iterator<TodoItem> it = retVal.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
