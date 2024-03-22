package org.TodoApp.com;
import java.time.LocalDate;
public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;


    public TodoItem(String title, String taskDescription, java.time.LocalDate deadLine, org.TodoApp.com.Person creator) {
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

    public org.TodoApp.com.Person getCreator() {
        return creator;
    }

    public String getSummary(){
        String strSummary = "id: " + getId() + "," + "title: " + getTitle() + ", " + "description: " + getTaskDescription() + ", " + "deadline " + getDeadLine() + ", " + "status: " + isDone() + ", " + "creator: " + getCreator().getFirstName() + " " + getCreator().getLastName();

        return strSummary;
    }
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

    public void setCreator(org.TodoApp.com.Person creator) {
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
        return ID.getIdNumber();
    }

}
