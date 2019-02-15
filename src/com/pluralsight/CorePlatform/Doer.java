package com.pluralsight.CorePlatform;

public class Doer {

    private String doMessage; //'w' -> withdrawal, 'd' -> deposit

    // constructor that sets initial state of the object
    public Doer(String doMessage) {
        this.doMessage = doMessage; //right hand is the parameter, left hand is the field
    }

    public String getDoMessage() {
        return doMessage;
    }

    public void setId(String id) {
        this.doMessage = doMessage;
    }

    @Deprecated
    public void doItThisWay(){
        System.out.println("doMessage:  " + doMessage);
    }

    public void doItThisNewWay(){
        System.out.println("This is the NEW way doMessage:  " + doMessage);
    }

}
