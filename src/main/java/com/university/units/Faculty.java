package com.university.units;

import com.university.NoUnitUniversityException;

import java.util.Collection;
import java.util.Iterator;

public class Faculty extends Unit{
     private String facultyName;
     private int onlyFacultyEmployees;
     private Collection<Department> departmentUnits;

     public Faculty(Integer employees, String facultyName, Collection<Department> departmentUnits){
         super(employees);
         onlyFacultyEmployees = employees;
         this.facultyName = facultyName;
         this.departmentUnits = departmentUnits;
    }

    public Faculty(Faculty obj){
         super(obj.getOnlyFacultyEmployees());
         this.onlyFacultyEmployees = obj.getOnlyFacultyEmployees();
         this.facultyName = obj.facultyName;
         this.departmentUnits = obj.departmentUnits;
    }


    public void checkDepartmentUnits() throws NoUnitUniversityException {
         if (this.departmentUnits.size() == 0) {
            throw new NoUnitUniversityException(facultyName + " has no departments");
         }
    }


    @Override
    public void show() {
        System.out.println(facultyName + " faculty: " + this.employees() + " employees (with all departments)" );
        System.out.println(facultyName + " departments:");
        try{
            checkDepartmentUnits();
        }
        catch (NoUnitUniversityException e){
            System.out.println(e.getMessage());
        }
        Iterator<Department> it = departmentUnits.iterator();
        while(it.hasNext()){
            System.out.print("--------- ");
            it.next().show();
        }
    }


    public String getFacultyName() {
        return facultyName;
    }

    public Collection<Department> getDepartmentUnits() {
        return departmentUnits;
    }

    @Override
    public int employees() {
        int totalEmployees = this.getOnlyFacultyEmployees();
        Iterator<Department> it = departmentUnits.iterator();
        while(it.hasNext()){
            totalEmployees += it.next().employees();
        }
        return totalEmployees;
    }



    public int getOnlyFacultyEmployees() {
        return onlyFacultyEmployees;
    }

    public Faculty addDepartment(Department department){
         departmentUnits.add(department);
         return this;
    }

    public void removeUnits(){
         this.departmentUnits.clear();
    }
}
