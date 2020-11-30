package com.university;

import com.university.units.Rectorate.*;
import com.university.units.Rectorate;
import org.junit.Assert;
import org.junit.Test;


public class RectorateTest {

    @Test
    public void ToString_RectorInformation_CorrectString(){
        Rectorate.Rector rector = new Rectorate.Rector("RectorTest");
        String expected = "Rector name: RectorTest";
        System.out.println(rector);
        Assert.assertEquals(rector.toString(), expected);
    }
}
