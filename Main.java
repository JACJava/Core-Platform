package com.pluralsight.CorePlatform;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
/*
        ArrayList list = new ArrayList(); //array list of objects

        list.add("Foo");
        list.add("Bar");

        System.out.println("Elements of List:  " + list.size());

        for(Object o:list)
            System.out.println(o.toString());

        String s = (String)list.get(0);
        System.out.println(s);

        ArrayList<String> list0 = new ArrayList<>();

        list0.add("Foo0");
        list0.add("Bar0");

        System.out.println("Elements of List0:  " + list0.size());

        for(String o:list0)
            System.out.println(o);

        String s1 = list0.get(0);
        System.out.println(s1);

        ArrayList<String> list1 = new ArrayList<>();

        list1.add("Foo1");
        list1.add("Bar1");

        LinkedList<String> list2 = new LinkedList<>();

        list2.add("Baz2");
        list2.add("Boo2");

        System.out.println("List1 Contents");
        for(String o:list1)
            System.out.println(o);

        System.out.println("List2 Contents");
        for(String o:list2)
            System.out.println(o);

        list1.addAll(list2); //does not affect list2

        System.out.println("After addAll List1 Contents");
        for(String o:list1)
            System.out.println(o);

        MyClass julie = new MyClass("Julie", "ABCDEFG");
        System.out.println("Label is:  " + julie.getLabel());
        System.out.println("Value is:  " + julie.getValue());

        ArrayList<MyClass> list3 = new ArrayList<>();

        MyClass v1 = new MyClass("v1", "abc");
        System.out.println("Label is:  " + v1.getLabel());
        System.out.println("Value is:  " + v1.getValue());

        MyClass v2 = new MyClass("v2", "abc");
        System.out.println("Label is:  " + v2.getLabel());
        System.out.println("Value is:  " + v2.getValue());

        MyClass v3 = new MyClass("v3", "abc");
        System.out.println("Label is:  " + v3.getLabel());
        System.out.println("Value is:  " + v3.getValue());

        // add those three objects to the collection
        list3.add(v1);
        list3.add(v2);
        list3.add(v3);

        for(Object o:list3)
            System.out.println(o.toString()); //override of the tostring method

        list3.remove(v3);
        //you may think that this removes v3 -- but not doing a reference equals, doing a value equals
        //so will walk thru and the first member it finds that matches or returns back
        //an equals of true will be removed, so it removes v1...
        // all same members have the same value
        // this is nuts, why would you do this?

        for(MyClass m:list3)
            System.out.println(m.getLabel()); //different way of printing than above!!

        // lambda java 8 collection features
        ArrayList<MyClass> list4 = new ArrayList<>();

        MyClass v12 = new MyClass("v12", "abc");
        System.out.println("Label is:  " + v12.getLabel());
        System.out.println("Value is:  " + v12.getValue());

        MyClass v22 = new MyClass("v22", "abc");
        System.out.println("Label is:  " + v22.getLabel());
        System.out.println("Value is:  " + v22.getValue());

        MyClass v32 = new MyClass("v32", "abc");
        System.out.println("Label is:  " + v32.getLabel());
        System.out.println("Value is:  " + v32.getValue());

        // add those three objects to the collection
        list4.add(v12);
        list4.add(v22);
        list4.add(v32);

        for(MyClass m:list4)
            System.out.println("Label:  " + m.getLabel()+" Value:  " + m.getValue()); //different way of printing than above!!

        //or...could do a forEach "lambda" expression -- blocks of code against collections
        list4.forEach(m4 -> System.out.println("Label:  " + m4.getLabel()+" Value:  " + m4.getValue()));

        // more...
        ArrayList<MyClass> list5 = new ArrayList<>();

        MyClass v15 = new MyClass("v15", "abc");
        System.out.println("Label is:  " + v15.getLabel());
        System.out.println("Value is:  " + v15.getValue());

        MyClass v25 = new MyClass("v25", "xyz");
        System.out.println("Label is:  " + v25.getLabel());
        System.out.println("Value is:  " + v25.getValue());

        MyClass v35 = new MyClass("v35", "abc");
        System.out.println("Label is:  " + v35.getLabel());
        System.out.println("Value is:  " + v35.getValue());

        // add those three objects to the collection
        list5.add(v15);
        list5.add(v25);
        list5.add(v35);

        // remove each one that has a value of "abc"
        list5.removeIf(m5 -> m5.getValue().equals("abc"));

        list5.forEach(m5 -> System.out.println("Label:  " + m5.getLabel()+" Value:  " + m5.getValue()));




        // converting between collections 20180824
        System.out.println("*** Converting Between Collections 20180824 ***");
        ArrayList<MyClass> list6 = new ArrayList<>();

        list6.add(new MyClass("v16", "abc"));
        list6.add(new MyClass("v26", "xyz"));
        list6.add(new MyClass("v36", "abc"));

        list6.forEach(m6 -> System.out.println("Label:  " + m6.getLabel()+" Value:  " + m6.getValue()));

        Object[] objArray = list6.toArray(); //get back an array of objects with each member being the three myclass intances

        for(Object o:objArray)
            System.out.println(o.toString()); //override of the tostring method

        //pass in typed array, create an array with zero members, just used to indicate type
        // toarray will create a new array of myclass members
        // a1 is a newly created array containing references to the 3 MyClass instances that
        // were inside of the collection
        MyClass[] a1 = list6.toArray(new MyClass[0]);
        for(Object o:a1)
            System.out.println(o.toString());

        MyClass[] a2 = new MyClass[3];
        MyClass[] a3 = list6.toArray(a2);

        if(a2 == a3)
            System.out.println("a2 and a3 reference the same array because it had room");

        MyClass[] myArray= {
                new MyClass("val17", "abc"),
                new MyClass ("val27", "xyz"),
                new MyClass ("val37", "abc")

        };

        Collection<MyClass> list7 = Arrays.asList(myArray);

        list7.forEach(m7 -> System.out.println("Label:  " + m7.getLabel()+" Value:  " + m7.getValue()));


        // Sorting 20180824
        System.out.println("*** Sorting 20180824 -- Sort by Value ***");

        TreeSet<MyClassSort> tree7 = new TreeSet<>(); //treeset maintains sorting and implements comparable interface

        tree7.add(new MyClassSort("2222", "ghi"));
        tree7.add(new MyClassSort("3333", "abc"));
        tree7.add(new MyClassSort("1111", "def"));

        tree7.forEach(m7 -> System.out.println(m7));

        //for(Object o:tree7)
        //    System.out.println(o.toString());

        //alternate sort
        System.out.println("*** Alternate Sort with Comparator 20180824 -- Sort by Label ***");

        TreeSet<MyClass> tree8 = new TreeSet<>(new MyComparator()); //treeset maintains sorting and implements comparable interface

        tree8.add(new MyClass("2222", "ghi"));
        tree8.add(new MyClass("3333", "abc"));
        tree8.add(new MyClass("1111", "def"));

        tree8.forEach(m8 -> System.out.println(m8));

*/

        // Map Collections 20180824
        System.out.println("*** Map Collections 20180824 ***");

        Map<String, String> map = new HashMap<>();

        map.put("2222", "ghi");
        map.put("3333", "abc");
        map.put("1111", "def");

        String s1 = map.get("3333"); //s1 has "abc"
        System.out.println(s1);
        String s2 = map.get("9999"); //s2 has null
        System.out.println(s2);
        String s3 = map.getOrDefault("9999", "xyz"); //s2 has null
        System.out.println(s3);

        map.forEach((k, v) -> System.out.println(k + " | " + v));

        map.replaceAll((k , v) -> v.toUpperCase());

        map.forEach((k, v) -> System.out.println(k + " | " + v));

        System.out.println("*** Map Collections -- Sorted Maps 20180824 ***");

        SortedMap<String, String> map1 = new TreeMap<>();
        map1.put("2222", "ghi");
        map1.put("3333", "abc");
        map1.put("1111", "def");
        map1.put("6666", "xyz");
        map1.put("4444", "mno");
        map1.put("5555", "pqr");

        map1.forEach((k, v) -> System.out.println(k + " | " + v)); // sorted by key!


        System.out.println("*** Map Collections -- Sorted Maps other values 20180824 ***");

        SortedMap<String, String> map2 = new TreeMap<>();
        map2.put("2222", "ghi");
        map2.put("3333", "abc");
        map2.put("1111", "def");
        map2.put("6666", "xyz");
        map2.put("4444", "mno");
        map2.put("5555", "pqr");

        map2.forEach((k, v) -> System.out.println(k + " | " + v)); // sorted by key!

        SortedMap<String, String> hMap = map2.headMap("3333");

        System.out.println("*** Map Collections -- After HeadMap 20180824 ***");
        hMap.forEach((k, v) -> System.out.println(k + " | " + v));

        SortedMap<String, String> tMap = map2.tailMap("3333");

        System.out.println("*** Map Collections -- After TailMap 20180824 ***");
        tMap.forEach((k, v) -> System.out.println(k + " | " + v));





    }
}
