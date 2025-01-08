package org.example.springmapperjava;


public class NameConverter {

    public static String convert(String lname, String fname) {

        return capitalize(fname) + " " + capitalize(lname);
    }
    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
