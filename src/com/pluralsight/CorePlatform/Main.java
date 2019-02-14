package com.pluralsight.CorePlatform;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

public class Main {

    public static void main(String[] args) {

        //doTryCatchFinally();
        //doTryWithResources();
        doTryWithResourcesMulti();
        doCloseThing();
    }

    public static void doTryCatchFinally() {

        char[] buff = new char[8];
        int length;
        Reader reader = null;

        try {
            //reader = new BufferedReader(new FileReader("file1.txt"));  //reader w/o helper
            reader = Helper.openReader("file1.txt");
            while ((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength:  " + length);
                for (int i = 0; i < length; i++)
                    System.out.print(buff[i]);
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch(IOException e2) {
                System.out.println(e2.getClass().getSimpleName() + " -- " + e2.getMessage());
            }
        }
    }

    public static void doTryWithResources() {

	    char[] buff = new char[8];
	    int length;

	    try (Reader reader = Helper.openReader("file1.txt")) { //creating reader w/in try
            while ((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength:  " + length);
                for (int i = 0; i < length; i++)
                    System.out.print(buff[i]);
                }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }
    }

    public static void doTryWithResourcesMulti() {

        char[] buff = new char[8];
        int length;

        try (Reader reader = Helper.openReader("file1.txt");
             Writer writer = Helper.openWriter("file2.txt")) { //creating reader w/in try
            while ((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength:  " + length);
                writer.write(buff, 0, length);
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }
    }

    public static void doCloseThing() {

        try (MyAutoCloseable ac = new MyAutoCloseable()) {
            ac.saySomething();
        } catch (IOException e){//catch block handles the call to close, even tho we never explicity call it
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
            for(Throwable t:e.getSuppressed())
                System.out.println("Suppressed:  " + t.getMessage()); //java keeps track of all exceptions
        }
    }


}
