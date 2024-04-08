package org.TodoApp.com.dao;
import org.TodoApp.com.TodoItem;
import java.util.Collection;
import java.time.LocalDate;

public interface TodoItemDAO {
    TodoItem persist(TodoItem tItem);
    TodoItem findById(int id);
    Collection<TodoItem> findAll();
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<Todoltem> findByTitleContains (String title);
    Collection<Todoltem> findByPersonld(int personld);
    Collection<Todoltem> findByDeadlineBefore(LocalDate date);
    Collection<Todoltem>findByDeadlineAfter(LocalDate date);
    void remove(int id);
}
