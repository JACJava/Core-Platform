package com.pluralsight.CorePlatform;

public class MyClass {

    private String label, value;

    //constructor
    public MyClass(String label, String value){
        this.label = label;
        this.value = value;
    }

    //getters and setters
    public String getLabel() {return label;}
    public void setLabel(String label) {this.label = label;}

    public String getValue() {return value;}
    public void setValue(String value) {this.value = value;}

    //Override the equals method
    @Override
        public boolean equals (Object o){ //override the equals method so we return the value not the reference
        MyClass other = (MyClass) o;
        return value.equalsIgnoreCase(other.value);  //checking the VALUES fields match, not the label
    }

    //Override the tostring method to print out the value rather than the reference
    @Override
        public String toString(){
            return label + " | " + value;
        }




}
