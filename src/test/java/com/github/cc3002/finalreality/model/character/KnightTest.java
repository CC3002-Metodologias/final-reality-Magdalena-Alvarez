package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.StaffWeapon;
import com.github.cc3002.finalreality.model.weapon.SwordWeapon;
import com.github.cc3002.finalreality.model.weapon.AxeWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest extends AbstractPlayerCharacterTest{
    private static final String knightName = "Johann";
    private static final String SWORD_NAME = "Slayer";
    private static final String Axe_NAME = "Super Axe";
    private static final String KNIFE_NAME = "Super Knife";
    private static final String Axe_NAME2 = "Super Axe2";
    private static final String SWORD_NAME2 = "Slayer2";
    private static final String KNIFE_NAME2 = "Super Knife2";
    private static final String ENEMY_NAME = "EMEMY";
    private static Knight testKnight;
    private Enemy enemytest;
    private int previous_life;



    @BeforeEach
    void setUp(){
        basicSetUp();
        testKnight = new Knight(knightName,turns);
        enemytest = new Enemy(ENEMY_NAME, 11, turns);
        previous_life = enemytest.getLife();
    }
    @Test
    void constructorTest(){
        var expectedKnight = new Knight(knightName,turns);
        assertEquals(expectedKnight,testKnight);
        //testPlayerCharacters.add(testKnight);
    }

    @Test
    void equipSwordTest() {
        var expectedsword = new SwordWeapon(SWORD_NAME);
        assertNull(testKnight.getEquippedWeapon());
        testKnight.equipSword(SWORD_NAME);
        assertEquals(expectedsword, testKnight.getEquippedWeapon());
        while (testKnight.status){
            enemytest.attack(testKnight);
        }
        var expectedsword2 = new SwordWeapon(SWORD_NAME2);
        testKnight.equipSword(SWORD_NAME2);
        assertNotEquals(testKnight.getEquippedWeapon(),expectedsword2);

    }

    @Test
    void equipAxeTest() {
        var expectedAxe = new AxeWeapon(Axe_NAME);
        assertNull(testKnight.getEquippedWeapon());
        testKnight.equipAxe(Axe_NAME);
        assertEquals(expectedAxe, testKnight.getEquippedWeapon());
        while (testKnight.status){
            enemytest.attack(testKnight);
        }
        var expectedAxe2 = new AxeWeapon(Axe_NAME2);
        testKnight.equipAxe(Axe_NAME2);
        assertNotEquals(testKnight.getEquippedWeapon(),expectedAxe2);

    }

    @Test
    void equipKnifeTest() {
        var expectedknife = new KnifeWeapon(KNIFE_NAME);
        assertNull(testKnight.getEquippedWeapon());
        testKnight.equipKnife(KNIFE_NAME);
        assertEquals(expectedknife, testKnight.getEquippedWeapon());
        while (testKnight.status){
            enemytest.attack(testKnight);
        }
        var expectedknife2 = new KnifeWeapon(KNIFE_NAME2);
        testKnight.equipKnife(KNIFE_NAME2);
        assertNotEquals(testKnight.getEquippedWeapon(),expectedknife2);

    }
    @Test
    void attackTest(){
        testKnight.attack(enemytest);
        Assertions.assertEquals(previous_life, enemytest.getLife());
        testKnight.equipAxe(Axe_NAME);
        testKnight.attack(enemytest);
        Assertions.assertEquals(previous_life-enemytest.getLife(), testKnight.getEquippedWeapon().getDamage()-enemytest.getDp());
        while(enemytest.getStatus()){
            testKnight.attack(enemytest);
        }
        Assertions.assertFalse(enemytest.getStatus());
    }
    protected void tryToEquipSword(Knight character) {

        character.equipSword(SWORD_NAME);
    }


    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        tryToEquipSword(testKnight);
        testKnight.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testKnight, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
