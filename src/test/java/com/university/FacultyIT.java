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

}
