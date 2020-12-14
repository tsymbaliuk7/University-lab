package com.university;

import com.university.Bank;
import com.university.NoUnitUniversityException;
import com.university.University;
import com.university.units.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UniversityTest {

    Bank bank;
    University university;

    @Before
    public void init(){
        bank = new Bank("PrivateBank");
        university = new University(new ArrayList<>(), "Kyiv Polytechnic Institute",
                PropertyType.STATE_UNIVERSITY, 57, bank)
                .addUniversityUnit(new Rectorate(36, "Mykhailo Zghurovsky"))
                .addUniversityUnit(new Library(123, 10000));
        Faculty tef = new Faculty(100, "Heat Power Engineer", new ArrayList<>());
        tef.addDepartment(new Department(45, "APEPS DEPARTMENT OF IGOR SIKORSKY KPI"))
                .addDepartment(new Department(37, "ATEP DEPARTMENT OF IGOR SIKORSKY KPI"));
        university.addUniversityUnit(tef);
        Faculty tefCopy = new Faculty(tef);
        university.addUniversityUnit(tefCopy);


    }

    @Test
    public void GetTotalUnitsEmployees_UniversityObject_TotalEmployeesSum(){
        int expected = 523;
        int result = university.getTotalUnitsEmployees();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void GetSpecificUnits_FindLibrary_RightNumberOfUnits(){
        int expected = 1;
        List<Unit> list = university.getSpecificUnits(unit -> unit instanceof Library);
        Assert.assertEquals(expected, list.size());
        Assert.assertEquals(123, list.get(0).employees());
    }

    @Test
    public void GetSpecificUnits_FindByRightEmployeesNum_RightNumberOfUnits(){
        int expected = 2;
        List<Unit> list = university.getSpecificUnits(unit -> unit.employees() == 182);
        Assert.assertEquals(expected, list.size());
    }


    @Test
    public void GetAvgUnitsEmployees_UniversityObject_AverageEmployeesNum(){
        double expected = 130.75;
        double result = university.getAvgUnitsEmployees();
        Assert.assertEquals(expected, result, 0.0);
    }

    @Test
    public void GetFacultyList_UnitListWithTwoFaculties_CorrectNumberOfFaculties(){
        int expected = 2;
        List<Faculty> result = university.getFacultyList();
        Assert.assertEquals(expected, result.size());

    }

    @Test
    public void GetAllDepartments_UniversityObject_ListOfDepartmentsFromEachFaculty(){
        int expected = 4;
        List<Department> departments = university.getAllDepartments();
        Assert.assertEquals(expected, departments.size());
    }

    @Test
    public void GetSmallestDepartment_AllDepartmentsList_DepartmentWithSmallestEmployeesNumber(){
        int expected = 37;
        Department department = null;
        try {
            department = university.getSmallestDepartment();
        } catch (NoUnitUniversityException exception) {
            exception.printStackTrace();
        }
        Assert.assertEquals(expected, department.employees());
    }

    @Test
    public void GetDistributedUnits_ListOfUniversityUnits_MapOfThisUnitsDistributedIntoTwoParts(){
        Map<String, List<Unit>> stringListMap = university.getDistributedUnits(unit -> unit.employees() > 100);
        System.out.println(stringListMap);
        Assert.assertEquals(stringListMap.size(), 2);
    }

}