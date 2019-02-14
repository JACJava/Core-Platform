package com.pluralsight.CorePlatform;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Main {

    public static void main(String[] args) {

	char[] buff = new char[8];
	int length;
	Reader reader = null;

	try {
        reader = new BufferedReader(new FileReader("file1.txt"));
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
}
