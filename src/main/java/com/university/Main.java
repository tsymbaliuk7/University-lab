package com.university;

import com.university.units.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("PrivateBank");
        University university = new University(new ArrayList<>(), "Kyiv Polytechnic Institute",
                PropertyType.STATE_UNIVERSITY, 57, bank)
                .addUniversityUnit(new Rectorate(201, "Mykhailo Zghurovsky"))
                .addUniversityUnit(new Library(123, 10000));

        Faculty tef = new Faculty(100, "Heat Power Engineer", new ArrayList<>());
        tef.addDepartment(new Department(45, "APEPS DEPARTMENT OF IGOR SIKORSKY KPI"))
                .addDepartment(new Department(37, "ATEP DEPARTMENT OF IGOR SIKORSKY KPI"));
        university.addUniversityUnit(tef);
        university.show();


        Faculty tefCopy = new Faculty(tef);
        System.out.println("Using not overrided equals()");
        System.out.println("tef and tefCopy are equal: " + tef.equals(tefCopy) + "\n");


        University universityCopy = new University(university);
        if (university.equals(universityCopy)){
            System.out.println("These universities are equal");
        }
        else{
            System.out.println("These universities are equal");
        }
        universityCopy.setName("KPI copy");
        if (!university.equals(universityCopy)){
            System.out.println("We changed university name and now they are not equal");
        }
    }
}
