package com.pluralsight.CorePlatform;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable {

    public void saySomething() throws IOException {
        throw new IOException("Exception from saySomething");
        //System.out.println("Something");
    }

    @Override
    public void close() throws IOException {
        throw new IOException("Exception from Close");
        //System.out.println("Close");
    }


}
