package org.TodoApp.com.daoimpl;
import org.TodoApp.com.dao.TodoItemTaskDAO;
import org.TodoApp.com.model.TodoItemTask;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;


public class TodoltemTaskDAOCollection implements TodoItemTaskDAO{

    private  final List<TodoItemTask> todoItemTaskList   = new java.util.ArrayList<>();

    public TodoltemTaskDAOCollection() {}

    public TodoltemTaskDAOCollection(TodoItemTask task) {

        this.persist(task);
    }

    @Override
    public TodoItemTask persist(TodoItemTask tTask) {
        if(tTask == null) { throw new IllegalArgumentException("To do Item task can not be null"); }
        todoItemTaskList.add(tTask);
        return tTask;
    }

    @Override
    public TodoItemTask findByld(int id) {
        TodoItemTask todoItemTask = null;
        TodoItemTask task = null;
        for(TodoItemTask todo : todoItemTaskList){
            if(todo.getId() == id){
                todoItemTask = todo;
            }
        }
        return todoItemTask;


    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new java.util.ArrayList<>(todoItemTaskList);
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
       for(TodoItemTask task : todoItemTaskList){
           if(task.getId() == personld){
               tmpList.add(task);
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
