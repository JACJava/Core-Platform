package com.pluralsight.CorePlatform;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        // managing persistant key/values
        System.out.println();
        System.out.println("*** Managing Persistant Key/Values ***");
        System.out.println();
        Properties props = new Properties();

        props.setProperty("displayname", "Julie Carlson");

        String name = props.getProperty("displayname");
        System.out.println(name);

        String acctnum = props.getProperty("accountNumber");
        System.out.println(acctnum);

        String nextPosition = props.getProperty("position", "1"); //default value
        System.out.println(nextPosition);

        //property values persist
        //persisted as simple text, use store and load
        // store and load property values
        System.out.println();
        System.out.println("*** Store and Load Property Values ***");
        System.out.println();
        Properties props1 = new Properties();

        props1.setProperty("displayName", "Julie Carlson");
        String name1 = props1.getProperty("displayName");
        System.out.println("name1:  " + name1);

        props1.setProperty("accountNumber", "123-45-6789");
        String num1 = props1.getProperty("accountNumber");
        System.out.println("num1:  " + num1);

        try(Writer writer = Files.newBufferedWriter(Paths.get("xyz.properties"))) {
          props1.store(writer, "My comment");
        } catch(Exception e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }

        System.out.println();
        System.out.println("*** Load Property Values from Simple Text ***");
        System.out.println();

        Properties props2 = new Properties();
        try(Reader reader = Files.newBufferedReader(Paths.get("myapp.properties"))) {
            props2.load(reader);
        }catch(Exception e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }

        String val1 = props2.getProperty("val1");
        System.out.println("val1:  " + val1);

        String val2 = props2.getProperty("val2");
        System.out.println("val2:  " + val2);

        String val3 = props2.getProperty("val3");
        System.out.println("val3:  " + val3);

        String val4 = props2.getProperty("val4");
        System.out.println("val4:  " + val4);

        // Properties persisted as XML
        System.out.println();
        System.out.println("*** Properties Persisted as XML ***");
        System.out.println();

        Properties props3 = new Properties();

        props3.setProperty("displayName", "Julie Carlson");
        props3.setProperty("accountNumber", "333-33-3333");

        try(OutputStream out = Files.newOutputStream(Paths.get("props.xml"))) {
            props3.storeToXML(out, "My Comment Here for Properties Persisted as XML");
        }catch(Exception e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }


        Properties props4 = new Properties();

        try(InputStream in = Files.newInputStream(Paths.get("props.xml"))) {
            props4.loadFromXML(in);
        }catch(Exception e) {
            System.out.println(e.getClass().getSimpleName() + " -- " + e.getMessage());
        }

        String valdn = props4.getProperty("displayName");
        System.out.println("valdn:  " + valdn);

        String valan = props4.getProperty("accountNumber");
        System.out.println("valan:  " + valan);



        // Providing Default Properties
        System.out.println();
        System.out.println("*** Providing Default Properties ***");
        System.out.println();

        Properties defaults = new Properties();
        defaults.setProperty("position", "1");

        Properties props5 = new Properties(defaults); //pass in defaults to constructor

        String nextPos = props5.getProperty("position");
        System.out.println("nextPos:  " + nextPos);

        int iPos = Integer.parseInt(nextPos);

        System.out.println("iPos:  " + iPos);

        props5.setProperty("position", Integer.toString(++iPos));

        nextPos = props5.getProperty("position");
        System.out.println("nextPos:  " + nextPos);

        // Include Default Properties in Package
        System.out.println();
        System.out.println("*** Include Default Properties in Package ***");
        System.out.println();









    }
}
