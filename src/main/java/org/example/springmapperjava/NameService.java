package org.example.springmapperjava;

import org.springframework.stereotype.Service;


@Service
public class NameService {

    public String getName(Gender gender, String fname, String lname) {
        String prefix = "Mrs";
        if (gender == Gender.MALE) { prefix = "Mr";}
        return prefix + "." + capitalize(fname) + " " + capitalize(lname);
    }
    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
