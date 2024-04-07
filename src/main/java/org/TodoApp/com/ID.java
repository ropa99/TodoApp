package org.TodoApp.com;

public class ID {
    private static int theNumber;

    private ID(){ theNumber++;}
    //This might keep Mr.Murphy away
    private static ID createID(){
        return new ID();

    }

    public static ID getInstance(){return createID();
    }

    public  int getIdNumber(){

        return theNumber;
    }
}
