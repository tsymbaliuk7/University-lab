package com.university;

import com.university.units.Department;
import com.university.units.Faculty;
import com.university.units.Library;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FacultyTest {

    Faculty faculty;

    @Before
    public void init(){

        faculty = new Faculty(100, "Heat Power Engineer", new ArrayList<>());


    }

    @Test
    public void GetMaxEmployeesDepartment_DifferentDepartments_DepartmentValue(){
        faculty.addDepartment(new Department(45, "APEPS DEPARTMENT OF IGOR SIKORSKY KPI"))
                .addDepartment(new Department(37, "ATEP DEPARTMENT OF IGOR SIKORSKY KPI"));
        Department result = null;
        try {
             result = faculty.getMaxEmployeesDepartment();
        } catch (NoUnitUniversityException exception) {
            exception.printStackTrace();
        }
        Department expected = new Department(45, "APEPS DEPARTMENT OF IGOR SIKORSKY KPI");
        Assert.assertEquals(result, expected);
    }
}
