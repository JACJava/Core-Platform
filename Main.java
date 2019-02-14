package com.pluralsight.CorePlatform;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

 /*
        StringJoiner sj = new StringJoiner(", ");

        //sj.add("alpha");
        //sj.add("theta");
        //sj.add("gamma");

        sj.add("alpha").add("theta").add("gamma");

        String theResult = sj.toString();
        System.out.println("The Result:  " + theResult);

        StringJoiner sj2 = new StringJoiner(", ","{", "}");

        sj2.add("alpha");
        sj2.add("theta");
        sj2.add("gamma");

        String theResult2 = sj2.toString();
        System.out.println("The Result:  " + theResult2);

        StringJoiner sj3 = new StringJoiner("], [","[", "]");

        sj3.add("alpha");
        sj3.add("theta");
        sj3.add("gamma");

        String theResult3 = sj3.toString();
        System.out.println("The Result:  " + theResult3);

        //20180820 handling a single value

        StringJoiner sj4 = new StringJoiner(",");

        sj4.add("alpha");

        String theResult4 = sj4.toString();
        System.out.println("The Result:  " + theResult4);

        StringJoiner sj5 = new StringJoiner(", ", "{", "}");

        sj5.add("alpha");

        String theResult5 = sj5.toString();
        System.out.println("The Result:  " + theResult5);

        StringJoiner sj6 = new StringJoiner(",");

        String theResult6 = sj6.toString();
        System.out.println("The Result:  " + theResult6);

        StringJoiner sj7 = new StringJoiner(", ", "{", "}");

        String theResult7 = sj7.toString();
        System.out.println("The Result:  " + theResult7);

        StringJoiner sj8 = new StringJoiner(", ");

        sj8.setEmptyValue("EMPTY");

        String theResult8 = sj8.toString();
        System.out.println("The Result:  " + theResult8);

        StringJoiner sj9 = new StringJoiner(", ", "{", "}");

        sj9.setEmptyValue("EMPTY");

        String theResult9 = sj9.toString();
        System.out.println("The Result:  " + theResult9);

        StringJoiner sj10 = new StringJoiner(", ");

        sj10.setEmptyValue("EMPTY");
        sj10.add(""); // empty is not empty anymore -- once add is called

        String theResult10 = sj10.toString();
        System.out.println("The Result:  " + theResult10);

        // constructing strings with formatting

        int david = 13, dawson = 11, dillon = 4, gordon = 2;

        // desired outpu:  "My nephews are 13, 11, 4, and 2 years old"

        String s1 = "My nephews are " + david + ", " + dawson + ", " + dillon +", " + "and " + gordon + " years old.";
        System.out.println(s1);

        String s2 = String.format("My nephews are %d, %d, %d, and %d years old.", david, dawson, dillon, gordon);
        System.out.println(s2);

        // find out average age difference
        double avgDiff = ((david - dawson) + (dawson - dillon) + (dillon - gordon)) / 3.0d;

        String s3 = "The average age between each is " + avgDiff + " years.";
        System.out.println(s3);

        String s4 = String.format("The average age between each is %.1f years", avgDiff);
        System.out.println(s4);

        //format flags

        String s5 = String.format("%d", 32);
        System.out.println(s5);
        String s6 = String.format("%o", 32);
        System.out.println(s6);
        String s7 = String.format("%x", 32);
        System.out.println(s7);
        String s8 = String.format("%#o", 32);
        System.out.println(s8);
        String s9 = String.format("%#x", 32);
        System.out.println(s9);
        String s10 = String.format("%#X", 32);
        System.out.println(s10);

        String s11 = String.format("W:%d X:%d", 5, 235);
        System.out.println(s11);

        String s12 = String.format("W:%d X:%d", 481, 12);
        System.out.println(s12);

        String s13 = String.format("W:%4d X:%4d", 5, 235);
        System.out.println(s13);
        String s14 = String.format("W:%4d X:%4d", 481, 12);
        System.out.println(s14);

        String s15 = String.format("W:%04d X:%04d", 5, 235);
        System.out.println(s15);
        String s16 = String.format("W:%04d X:%04d", 481, 12);
        System.out.println(s16);

        String s17 = String.format("W:%-4d X:%-4d", 5, 235);
        System.out.println(s17);
        String s18 = String.format("W:%-4d X:%-4d", 481, 12);
        System.out.println(s18);

        String s19 = String.format("%d", 1234567);
        System.out.println(s19);
        String s20 = String.format("%,d", 1234567);
        System.out.println(s20);
        String s21 = String.format("%,.2f", 1234567.0);
        System.out.println(s21);

        String s22 = String.format("%d", 123);
        System.out.println(s22);
        String s23 = String.format("%d", -456);
        System.out.println(s23);

        String s24 = String.format("% d", 123);
        System.out.println(s24);
        String s25 = String.format("% d", -456);
        System.out.println(s25);

        String s26 = String.format("%+d", 123);
        System.out.println(s26);
        String s27 = String.format("%+d", -456);
        System.out.println(s27);

        String s28 = String.format("%(d", 123);
        System.out.println(s28);
        String s29 = String.format("%(d", -456);
        System.out.println(s29);

        String s30 = String.format("% (d", 123);
        System.out.println(s30);
        String s31 = String.format("% (d", -456);
        System.out.println(s31);

        String s32 = String.format("%d %d %d", 100, 200, 300);
        System.out.println(s32);

        String s33 = String.format("%3$d %2$d %1$d", 100, 200, 300);
        System.out.println(s33);

        //String s34 = String.format("%$2d %<04d %$1d", 100, 200, 300);
        //System.out.println(s34); did not work, maybe difference with java versions

        doWrite (david, dawson, dillon, gordon, avgDiff);

    */

        String s35 = "apple, apple and orange, please";
        System.out.println(s35);

        String s36 = s35.replaceAll("ple", "ricot");
        System.out.println(s36);

        String s37 = s35.replaceAll("ple\\b", "ricot");
        System.out.println(s37);

        String[] parts = s35.split ("\\b");

        for (int i = 0; i < parts.length; i++)
            System.out.println(parts[i]);

        for (String thePart:parts)
            if(thePart.matches("\\w+"))
                System.out.println(thePart);

        //dedicated regular expressions...don't really get it...
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s35);

        while(matcher.find())
            System.out.println(matcher.group());




    }

    private static void doWrite(int david, int dawson, int dillon, int gordon, double avgDiff) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("myFile.txt"));

        try(Formatter f = new Formatter(writer)){
            f.format("My nephews are %d, %d, %d, and %d years old.  ", david, dawson, dillon, gordon);
            f.format("The average age between each is %.1f years",avgDiff);

        }


    }




}
