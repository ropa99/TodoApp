package org.TodoApp.com;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        this.id = setId();
    }


    public int getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }


    public String getEmail(){
        return this.email;
    }
    public String getSummary(){
        String strSummary = "id: " + getId() + "," + " name: " + getFirstName() + " " + getLastName() + ", " + "email: " + getEmail();

        return strSummary;
    }

    public void setFirstName(String firstName){
        if(firstName == null || firstName.trim().isEmpty()) throw new IllegalArgumentException("First name cannot be null or empty");
        this.firstName = firstName;

    }
    public  void setLastName(String lastName){
        if(lastName == null || lastName.trim().isEmpty()) throw new IllegalArgumentException("Last name cannot be null or empty");
        this.lastName = lastName;
    }
    public void setEmail(String email){
        if(email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email cannot be null or empty");
        this.email = email;

    }

    private int setId() {

        return ID.getIdNumber();

    }
}
