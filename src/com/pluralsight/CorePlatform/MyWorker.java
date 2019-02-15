package com.pluralsight.CorePlatform;


public class MyWorker {

    private String doMessage; //'w' -> withdrawal, 'd' -> deposit

    // constructor that sets initial state of the object
    public MyWorker() {
    }

    @SuppressWarnings("deprecation")
    public void doSomerWork(){
        Doer d = new Doer("This is the Doer Message for Doer d");
        d.doItThisWay();
    }

    @SuppressWarnings("deprecation")
    public void doDoubleWork(){
        Doer d1 = new Doer("This is the Doer Message for Doer d1");
        Doer d2 = new Doer("This is the Doer Message for Doer d2");
        d1.doItThisWay();
        d2.doItThisWay();
    }




}
