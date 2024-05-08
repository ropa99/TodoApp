package org.TodoApp.com.model;
//refactored to jdbc assignment
public class Person {
    private int id;
    private String firstName;
    private String lastName;

    //Get/update data
    public Person(int id,String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        setId(id);


    }

    //Insert data
    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    /******************/
    public int getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    /***************/

    public void setFirstName(String firstName){
        if(firstName == null || firstName.trim().isEmpty()) throw new IllegalArgumentException("First name cannot be null or empty");
        this.firstName = firstName;

    }
    public  void setLastName(String lastName){
        if(lastName == null || lastName.trim().isEmpty()) throw new IllegalArgumentException("Last name cannot be null or empty");
        this.lastName = lastName;
    }


    public void setId(int id) {
        this.id = id;

    }
    /*************/
    @Override
    public String toString(){
        return "id: " + getId() + "," + " name: " + getFirstName() + " " + getLastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof org.TodoApp.com.model.Person)) return false;
        org.TodoApp.com.model.Person person = (org.TodoApp.com.model.Person) o;
        return id == person.id && java.util.Objects.equals(firstName, person.firstName) && java.util.Objects.equals(lastName, person.lastName)  ;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, firstName, lastName);
    }
}
