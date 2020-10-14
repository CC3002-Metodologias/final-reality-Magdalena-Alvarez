package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.SwordWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ThiefTest extends PlayerCharacterTest{
    private static final String ThiefName = "Jeff";
    private static final String KNIFE_NAME = "Super Knife";
    private static final String BOW_NAME = "Super Bow";
    private static final String SWORD_NAME = "Slayer";
    private Thief testThief;
    //protected Weapon testWeapon = new Weapon("Sword",15,10, WeaponType.SWORD);
    @BeforeEach
    void setUp(){
        basicSetUp();
        testThief = new Thief(ThiefName,turns);
    }
    @Test
    void constructorTest(){
        var expectedThief = new Thief(ThiefName,turns);
        assertEquals(expectedThief,testThief);
    }

    @Test
    void equipKnifeTest() {
        var expectedknife = new KnifeWeapon(KNIFE_NAME);
        assertNull(testThief.getEquippedWeapon());
        testThief.equipKnife(KNIFE_NAME);
        assertEquals(expectedknife, testThief.getEquippedWeapon());
    }

    @Test
    void equipBowTest() {
        var expectedbow = new BowWeapon(BOW_NAME);
        assertNull(testThief.getEquippedWeapon());
        testThief.equipBow(BOW_NAME);
        assertEquals(expectedbow, testThief.getEquippedWeapon());
    }

    @Test
    void equipSwordTest() {
        var expectedsword = new SwordWeapon(SWORD_NAME);
        assertNull(testThief.getEquippedWeapon());
        testThief.equipSword(SWORD_NAME);
        assertEquals(expectedsword, testThief.getEquippedWeapon());
    }
    protected void tryToEquipKNIFE(Thief character) {

        character.equipKnife(KNIFE_NAME);
    }


    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        tryToEquipKNIFE(testThief);
        testThief.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testThief, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
