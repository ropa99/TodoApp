package org.TodoApp.com;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    public Person(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        this.id = setId();
    }

    public Person(String firstName, String lastName, String email, org.TodoApp.com.AppUser credentials) {
        this(firstName,lastName,email);
        setCredentials(credentials);
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

    public String getEmail(){
        return this.email;
    }


    public AppUser getCredentials() {
        return credentials;
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
    public void setEmail(String email){
        if(email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email cannot be null or empty");
        this.email = email;

    }
    public void setCredentials(AppUser credentials) {
        if(credentials == null) throw new IllegalArgumentException("Credentials cannot be null");
        this.credentials = credentials;
    }

    private int setId() {

        return org.TodoApp.com.sequencers.ID.getInstance().getIdNumber();

    }
    /*************/
    @Override
    public String toString(){
        return "id: " + getId() + "," + " name: " + getFirstName() + " " + getLastName() + ", " + "email: " + getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof org.TodoApp.com.Person)) return false;
        org.TodoApp.com.Person person = (org.TodoApp.com.Person) o;
        return id == person.id && java.util.Objects.equals(firstName, person.firstName) && java.util.Objects.equals(lastName, person.lastName) && java.util.Objects.equals(email, person.email) ;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, firstName, lastName, email);
    }
}
