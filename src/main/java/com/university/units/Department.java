package com.university.units;

import java.util.Objects;

public class Department extends Unit{

     private  String departmentName;

     public Department(Integer employees, String departmentName){
         super(employees);
         this.departmentName = departmentName;
    }

    @Override
    public void show(){
        System.out.println(departmentName + ":  " + employees() + " employees" );

    }


    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName);
    }
}
