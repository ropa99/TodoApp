package org.TodoApp.com.model;

import java.time.LocalDate;
import org.TodoApp.com.sequencers.ID;
import org.TodoApp.com.model.Person;
import java.time.LocalDate;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;


    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator) {
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
       setCreator(creator);
        setDone(false);
        this.id = setId();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public Person getCreator() {
        return creator;
    }

    /********************/

    public void setTitle(String title) {

        if(title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty");
        this.title = title;
    }
    public void setDeadLine(LocalDate deadLine) {
        if(deadLine == null ) throw new IllegalArgumentException("Deadline cannot be null");
        if(isOverDue(deadLine)) throw new IllegalArgumentException("Deadline is overdue");
        this.deadLine = deadLine;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreator(org.TodoApp.com.model.Person creator) {
        this.creator = creator;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isDone() {
        return done;
    }

    private boolean isOverDue(LocalDate ld){
        if(LocalDate.now().isAfter(ld)){
            return true;
        }else {
            return false;
        }

    }
    private int setId() {

        return ID.getInstance().getIdNumber();
    }

    @Override
    public String toString(){
        return "id: " + getId() + "," + "title: " + getTitle() + ", " + "description: " + getTaskDescription() + ", " + "deadline " + getDeadLine() + ", " + "status: " + isDone() + ", " + "creator: " + getCreator().getFirstName() + " " + getCreator().getLastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof org.TodoApp.com.model.TodoItem)) return false;
        org.TodoApp.com.model.TodoItem todoItem = (org.TodoApp.com.model.TodoItem) o;
        return id == todoItem.id && done == todoItem.done && java.util.Objects.equals(title, todoItem.title) && java.util.Objects.equals(taskDescription, todoItem.taskDescription) && java.util.Objects.equals(deadLine, todoItem.deadLine) && java.util.Objects.equals(creator, todoItem.creator);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, title, taskDescription, deadLine, done, creator);
    }
}
