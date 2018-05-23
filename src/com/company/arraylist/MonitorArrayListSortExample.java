package com.company.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MonitorArrayListSortExample {

    public static void main(String[] args) {

        //IDE - Integration Development Environment
        //Eclipse, Intellij IDEA, Netbeans


        //Arrays.sort();
        String [] strings = new String[10];
        strings[0] = "a";

        //Collections.sort();
        ArrayList<Integer> stringArrayList = new ArrayList<>();


        ArrayList<Monitor> monitors = new ArrayList<>();
        Monitor m1 = new Monitor("Samsung", 24, 2010);
        Monitor m2 = new Monitor( "LG", 24,2017);
        Monitor m3 = new Monitor( "Dell", 24,2018);
        Monitor m4 = new Monitor( "Dell", 21,2015);
        Monitor m5 = new Monitor( "Dell", 21,2016);

        monitors.add(m1);
        monitors.add(m2);
        monitors.add(m3);
        monitors.add(m4);
        monitors.add(m5);

        //Arrays won't work with ArrayList
        //Arrays.sort(m1);

        System.out.println("Monitors after default sorting (Comparable only)");
        Collections.sort(monitors);

        System.out.println(monitors);

        System.out.println();
        System.out.println("Monitors after year sorting");
        Collections.sort(monitors, new MonitorComparator());
        System.out.println(monitors);

    }
}

class Monitor implements Comparable<Monitor> {

    private String brandName;
    private int inch;
    private int year;

    public Monitor(String brandName, int inch, int year) {
        this.brandName = brandName;
        this.inch = inch;
        this.year = year;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getInch() {
        return inch;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return this.brandName + " - " + this.inch + "'' - " + this.year;
    }

    //Example:
    //1st java sorting iteration ->
    // this = m1
    // other = m2

    //2nd  java sorting iteration ->
    // this = m2
    // other = m3

    //Our purpose
    //this = m? vs other = m?


    @Override
    public int compareTo(Monitor other) {
//        return this.brandName.compareTo(other.getBrandName());
        int comparisonResult = this.brandName.toLowerCase().compareTo(other.getBrandName().toLowerCase());

        if (comparisonResult == 0) {
            comparisonResult = this.inch - other.getInch();
        }

        if (comparisonResult == 0) {
            comparisonResult = other.getYear()- this.year;
        }
        return comparisonResult;
    }
}

class MonitorComparator implements Comparator<Monitor> {

    @Override
    public int compare(Monitor o1, Monitor o2) {
        return o2.getYear() - o1.getYear();
    }
}