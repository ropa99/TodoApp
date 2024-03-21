package org.TodoApp.com;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;

    private Person assignee;



    public TodoItemTask(org.TodoApp.com.TodoItem todoItem, org.TodoApp.com.Person assignee) {
        setTodoItem(todoItem);
        setAssignee(assignee);
        setAssigned(false);
        this.id = setId();
    }
    public int getId() {
        return id;
    }

    public org.TodoApp.com.TodoItem getTodoItem() {
        return todoItem;
    }



    public org.TodoApp.com.Person getAssignee() {
        return assignee;
    }



    public String getSummary(){
        String strSummary = "id: " + getId() + "," + "assigned: " + isAssigned()  + ", " + "todoItem: " + getTodoItem().getTaskDescription() + ", " + " assignee: " + getAssignee().getFirstName() + getAssignee().getLastName();

        return strSummary;
    }

    public void setTodoItem(org.TodoApp.com.TodoItem todoItem) {
        if(todoItem == null) throw new IllegalArgumentException("TodoItem can not be null");
        this.todoItem = todoItem;
    }

    public void setAssigned(boolean assigned) {
        //if(assigned == null) throw new IllegalArgumentException("Assigned can not be null");
        this.assigned = assigned;
    }
    public void setAssignee(org.TodoApp.com.Person assignee) {
        this.assignee = assignee;
    }
    public boolean isAssigned() {
        return assigned;
    }


    private int setId() {
        return ID.getIdNumber();
    }
}
