package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AxeWeaponTest extends WeaponTest{

    private static final String Axe_NAME = "Test Axe";

    private AxeWeapon testAxe;

    @BeforeEach
    void setUp(){
        testAxe = new AxeWeapon(Axe_NAME);
    }

    @Test
    void constructorTest(){
        var expectedAxe = new AxeWeapon(Axe_NAME);
        assertEquals(expectedAxe,testAxe);
        assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    }
}
