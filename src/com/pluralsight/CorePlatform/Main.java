package com.pluralsight.CorePlatform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {//passing in hello there world

        // command line arguments test
        // run->edit configurations <program arguments>

//        if (args.length < 1)
//            System.out.println("No arguments provided");
//        else {
//            for (String word:args)
//                System.out.println(word);
//        }


        // Arguments
        System.out.println();
        System.out.println("*** Arguments ***");
        System.out.println();

        if(args.length == 0){
            showUsage();
            return;
        }

        String filename = args[0]; //first thing will be the filename
        if(!Files.exists(Paths.get(filename))) {
            System.out.println("\nFile not found:  " + filename);
        }
        else
            showFileLines(filename);


        // system properties -- from java
        System.out.println();
        System.out.println("*** System Properties ***");
        System.out.println();

        String userName = System.getProperty("user.name");
        System.out.println("userName:  " + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("userHome:  " + userHome);

        String osArchitecture = System.getProperty("os.arch");
        System.out.println("osArchitecture:  " + osArchitecture);

        String javaVendor = System.getProperty("java.vendor");
        System.out.println("java.vendor:  " + javaVendor);


        // Environment Variables -- operating system and app specific
        System.out.println();
        System.out.println("*** Environment Variables ***");
        System.out.println();

        String compName = System.getenv("COMPUTERNAME");
        System.out.println("compName:  " + compName);

        String sysRoot = System.getenv("SystemRoot");
        System.out.println("sysRoot:  " + sysRoot);

        String author = System.getenv("COURSE_AUTHOR"); //specific to app, not os
        System.out.println("author:  " + author);


    }

    private static void showFileLines(String filename) {

        System.out.println();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) { //creating reader w/in try
            String line = null;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch(Exception ex) {
            System.out.println(ex.getClass().getSimpleName() + " -- " + ex.getMessage());
        }
    }

    private static void showUsage() {
        System.out.println();
        System.out.println("No filename provided.  Please provide the filename to process on the command line.");
    }





}
