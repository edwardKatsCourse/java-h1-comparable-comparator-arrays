package com.company.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class StringArraySortExample {

    public static void main(String[] args) {
        //Comparator
        //Comparable

        String [] letters = new String[] {"z", "a", "d", "h", "f"};
//        String [] letters = new String[5];

//        for (int i = 0; i < letters.length; i++) {
//            System.out.println(letters[i]);
//        }


//        String alphabet = "abcdef";
//        System.out.println(alphabet);
//        String newAlphabet = alphabet.toUpperCase();
//        System.out.println(newAlphabet);

        System.out.println("Before sorting");
        System.out.println(Arrays.toString(letters));

        System.out.println();
        System.out.println("After sorting");
        Arrays.sort(letters);
        System.out.println(Arrays.toString(letters));

        System.out.println();
        String [] words = new String[] {"zoo", "dale", "country","apples", "apple", "eagle"};
        System.out.println("Words after sorting");
        Arrays.sort(words);

        System.out.println(Arrays.toString(words));

        System.out.println();
        String [] wordLetters = new String[] {"bba", "aab", "cba", "bac"};
        System.out.println("Word letters after sorting");
        Arrays.sort(wordLetters);

        System.out.println(Arrays.toString(wordLetters));

        System.out.println();
        System.out.println("Word letters sorting in descending order");
        Arrays.sort(wordLetters, new StringComparator());
        System.out.println(Arrays.toString(wordLetters));

    }
}

class StringComparator implements Comparator<String> {

    //ascending     0..100 or a..z -> o1.compareWith(o2)
    //descending    100..0 or z..a -> o2.compareWith(o1)
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}