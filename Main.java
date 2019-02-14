package com.pluralsight.CorePlatform;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    // in practice  -- we use a different technique
    // start out with static reference oustide of main
    // define at class level in public class Main, so can be used anywhere
    static Logger logger =
        LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

    static Logger logger2 =
        Logger.getLogger("com.pluralsight");

    static Logger pkgLogger =
            Logger.getLogger("com.ps.training");

    static Logger logger3 =
            Logger.getLogger("com.ps.training.Main");



    public static void main(String[] args) throws IOException {

        // Making Log Calls 20180829
        // lm reference and logger are scoped within Main, which means we have to repeat this process
//        System.out.println();
//        System.out.println("*** Making Log Calls ***");
//        System.out.println();
//
//        LogManager lm = LogManager.getLogManager();
//
//        Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);
//
//        logger.log(Level.INFO, "My first log message");
//        logger.log(Level.INFO, "Another log message");


        // in practice  -- we use a different technique
        // start out with static reference oustice of main
        // define at class level in public class Main, so can be used anywhere
//        System.out.println();
//        System.out.println("*** Making Log Calls with Logger defined in the Main Class ***");
//        System.out.println();
//
//        logger.log(Level.INFO, "My first log message");
//
//        // Log Levels
//        System.out.println();
//        System.out.println("*** Log Levels ***");
//        System.out.println();
//
//        logger.setLevel(Level.INFO); //capture everything 800 and higher (INFO and SEVERE)
//        logger.log(Level.INFO, "My first log message");
//        logger.log(Level.SEVERE, "UH OH!!!!!!");
//        logger.log(Level.INFO, "Just so you know....");
//        logger.log(Level.FINE, "Hey, Developer Gal!");
//        logger.log(Level.FINEST, "You're very special!");
//
//        logger.setLevel(Level.FINE);
//        logger.log(Level.INFO, "My first log message");
//        logger.log(Level.SEVERE, "UH OH!!!!!!");
//        logger.log(Level.INFO, "Just so you know....");
//        logger.log(Level.FINE, "Hey, Developer Gal!");
//        logger.log(Level.FINEST, "You're very special!");

        // Types of Log Methods
//        System.out.println();
//        System.out.println("*** Types of Log Methods ***");
//        System.out.println();

        //logger.severe("Uh Oh!!!"); //level determined by method

        //logger.logp(Level.SEVERE,
                //"com.pluralsight.CorePlatform", "myMethod", "It broke!!");

        //doWork();

        // Paramaterized Message Methods
//        System.out.println();
//        System.out.println("*** Paramaterized Message Methods ***");
//        System.out.println();
//
//        logger.log(Level.INFO,"{0} is my favorite", "Java");
//        logger.log(Level.INFO, "{0} is {1} days from {2}", new Object[]{"Wed", 2, "Fri"});
//
//        doWorkParm("Julie", "Carlson");

//        // Creating/Adding Log Components
//        System.out.println();
//        System.out.println("*** Creating/Adding Log Components ***");
//        System.out.println();
//
//        // each log message prints out twice -- something with the default handler being called
//        //for (Handler handler : logger2.getHandlers()) {logger2.removeHandler(handler);}
//
//        Handler h = new ConsoleHandler();
//        Formatter f = new SimpleFormatter();
//
//        h.setFormatter(f);
//        logger2.addHandler(h);
//
//        logger2.setLevel(Level.INFO);
//        logger2.log(Level.INFO, "We're Logging!!!");
//
//        logger2.log(Level.INFO, "We're Logging again!!!");

        // Built-in Handlers
//        System.out.println();
//        System.out.println("*** Built-in Handlers ***");
//        System.out.println();
//
//        FileHandler h = new FileHandler("%h/myapp_%g.log", 100, 4);
//
//        h.setFormatter(new SimpleFormatter());
//        logger.addHandler(h);
//
//        logger.log(Level.INFO, "My first log message");
//        logger.log(Level.SEVERE, "UH OH!!!!!!");
//        logger.log(Level.INFO, "Just so you know....");
//        logger.log(Level.FINE, "Hey, Developer Gal!");
//        logger.log(Level.FINEST, "You're very special!");


        // Log Configuration File
//        System.out.println();
//        System.out.println("*** Log Configuration File ***");
//        System.out.println();
//
//        Handler h = new ConsoleHandler();
//        h.setLevel(Level.ALL);
//        h.setFormatter(new SimpleFormatter());
//        logger2.addHandler(h);
//        logger2.setLevel(Level.ALL);
//        logger2.log(Level.INFO, "We're Logging!!!");


        // Making the Most of the Log System
        System.out.println();
        System.out.println("*** Making the Most of the Log System ***");
        System.out.println();

        logger3.entering("com.ps.training","Main"); // not logged
        logger3.log(Level.INFO, "We're Logging woo hoo!");
        logger3.exiting("com.ps.training","Main"); // not logged

        //Needs to be run from dos prompt at:
        //c:\users\julie\IdeaProjects\Core Platform Capturing Application Activity\out\production\Core Platform
        //
        // java -Djava.util.logging.config.file=log.properties com.pluralsight.CorePlatform.Main

    }


    public static void doWork(){

        // the following line was not in the tutorial, had to get it from stack overflow
        // while the logger set Level is ALL, the CONSOLE display was set to INFO
        // so the CONSOLE display has to be set to display all log levels
        Logger.getGlobal().getParent().getHandlers()[0].setLevel(Level.FINEST);

        logger.setLevel(Level.ALL);
        logger.entering("com.pluralsight.CorePlatfom", "doWork");
        logger.logp(Level.WARNING,
                "com.pluralsight.CorePlatform", "doWork", "Empty Function");
        logger.exiting("com.pluralsight.CorePlatfom", "doWork");

    }

    public static void doWorkParm(String left, String right){

        // the following line was not in the tutorial, had to get it from stack overflow
        // while the logger set Level is ALL, the CONSOLE display was set to INFO
        // so the CONSOLE display has to be set to display all log levels
        Logger.getGlobal().getParent().getHandlers()[0].setLevel(Level.FINEST);

        logger.setLevel(Level.ALL);
        logger.entering("com.pluralsight.CorePlatfom", "doWorkParm", new Object[]{left, right});
        String result = "<" + left + right + ">";
        logger.exiting("com.pluralsight.CorePlatfom", "doWork", result);

    }



}
