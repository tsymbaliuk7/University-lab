package com.university.units;

import com.university.Showable;
import com.university.UniversityUnit;

public class Unit extends UniversityUnit implements Showable {
    protected int employeesNum;

    Unit(Integer employeesNum){
        this.employeesNum = employeesNum;
    }

    public void setEmployeesNum(int employeesNum) {
        this.employeesNum = employeesNum;
    }

    public double countUnitSalary(CountingHouse countingHouse,double avgSalaryForUnit){
        return countingHouse.countUnitSalary(this.employees(), avgSalaryForUnit);
    }

    @Override
    public int employees(){
        return employeesNum;
    }

    @Override
    public void show() {}

}
