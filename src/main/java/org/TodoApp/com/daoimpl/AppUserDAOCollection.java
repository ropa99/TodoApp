package org.TodoApp.com.daoimpl;
import org.TodoApp.com.dao.AppUserDAO;
import org.TodoApp.com.AppUser;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;

public class AppUserDAOCollection implements AppUserDAO {

    private final List<AppUser> appUserList;


    public AppUserDAOCollection(AppUser appUser) {
        appUserList = new ArrayList<>();
        appUserList.add(appUser);
    }

    @Override
    public AppUser persist(AppUser aUser) {
        appUserList.add(aUser);
        return aUser;
    }

    @Override
    public AppUser findByUSerName(String username) {
        if(username == null || username.trim().isEmpty()) throw new IllegalArgumentException("Cannot find null or empty username");
        AppUser aUser = null;
        Iterator<AppUser> it = appUserList.iterator();
        while(it.hasNext()){
            if (it.next().getUsername().equalsIgnoreCase(username)) {
                aUser = it.next();
            }
        }
        return aUser;

    }



    @Override
    public Collection<AppUser> findAll() {
        return appUserList;
    }

    @Override
    public void remove(String username) {
        if(username == null || username.trim().isEmpty()) throw new IllegalArgumentException("Cannot remove null or empty username");
        Iterator<AppUser> it = appUserList.iterator();
        while(it.hasNext()){
            if (it.next().getUsername().equalsIgnoreCase(username)) {
                it.remove();
            }
        }

    }
}
