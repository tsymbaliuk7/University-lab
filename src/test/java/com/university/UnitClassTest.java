package com.university;

import com.university.Bank;
import com.university.units.CountingHouse;
import com.university.units.Library;
import com.university.units.Unit;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;


public class UnitClassTest {


    @Test
    public void CountUnitSalary_ExistingUnit_SalaryValueForUnit(){
        double avgSalary = 10000;
        int unitEmployees = 123;
        CountingHouse countingHouse = Mockito.mock(CountingHouse.class);
        Unit libraryTest = new Library(unitEmployees, 100000);
        when(countingHouse.countUnitSalary(unitEmployees, avgSalary)).
                thenReturn(unitEmployees * avgSalary);
        Assert.assertEquals(1230000, libraryTest.countUnitSalary(countingHouse, avgSalary), 0.0);
        verify(countingHouse).countUnitSalary(unitEmployees, avgSalary);
    }

}
