package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowTest extends WeaponTest{
    private static final String NAME_Bow = "Super Bow";
    private static final String NAME_Bow2 = "Super Bow2";
    private static final String NAME_Knife = "Super knife";
    private static final String NAME_Egineer = "Jack";
    private IWeapon testBow;
    @BeforeEach
    void set_Up(){
        testBow = new BowWeapon(NAME_Bow);
    }
    @Test
    void constructorTest(){
        var differentDamage = new BowWeapon(NAME_Bow);
        differentDamage.damage = 0;
        var differentSpeed = new BowWeapon(NAME_Bow);
        differentSpeed.weight = 0;
        ckeckConstructor(testBow,new BowWeapon(NAME_Bow),new KnifeWeapon(NAME_Knife),differentDamage,new BowWeapon(NAME_Bow2),differentSpeed);
    }
}
