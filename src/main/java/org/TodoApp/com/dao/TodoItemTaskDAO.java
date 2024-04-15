package org.TodoApp.com.dao;
import org.TodoApp.com.model.TodoItemTask;
import java.util.Collection;

public interface TodoItemTaskDAO {
    TodoItemTask persist(TodoItemTask tTask);
    TodoItemTask findByld(int id);
    Collection<TodoItemTask> findAll();
    Collection<TodoItemTask> findByAssignedStatus(boolean status);
    Collection<TodoItemTask> findByPersonid(int personld);
    void remove(int id);
}
