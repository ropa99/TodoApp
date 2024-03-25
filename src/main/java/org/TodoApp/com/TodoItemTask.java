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




/************/
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

    @Override
    public String toString(){
        return "id: " + getId() + "," + "assigned: " + isAssigned()  + ", " + "todoItem: " + getTodoItem().getTaskDescription() + ", " + " assignee: " + getAssignee().getFirstName() + getAssignee().getLastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof org.TodoApp.com.TodoItemTask)) return false;
        org.TodoApp.com.TodoItemTask that = (org.TodoApp.com.TodoItemTask) o;
        return id == that.id && assigned == that.assigned && java.util.Objects.equals(todoItem, that.todoItem) && java.util.Objects.equals(assignee, that.assignee);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, assigned, todoItem, assignee);
    }
}
