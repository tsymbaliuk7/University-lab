package com.university;

import com.university.NoUnitUniversityException;
import com.university.units.Department;
import com.university.units.Faculty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class FacultyIT {


    @Test
    public void Employees_ListOfDepartments_TotalEmployeesNumber(){
        Faculty facultyTest = new Faculty(120, "Faculty Test", new ArrayList<>());
        Department department = Mockito.mock(Department.class);
        facultyTest.addDepartment(department);
        when(department.employees()).thenReturn(60);
        int expected = 180;
        Assert.assertEquals(expected, facultyTest.employees());
        verify(department).employees();
    }

    @Test
    public void AddDepartment_OneDepartment_TheSameNumber(){
        ArrayList<Department> list = Mockito.spy(new ArrayList<>());
        Faculty facultyTest = new Faculty(120, "Faculty Test", list);
        Department department = new Department(12, "testdepartment");
        facultyTest.addDepartment(department);
        Assert.assertEquals(1, list.size());
        Mockito.verify(list).add(department);

    }

}
