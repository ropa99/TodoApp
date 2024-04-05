package org.TodoApp.com.sequencers;

public class TodoltemTaskidSequencer {
    private static int currentId;

    private static int nextId(){
        setCurrentId(getCurrentId()+1);
        return getCurrentId();
    }
    public static int getCurrentId(){return currentId;}
    private static void setCurrentId(int id){currentId = id;}
}
