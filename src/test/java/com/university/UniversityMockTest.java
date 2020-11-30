package com.university;

import com.university.Bank;
import com.university.NoUnitUniversityException;
import com.university.University;
import com.university.units.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class UniversityMockTest {


    @Test
    public void GetTotalEmployees_ListOfUnits_TotalEmployeesNumber() {
        Rectorate rectorate = Mockito.mock(Rectorate.class);
        Library library = Mockito.mock(Library.class);
        when(rectorate.employees()).thenReturn(150);
        when(library.employees()).thenReturn(100);
        University universityTest = new University(new ArrayList<>(), "Kyiv Polytechnic Institute",
                PropertyType.STATE_UNIVERSITY, 60, new Bank("PrivateBank"));
        universityTest.addUniversityUnit(rectorate).addUniversityUnit(library);
        int expected = 310;
        Assert.assertEquals(expected, universityTest.getTotalEmployees());
        verify(rectorate).employees();
        verify(library).employees();
    }

}