package com.pluralsight.CorePlatform;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class Adder implements Callable<Integer> {

    // accepts input file and output file
    private String inFile;

    // constructor that sets initial state of the object
    public Adder(String inFile) {
        this.inFile = inFile; //right hand is the parameter, left hand is the field
    }

    //getters and setters so outside things can use
    public String getInFile(){ return inFile; }
    public void setInFile(String inFile) {
        this.inFile = inFile; //right hand is the parameter, left hand is the field}
    }

    //implements the threading with run()
    public Integer call() throws IOException {
            return doAdd();
    }


    // reads each line of the input file and adds the numbers up
    public int doAdd() throws IOException {
        int total = 0;
        String line = null;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while ((line = reader.readLine()) != null)
                total += Integer.parseInt(line);
        }catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }

        return total;
    }


}
