package org.TodoApp.com.dao;

import com.sun.tools.javac.comp.Todo;
import java.util.Collection;
import org.TodoApp.com.model.Person;

public interface Todoltems {
    public Todo create(Todo todo);
    public Collection<Todo> findAll();
    public Todo findById(int todoId);
    public Collection<Todo> findByDoneStatus(boolean status);
    public Collection<Todo> findByAssignee(int assigneeId);
    public Collection<Todo> findByAssignee(Person person);
    public Collection<Todo> findByUnassignedTodoItems();
    public Todo update(Todo todo);
    public boolean deleteById(int todoItemsId);
}
