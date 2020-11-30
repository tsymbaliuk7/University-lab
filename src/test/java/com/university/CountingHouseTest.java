package com.university;

import com.university.units.CountingHouse;
import com.university.units.Unit;
import com.university.Bank;
import org.junit.Assert;
import org.junit.Test;

public class CountingHouseTest {
    @Test
    public void CountUnitSalary_EmployeesAndAvgSalary_SalaryValue(){
        CountingHouse countingHouse = new CountingHouse(1223, new Bank("test"));
        Assert.assertEquals(3936, countingHouse.countUnitSalary(123, 32), 0.0);
    }
}
