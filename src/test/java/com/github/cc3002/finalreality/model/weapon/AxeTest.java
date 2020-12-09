package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AxeTest extends WeaponTest {
    private static final String NAME_AXE = "Super Axe";
    private static final String NAME_AXE2 = "Super Axe2";
    private static final String NAME_BOW = "Super Bow";
    private static final String NAME_KNIGHT = "Arturo";
    private IWeapon testAxe;
    @BeforeEach
    void set_Up(){
        testAxe = new AxeWeapon(NAME_AXE);
    }
    @Test
    void constructorTest(){
        var differentDamage = new AxeWeapon(NAME_AXE);
        differentDamage.damage = 20;
        var differentSpeed = new AxeWeapon(NAME_AXE);
        differentSpeed.weight = 2;
        ckeckConstructor(testAxe,new AxeWeapon(NAME_AXE),new BowWeapon(NAME_BOW),differentDamage,new AxeWeapon(NAME_AXE2),differentSpeed);
    }
}
