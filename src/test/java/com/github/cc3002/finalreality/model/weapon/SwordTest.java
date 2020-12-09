package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SwordTest extends WeaponTest{
    private static final String NAME_Sword = "Super Sword";
    private static final String NAME_Sword2 = "Super Sword2";
    private static final String NAME_Axe = "Super Axe";
    private static final String NAME_BlackMage = "Ben";
    private IWeapon testSword;
    @BeforeEach
    void set_Up(){
        testSword = new SwordWeapon(NAME_Sword);
    }
    @Test
    void constructorTest(){
        var differentDamage = new SwordWeapon(NAME_Sword);
        differentDamage.damage = 0;
        var differentSpeed = new SwordWeapon(NAME_Sword);
        differentSpeed.weight = 0;
        ckeckConstructor(testSword,new SwordWeapon(NAME_Sword),new AxeWeapon(NAME_Axe),differentDamage,new SwordWeapon(NAME_Sword2),differentSpeed);
    }
}
