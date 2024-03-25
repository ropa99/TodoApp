package org.TodoApp.com;

/**
 * Hello world!
 *
 */
public class TodoApp
{
    public static void main( String[] args )
    {
        Person p = new Person("Kalle","Karlsson","hej@gmail.com");
        System.out.println(p);
        TodoItem tdi = new org.TodoApp.com.TodoItem("Möte","Spela kort", java.time.LocalDate.now(),p);
        System.out.println(tdi);
        TodoItemTask tdit = new org.TodoApp.com.TodoItemTask(tdi,p);
        System.out.println(tdit);
        AppUser appu = new AppUser("Donald Duck","password", org.TodoApp.com.AppRole.ROLE_APP_ADMIN);
        System.out.println(appu);
        Person pCredentials = new org.TodoApp.com.Person("Bamse","skalman","hoj@hej.com",new org.TodoApp.com.AppUser("Bamse-liten","secretpwd", org.TodoApp.com.AppRole.ROLE_APP_USER));
        System.out.println(pCredentials);
    }
}
