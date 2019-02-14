package com.pluralsight.CorePlatform;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Main {

    public static void main(String[] args) {

        // do the create input file method 6 times for 6 files upon which to do the threading examples
        int startNum = 1;
        int endNum = 100;
        String[] inFiles = new String[6];
        String[] outFiles = new String[6];

        for (int j = 1; j < 7; j++) {

            inFiles[j-1] = "file" + Integer.toString(j) +".txt";
            outFiles[j-1] = "file" + Integer.toString(j) +"o.txt";
            createInputFiles(inFiles[j-1], startNum, endNum);
            startNum += 100;
            endNum += 100;
        }

        // for each input file, add up all the numbers in it and write it out to an output file
        // single threaded example
        try {
            for (int i = 0; i < inFiles.length; i++){
                Adder adder = new Adder(inFiles[i],outFiles[i]);
                //System.out.println("adder file input:  " + adder.getInFile() + "  ||  adder file output:  " + adder.getOutFile());
                adder.doAdd();
            }
        }catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }


    }



    // creates a file with 100 integers from starting number to ending number for use in the threading examples
    private static void createInputFiles(String fileName, int startNum, int endNum){

        System.out.print("filename:  " + fileName + " || ");
        System.out.println("starting number:  " + startNum + " || ending number:  " + endNum);

        try (Writer writer = Helper.openWriter(fileName)) {
            for (int i = startNum; i < endNum+1; i++) {
                //System.out.println(i);
                writer.write(Integer.toString(i)+"\n");
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }

    }





}
