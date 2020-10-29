package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.weapon.AxeWeapon;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.StaffWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EngineerTest extends AbstractPlayerCharacterTest {

    private static final String EngineerName = "Kevin";
    private static final String AXE_NAME = "Super Axe";
    private static final String BOW_NAME = "Super Bow";
    private static final String AXE_NAME2 = "Super Axe2";
    private static final String BOW_NAME2= "Super Bow2";
    private static final String ENEMY_NAME = "EMEMY";
    private Engineer testEngineer;
    private Enemy enemytest;
    private int previous_life;

    @BeforeEach
    void setUp(){
        basicSetUp();
        testEngineer = new Engineer(EngineerName,turns);
        enemytest = new Enemy(ENEMY_NAME, 11, turns);
        previous_life = enemytest.getLife();
    }
    @Test
    void constructorTest(){
        var expectedEngineer = new Engineer(EngineerName,turns);
        assertEquals(expectedEngineer,testEngineer);
    }

    @Test
    void equipAxeTest() {
        var expectedaxe = new AxeWeapon(AXE_NAME);
        assertNull(testEngineer.getEquippedWeapon());
        testEngineer.equipAxe(AXE_NAME);
        assertEquals(expectedaxe, testEngineer.getEquippedWeapon());
        while (testEngineer.status){
            enemytest.attack(testEngineer);
        }
        var expectedaxe2 = new AxeWeapon(AXE_NAME2);
        testEngineer.equipAxe(AXE_NAME2);
        assertNotEquals(testEngineer.getEquippedWeapon(),expectedaxe2);
    }

    @Test
    void equipBowTest() {
        var expectedbow = new BowWeapon(BOW_NAME);
        assertNull(testEngineer.getEquippedWeapon());
        testEngineer.equipBow(BOW_NAME);
        assertEquals(expectedbow, testEngineer.getEquippedWeapon());
        while (testEngineer.status){
            enemytest.attack(testEngineer);
        }
        var expectedstaff2 = new BowWeapon(BOW_NAME2);
        testEngineer.equipBow(BOW_NAME2);
        assertNotEquals(testEngineer.getEquippedWeapon(),expectedstaff2);
    }
    protected void tryToEquipAxe(Engineer character) {

        character.equipAxe(AXE_NAME);
    }
    @Test
    void attackTest(){
        testEngineer.attack(enemytest);
        Assertions.assertEquals(previous_life, enemytest.getLife());
        testEngineer.equipBow(BOW_NAME);
        testEngineer.attack(enemytest);
        Assertions.assertEquals(previous_life-enemytest.getLife(), testEngineer.getEquippedWeapon().getDamage()-enemytest.getDp());
        while(enemytest.getStatus()){
            testEngineer.attack(enemytest);
        }
        Assertions.assertFalse(enemytest.getStatus());
    }


    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        tryToEquipAxe(testEngineer);
        testEngineer.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testEngineer, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
