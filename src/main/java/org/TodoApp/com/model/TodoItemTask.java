package org.TodoApp.com.model;

import org.TodoApp.com.sequencers.ID;
import org.TodoApp.com.model.TodoItem;
import org.TodoApp.com.model.Person;
import org.TodoApp.com.model.TodoItemTask;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;

    private org.TodoApp.com.model.Person assignee;



    public TodoItemTask(TodoItem todoItem, Person assignee) {
        setTodoItem(todoItem);
        setAssignee(assignee);
        setAssigned(false);
        this.id = setId();
    }
    public int getId() {
        return id;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }



    public Person getAssignee() {
        return assignee;
    }




/************/
    public void setTodoItem(TodoItem todoItem) {
        if(todoItem == null) throw new IllegalArgumentException("TodoItem can not be null");
        this.todoItem = todoItem;
    }

    public void setAssigned(boolean assigned) {
        //if(assigned == null) throw new IllegalArgumentException("Assigned can not be null");
        this.assigned = assigned;
    }
    public void setAssignee(org.TodoApp.com.model.Person assignee) {
        this.assignee = assignee;
    }
    public boolean isAssigned() {
        return assigned;
    }

    private int setId() {
        return ID.getInstance().getIdNumber();
    }

    @Override
    public String toString(){
        return "id: " + getId() + "," + "assigned: " + isAssigned()  + ", " + "todoItem: " + getTodoItem().getTaskDescription() + ", " + " assignee: " + getAssignee().getFirstName() + getAssignee().getLastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItemTask)) return false;
        TodoItemTask that = (TodoItemTask) o;
        return id == that.id && assigned == that.assigned && java.util.Objects.equals(todoItem, that.todoItem) && java.util.Objects.equals(assignee, that.assignee);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, assigned, todoItem, assignee);
    }
}
