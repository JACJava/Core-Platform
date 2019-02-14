package com.pluralsight.CorePlatform;

public class MyClassSort implements Comparable<MyClassSort>{

    private String labelsort, valuesort;

    //constructor
    public MyClassSort(String labelsort, String valuesort){
        this.labelsort = labelsort;
        this.valuesort = valuesort;
    }

    //getters and setters
    public String getLabelSort() {return labelsort;}
    public void setLabelSort(String labelsort) {this.labelsort = labelsort;}

    public String getValueSort() {return valuesort;}
    public void setValueSort(String valuesort) {this.valuesort = valuesort;}

    //Override the equals method
    @Override
    public boolean equals (Object o){ //override the equals method so we return the value not the reference
        MyClassSort other = (MyClassSort) o;
        return valuesort.equalsIgnoreCase(other.valuesort);  //checking the VALUES fields match, not the label
    }

    public int compareTo(MyClassSort other){
        return valuesort.compareToIgnoreCase(other.valuesort);
    }

    //Override the tostring method to print out the value rather than the reference
    @Override
    public String toString(){
        return labelsort + " | " + valuesort;
    }




}
