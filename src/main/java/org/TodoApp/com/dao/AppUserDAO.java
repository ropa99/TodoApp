package org.TodoApp.com.dao;
import org.TodoApp.com.model.AppUser;
import java.util.Collection;
public interface AppUserDAO {
    AppUser persist(AppUser aUser);
    AppUser findByUSerName(String username);
    Collection<AppUser> findAll();
    void remove(String username);
}
