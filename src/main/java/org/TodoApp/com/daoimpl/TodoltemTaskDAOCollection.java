package org.TodoApp.com.daoimpl;
import org.TodoApp.com.dao.TodoItemTaskDAO;
import org.TodoApp.com.model.TodoItemTask;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;


public class TodoltemTaskDAOCollection implements TodoItemTaskDAO{

    private  final List<TodoItemTask> todoItemTaskList;

    public TodoltemTaskDAOCollection(TodoItemTask task) {
        todoItemTaskList = new java.util.ArrayList<>();
        todoItemTaskList.add(task);
    }

    @Override
    public TodoItemTask persist(TodoItemTask tTask) {
        todoItemTaskList.add(tTask);
        return tTask;
    }

    @Override
    public TodoItemTask findByld(int id) {
        TodoItemTask todoItemTask = null;
        Iterator<TodoItemTask> it = todoItemTaskList.iterator();
        while(it.hasNext()){
            if (it.next().getId() == id) {
                todoItemTask = it.next();
            }
        }
        return todoItemTask;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return todoItemTaskList;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        List<TodoItemTask> tmpList = new ArrayList<>();
        Iterator<TodoItemTask> it = todoItemTaskList.iterator();
        while(it.hasNext()){
            if (status == it.next().isAssigned()) {
                tmpList.add(it.next());
            }
        }
        return tmpList;
    }

    @Override
    public Collection<org.TodoApp.com.model.TodoItemTask> findByPersonid(int personld) {
        List<TodoItemTask> tmpList = new ArrayList<>();
        Iterator<TodoItemTask> it = todoItemTaskList.iterator();
        while(it.hasNext()){
            if (it.next().getId() == personld) {
                tmpList.add(it.next());
            }
        }
        return tmpList;
    }

    @Override
    public void remove(int id) {
        Iterator<TodoItemTask> it = todoItemTaskList.iterator();
        while(it.hasNext()){
            if (it.next().getId() == id) {
                it.remove();
            }
        }

    }
}
