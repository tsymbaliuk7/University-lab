package com.university.units;

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
}
