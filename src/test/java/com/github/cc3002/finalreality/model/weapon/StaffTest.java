package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StaffTest extends WeaponTest{
    private static final String NAME_Staff = "Super Staff";
    private static final String NAME_Staff2 = "Super Staff2";
    private static final String NAME_Sword = "Super Sword";
    private static final String NAME_WhiteMage = "Ben";
    private IWeapon testStaff;
    @BeforeEach
    void set_Up(){
        testStaff = new StaffWeapon(NAME_Staff);
    }
    @Test
    void constructorTest(){
        var differentDamage = new StaffWeapon(NAME_Staff);
        differentDamage.damage = 0;
        var differentSpeed = new StaffWeapon(NAME_Staff);
        differentSpeed.weight = 0;
        ckeckConstructor(testStaff,new StaffWeapon(NAME_Staff),new SwordWeapon(NAME_Sword),differentDamage,new StaffWeapon(NAME_Staff2),differentSpeed);
    }
}
