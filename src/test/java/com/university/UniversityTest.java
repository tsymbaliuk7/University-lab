package com.university;

import com.university.Bank;
import com.university.NoUnitUniversityException;
import com.university.University;
import com.university.units.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class UniversityTest {


    @Test
    public void AddUnitTest_ListOfUnits_UnitsNumber() {
        University universityTest = new University(new ArrayList<>(), "Kyiv Polytechnic Institute",
                PropertyType.STATE_UNIVERSITY, 57, new Bank("PrivateBank"))
                .addUniversityUnit(new Rectorate(201, "Mykhailo Zghurovsky"));
        Assert.assertEquals(1, universityTest.getUniversityUnits().size());
    }

    @Test
    public void RemoveUnits_ListOfUnits_EmptyListOfUnits() {
        University universityTest = new University(new ArrayList<>(), "Kyiv Polytechnic Institute",
                PropertyType.STATE_UNIVERSITY, 57, new Bank("PrivateBank"))
                .addUniversityUnit(new Rectorate(201, "Mykhailo Zghurovsky"));
        universityTest.removeUnits();
        Assert.assertEquals(universityTest.getTotalEmployees(), universityTest.getCountingHouse().employees());
        Assert.assertEquals(0, universityTest.getUniversityUnits().size());
    }


    @Test
    public void Equals_OverridedEquals_True() {
        University universityTest = new University(new ArrayList<>(), "Kyiv Polytechnic Institute",
                PropertyType.STATE_UNIVERSITY, 57, new Bank("PrivateBank"))
                .addUniversityUnit(new Rectorate(201, "Mykhailo Zghurovsky"));
        University universityCopy = new University(universityTest);
        Assert.assertEquals(universityTest, universityCopy);
    }

    @Test
    public void CheckUnitsList_NoUniversityUnit_ThrowsNoUnitUniversityException() {
        University universityTest = new University(new ArrayList<>(), "Kyiv Polytechnic Institute",
                PropertyType.STATE_UNIVERSITY, 57, new Bank("PrivateBank"))
                .addUniversityUnit(new Rectorate(201, "Mykhailo Zghurovsky"));
        universityTest.removeUnits();
        try {
            universityTest.checkUnitList();
        } catch (NoUnitUniversityException e) {
            Assert.assertEquals(e.getMessage(), "\"Kyiv Polytechnic Institute\" has no units");
        }
    }
}