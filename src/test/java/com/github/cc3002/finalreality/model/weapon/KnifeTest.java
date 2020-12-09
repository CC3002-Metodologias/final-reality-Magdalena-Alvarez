package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnifeTest extends  WeaponTest{
    private static final String NAME_Knife = "Super Knife";
    private static final String NAME_Knife2 = "Super Knife2";
    private static final String NAME_Staff = "Super Staff";
    private static final String NAME_BlackMage = "Ben";
    private IWeapon testKnife;
    @BeforeEach
    void set_Up(){
        testKnife = new KnifeWeapon(NAME_Knife);
    }
    @Test
    void constructorTest(){
        var differentDamage = new KnifeWeapon(NAME_Knife);
        differentDamage.damage = 0;
        var differentSpeed = new KnifeWeapon(NAME_Knife);
        differentSpeed.weight = 0;
        ckeckConstructor(testKnife,new KnifeWeapon(NAME_Knife),new StaffWeapon(NAME_Staff),differentDamage,new KnifeWeapon(NAME_Knife2),differentSpeed);
    }
}
