package org.TodoApp.com.dao;
import org.TodoApp.com.TodoItemTask;
import java.util.Collection;

public interface TodoItemTaskDAO {
    TodoltemTask persist(todoltemTask tTask);
    TodoltemTask findByld(int id);
    Collection<TodoltemTask> findAll();
    Collection<TodoltemTask> findByAssignedStatus(boolean status);
    Collection<TodoltemTask> findByPersonid(int personld);
    void remove(int id);
}
