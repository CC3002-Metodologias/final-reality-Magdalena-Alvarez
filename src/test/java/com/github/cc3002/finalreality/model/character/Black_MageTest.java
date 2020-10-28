package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Black_Mage;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.StaffWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Black_MageTest extends AbstractPlayerCharacterTest{
    private static final String Black_MageName = "Jack";
    private static final String ENEMY_NAME = "EMEMY";
    private Black_Mage testBlack_Mage;

    private static final String STAFF_NAME = "mystic Staff";
    private static final String KNIFE_NAME = "Super Knife";
    //protected Weapon testWeapon = new Weapon("Sword",15,10, WeaponType.SWORD);
    @BeforeEach
    void setUp(){
        basicSetUp();
        testBlack_Mage = new Black_Mage(Black_MageName,turns);
    }
    @Test
    void constructorTest(){
        var expectedBlack_Mage = new Black_Mage(Black_MageName,turns);
        //assertEquals(expectedBlack_Mage,testBlack_Mage);
        checkConstruction(expectedBlack_Mage,testBlack_Mage,
                new Black_Mage(ENEMY_NAME,turns),new Enemy(ENEMY_NAME, 11, turns));
        //testPlayerCharacters.add(testKnight);
    }

    @Test
    void equipStaffTest() {
        var expectedstaff = new StaffWeapon(STAFF_NAME);
        assertNull(testBlack_Mage.getEquippedWeapon());
        testBlack_Mage.equipStaff(STAFF_NAME);
        assertEquals(expectedstaff, testBlack_Mage.getEquippedWeapon());
    }
    @Test
    void equipKnifeTest() {
        var expectedknife = new KnifeWeapon(KNIFE_NAME);
        assertNull(testBlack_Mage.getEquippedWeapon());
        testBlack_Mage.equipKnife(KNIFE_NAME);
        assertEquals(expectedknife, testBlack_Mage.getEquippedWeapon());
    }
    protected void tryToEquipStaff(Black_Mage character) {

        character.equipStaff(STAFF_NAME);
    }


    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        tryToEquipStaff(testBlack_Mage);
        testBlack_Mage.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testBlack_Mage, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
