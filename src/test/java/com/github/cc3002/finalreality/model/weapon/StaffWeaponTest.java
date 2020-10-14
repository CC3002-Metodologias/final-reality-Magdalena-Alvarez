package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StaffWeaponTest extends WeaponTest {
    private static final String STAFF_NAME = "Test Staff";

    private StaffWeapon testStaff;

    @BeforeEach
    void setUp(){
        testStaff = new StaffWeapon(STAFF_NAME);
    }

    @Test
    void constructorTest(){
        var expectedStaff = new StaffWeapon(STAFF_NAME);
        assertEquals(expectedStaff,testStaff);
        assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    }
}
