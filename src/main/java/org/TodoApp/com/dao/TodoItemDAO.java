package org.TodoApp.com.dao;

import java.util.Collection;
import org.TodoApp.com.model.Person;
import org.TodoApp.com.model.TodoItem;

public interface TodoItemDAO {
    TodoItem create(TodoItem todoItem);
    Collection<TodoItem> findAll();
    TodoItem findById(int id);
    Collection<TodoItem> findByDoneStatus(boolean isDone);
    Collection<TodoItem> findByAssignee (int id);
    Collection<TodoItem> findByAssignee (Person person);
    Collection<TodoItem> findByUnassignedTodoItems();
    TodoItem update(TodoItem todoItem);
    boolean deleteById(int id);

}
