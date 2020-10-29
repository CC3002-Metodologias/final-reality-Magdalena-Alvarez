package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.White_Mage;
import com.github.cc3002.finalreality.model.character.player.White_Mage;
import com.github.cc3002.finalreality.model.character.player.White_Mage;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.StaffWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class White_MageTest extends  AbstractPlayerCharacterTest{
    private static final String White_MageName = "Mage";
    private White_Mage testWhite_Mage;
    private static final String ENEMY_NAME = "EMEMY";
    private static final String STAFF_NAME2 = "mystic Staff2";
    private Enemy enemytest;
    private int previous_life;

    private static final String STAFF_NAME = "mystic Staff";
    //protected Weapon testWeapon = new Weapon("Sword",15,10, WeaponType.SWORD);
    @BeforeEach
    void setUp(){
        basicSetUp();
        testWhite_Mage = new White_Mage(White_MageName,turns);
        enemytest = new Enemy(ENEMY_NAME, 11, turns);
        previous_life = enemytest.getLife();
    }
    @Test
    void constructorTest(){
        var expectedWhite_Mage = new White_Mage(White_MageName,turns);
        assertEquals(expectedWhite_Mage,testWhite_Mage);

        //testPlayerCharacters.add(testKnight);
    }

    @Test
    void equipStaffTest() {
        var expectedstaff = new StaffWeapon(STAFF_NAME);
        assertNull(testWhite_Mage.getEquippedWeapon());
        testWhite_Mage.equipStaff(STAFF_NAME);
        assertEquals(expectedstaff, testWhite_Mage.getEquippedWeapon());
        while (testWhite_Mage.status){
            enemytest.attack(testWhite_Mage);
        }
        var expectedstaff2 = new KnifeWeapon(STAFF_NAME2);
        testWhite_Mage.equipStaff(STAFF_NAME2);
        assertNotEquals(testWhite_Mage.getEquippedWeapon(),expectedstaff2);

    }
    @Test
    void attackTest(){
        testWhite_Mage.attack(enemytest);
        Assertions.assertEquals(previous_life, enemytest.getLife());
        testWhite_Mage.equipStaff(STAFF_NAME);
        testWhite_Mage.attack(enemytest);
        Assertions.assertEquals(previous_life-enemytest.getLife(), testWhite_Mage.getEquippedWeapon().getDamage()-enemytest.getDp());
        while(enemytest.getStatus()){
            testWhite_Mage.attack(enemytest);
        }
        Assertions.assertFalse(enemytest.getStatus());
    }

    protected void tryToEquipStaff(White_Mage character) {

        character.equipStaff(STAFF_NAME);
    }


    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        tryToEquipStaff(testWhite_Mage);
        testWhite_Mage.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testWhite_Mage, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
