package com.pluralsight.CorePlatform;

import java.util.Comparator;

public class MyComparator implements Comparator<MyClass> {

    // sort on the LABEL, not the value
    public int compare(MyClass x, MyClass y){
        return x.getLabel().compareToIgnoreCase(y.getLabel());
    }

}
