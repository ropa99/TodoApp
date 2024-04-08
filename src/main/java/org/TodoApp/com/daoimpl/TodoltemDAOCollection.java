package org.TodoApp.com.daoimpl;
import org.TodoApp.com.dao.TodoItemDAO;
import org.TodoApp.com.TodoItem;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import java.time.LocalDate;

public class TodoltemDAOCollection implements TodoItemDAO{

    private  final List<TodoItem> todoItemList;

    public TodoltemDAOCollection(TodoItem todoItem) {
        todoItemList = new java.util.ArrayList<>();
        todoItemList.add(todoItem);
    }

    @Override
    public TodoItem persist(TodoItem tItem) {
        todoItemList.add(tItem);
        return tItem;
    }

    @Override
    public TodoItem findById(int id) {
        TodoItem todoItem = null;
        Iterator<TodoItem> it = todoItemList.iterator();
        while(it.hasNext()){
            if (it.next().getId() == id) {
                todoItem = it.next();
            }
        }
        return todoItem;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return todoItemList;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        List<TodoItem> tmpList = new ArrayList<>();
        Iterator<TodoItem> it = todoItemList.iterator();
        while(it.hasNext()){
            if (done == it.next().isDone()) {
                tmpList.add(it.next());
            }
        }

        return tmpList;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        if(title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title can not be null or empty");
        List<TodoItem> tmpList = new ArrayList<>();
        Iterator<TodoItem> it = todoItemList.iterator();
        while(it.hasNext()){
            if (it.next().getTitle().equalsIgnoreCase(title)) {
                tmpList.add(it.next());
            }
        }

        return tmpList;

    }

    @Override
    public Collection<TodoItem> findByPersonld(int personld) {

        List<TodoItem> tmpList = new ArrayList<>();
        Iterator<TodoItem> it = todoItemList.iterator();

        while(it.hasNext()){
            if (it.next().getId() == personld) {
                tmpList.add(it.next());
            }
        }
        return tmpList;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        if(date == null) throw new IllegalArgumentException("Date can not be null or empty");
        List<TodoItem> tmpList = new ArrayList<>();
        Iterator<TodoItem> it = todoItemList.iterator();
        while(it.hasNext()){
            if (it.next().getDeadLine().isBefore(date)) {
                tmpList.add(it.next());
            }
        }
        return tmpList;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        if(date == null) throw new IllegalArgumentException("Date can not be null or empty");
        List<TodoItem> tmpList = new ArrayList<>();
        Iterator<TodoItem> it = todoItemList.iterator();
        while(it.hasNext()){
            if (it.next().getDeadLine().isAfter(date)) {
                tmpList.add(it.next());
            }
        }
        return tmpList;
    }

    @Override
    public void remove(int id) {
        Iterator<TodoItem> it = todoItemList.iterator();
        while(it.hasNext()){
            if (it.next().getId() == id) {
                it.remove();
            }
        }

    }
}
