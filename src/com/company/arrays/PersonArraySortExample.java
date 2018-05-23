package com.company.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class PersonArraySortExample {

    public static void main(String[] args) {
        //Comparable -> when WE are writing the class or can modify it, like Person
        //Comparator -> when WE ARE NOT the authors of the class and cannot modify it, like String, Double, etc.

        int i = 1;
//        Person p = new Person(i);
//        Person p2 = new Person("abc");

        Person p1 = new Person("Robert");
        Person p2 = new Person("Charlie");
        Person p3 = new Person("Charlotta");

        Person [] persons = new Person[3];
        persons[0] = p1;
        persons[1] = p2;
        persons[2] = p3;




        System.out.println("Printing persons [DEFAULT]");
        Arrays.sort(persons);
        System.out.println(Arrays.toString(persons));

        System.out.println();
        System.out.println("Printing persons [REVERSE]");

        Arrays.sort(persons, new PersonComparator());
        System.out.println(Arrays.toString(persons));

    }
}
//a..z -> we implement default sorting with Comparable
class Person implements Comparable<Person>  {

    private String name;

//    public Person(int i) {
//    }
//
//    public Person(String name) {
//    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }


    @Override
    public String toString() {
        return "Name: " + this.name;
    }
}

//z..a -> non standard sorting implementation
class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
