package org.TodoApp.com.daoimpl;
import org.TodoApp.com.dao.AppUserDAO;
import org.TodoApp.com.model.AppUser;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;

public class AppUserDAOCollection implements AppUserDAO {

    private final List<AppUser> appUserList = new ArrayList<>();

    public AppUserDAOCollection() {
    }

    public AppUserDAOCollection(AppUser appUser) {
        this.persist(appUser);
    }

    @Override
    public AppUser persist(AppUser aUser) {
        if(aUser == null) { throw new IllegalArgumentException("User can not be null"); }

        if (!appUserList.add(aUser)) { throw new IllegalArgumentException("Could not store user"); }
        return aUser;
    }

    @Override
    public AppUser findByUSerName(String username) {
        if(username == null || username.trim().isEmpty()) throw new IllegalArgumentException("Can not find null or empty username");
        AppUser aUser = null;
        for(AppUser app: appUserList){
            if (app.getUsername().equalsIgnoreCase(username)) {
                aUser = app;
            }

        }
        return aUser;

    }



    @Override
    public Collection<AppUser> findAll() {
        //return appUserList;
        return new java.util.ArrayList<>(appUserList);
    }

    @Override
    public void remove(String username) {
        if(username == null || username.trim().isEmpty()) throw new IllegalArgumentException("Can not remove null or empty username");
        Iterator<AppUser> it = appUserList.iterator();
        while(it.hasNext()){
            if (it.next().getUsername().equalsIgnoreCase(username)) {
                it.remove();
            }
        }

    }
}
