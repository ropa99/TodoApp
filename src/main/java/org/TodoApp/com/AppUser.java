package org.TodoApp.com;

public class AppUser {
    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, org.TodoApp.com.AppRole role) {
       setUsername(username);
        setPassword(password);
        setRole(role);
    }


    public String getUsername(){
        return username;

    }
    public String getPassword(){
        return password;
    }

     public AppRole getRole(){
        return role;
     }


    /***************/

    public void setPassword(String password){
        if(password == null || password.trim().isEmpty()) throw new IllegalArgumentException("Password cannot be null or empty");
        this.password = password;
    }

     public void setUsername(String username) {
         if (username == null || username.trim().isEmpty())
             throw new IllegalArgumentException("User name cannot be null or empty");
         this.username = username;
     }
     public void setRole(AppRole role){
        if(role == null) throw new IllegalArgumentException("Role cannot be null");
        this.role = role;

    }



    /******************/
  /*  @Override
    public boolean equals(Object obj){
        return obj instanceof AppRole;

    }
    @Override
    public int hashCode(){
           return java.util.Objects.hashCode(username);
    }
*/

    @Override
    public String toString(){
          return  "User name: " + getUsername() + " Role: " +getRole().toString() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof org.TodoApp.com.AppUser)) return false;
        org.TodoApp.com.AppUser appUser = (org.TodoApp.com.AppUser) o;
        return java.util.Objects.equals(username, appUser.username) &&  role == appUser.role;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(username, role);
    }
}
