package org.TodoApp.com.dao;
import org.TodoApp.com.TodoItem;
import java.util.Collection;
import java.time.LocalDate;

public interface TodoItemDAO {
    TodoItem persist(TodoItem tItem);
    TodoItem findById(int id);
    Collection<TodoItem> findAll();
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains (String title);
    Collection<TodoItem> findByPersonld(int personld);
    Collection<TodoItem> findByDeadlineBefore(LocalDate date);
    Collection<TodoItem>findByDeadlineAfter(LocalDate date);
    void remove(int id);
}
