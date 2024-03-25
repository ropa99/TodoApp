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
        System.out.println(p.getSummary());
        TodoItem tdi = new org.TodoApp.com.TodoItem("Möte","Spela kort", java.time.LocalDate.now(),p);
        System.out.println(tdi.getSummary());
        TodoItemTask tdit = new org.TodoApp.com.TodoItemTask(tdi,p);
        System.out.println(tdit.getSummary());
    }
}
