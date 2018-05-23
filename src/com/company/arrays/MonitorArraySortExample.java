package com.company.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MonitorArraySortExample {

    public static void main(String[] args) {
        Monitor m1 = new Monitor(24, "Samsung", 2010);
        Monitor m2 = new Monitor(24, "LG", 2017);
        Monitor m3 = new Monitor(24, "Dell", 2018);
        Monitor m4 = new Monitor(21, "Dell", 2015);
        Monitor m5 = new Monitor(21, "Dell", 2016);

        Monitor [] monitors = new Monitor[] {m1, m2, m3, m4, m5};

        System.out.println("There are " + monitors.length + " monitors");
        System.out.println();
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(monitors));

        System.out.println();
        System.out.println("After sorting");
        Arrays.sort(monitors);
        System.out.println(Arrays.toString(monitors));


        System.out.println();
        System.out.println("Comparing by year");
        Arrays.sort(monitors, new MonitorYearComparator());
        System.out.println(Arrays.toString(monitors));

    }
}

class Monitor implements Comparable<Monitor> {

    private int inch;
    private String brandName;
    private int year;

    public Monitor(int inch, String brandName, int year) {
        this.inch = inch;
        this.brandName = brandName;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getInch() {
        return inch;
    }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public String toString() {
        return this.brandName + " - " + this.inch + "'' - " + this.year;
    }

    //positive - this is larger
    //zero - they are equal
    //negative - other is larger
    @Override
    public int compareTo(Monitor other) {
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

class MonitorYearComparator implements Comparator<Monitor> {

    @Override
    public int compare(Monitor o1, Monitor o2) {
        return o2.getYear() - o1.getYear();
    }
}