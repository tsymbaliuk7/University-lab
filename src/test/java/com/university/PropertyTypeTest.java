package com.university;

import com.university.units.PropertyType;
import org.junit.Assert;
import org.junit.Test;

public class PropertyTypeTest {

    @Test
    public void ToString_UsingPrivateUniversityPropertyType_CorrectString(){
        PropertyType propertyType = PropertyType.PRIVATE_UNIVERSITY;
        String expected = "private university";
        Assert.assertEquals(propertyType.toString(), expected);
    }

    @Test
    public void ToString_UsingUnknownPropertyType_CorrectString(){
        PropertyType propertyType = PropertyType.UNKNOWN;
        String expected = "unknown";
        Assert.assertEquals(propertyType.toString(), expected);
    }
}
