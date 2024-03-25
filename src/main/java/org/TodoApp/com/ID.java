package org.TodoApp.com;
import java.util.Random;
public class ID {

    private static int generateId(){
        try {
                Random ran = new java.util.Random();
                return ran.nextInt(Integer.MAX_VALUE - 1);
        }catch(NumberFormatException nfe) {
                throw new NumberFormatException("Could not create an id number");
        }

    }

    public static int getIdNumber(){
        return generateId();
    }
}
