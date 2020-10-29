package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.SwordWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThiefTest extends AbstractPlayerCharacterTest{
    private static final String ThiefName = "Jeff";
    private static final String KNIFE_NAME = "Super Knife";
    private static final String BOW_NAME = "Super Bow";
    private static final String SWORD_NAME = "Slayer";
    private static final String KNIFE_NAME2 = "Super Knife2";
    private static final String BOW_NAME2 = "Super Bow2";
    private static final String SWORD_NAME2 = "Slayer2";
    private static final String ENEMY_NAME = "EMEMY";
    private Thief testThief;
    private Enemy enemytest;
    private int previous_life;
    //protected Weapon testWeapon = new Weapon("Sword",15,10, WeaponType.SWORD);
    @BeforeEach
    void setUp(){
        basicSetUp();
        testThief = new Thief(ThiefName,turns);
        enemytest = new Enemy(ENEMY_NAME, 11, turns);
        previous_life = enemytest.getLife();
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
        while (testThief.status){
            enemytest.attack(testThief);
        }
        var expectedknife2 = new KnifeWeapon(KNIFE_NAME2);
        testThief.equipKnife(KNIFE_NAME2);
        assertNotEquals(testThief.getEquippedWeapon(),expectedknife2);

    }

    @Test
    void equipBowTest() {
        var expectedbow = new BowWeapon(BOW_NAME);
        assertNull(testThief.getEquippedWeapon());
        testThief.equipBow(BOW_NAME);
        assertEquals(expectedbow, testThief.getEquippedWeapon());
        while (testThief.status){
            enemytest.attack(testThief);
        }
        var expectedbow2 = new BowWeapon(BOW_NAME2);
        testThief.equipBow(BOW_NAME2);
        assertNotEquals(testThief.getEquippedWeapon(),expectedbow2);

    }

    @Test
    void equipSwordTest() {
        var expectedsword = new SwordWeapon(SWORD_NAME);
        assertNull(testThief.getEquippedWeapon());
        testThief.equipSword(SWORD_NAME);
        assertEquals(expectedsword, testThief.getEquippedWeapon());
        while (testThief.status){
            enemytest.attack(testThief);
        }
        var expectedsword2 = new SwordWeapon(SWORD_NAME2);
        testThief.equipSword(SWORD_NAME2);
        assertNotEquals(testThief.getEquippedWeapon(),expectedsword2);

    }
    @Test
    void attackTest(){
        testThief.attack(enemytest);
        Assertions.assertEquals(previous_life, enemytest.getLife());
        testThief.equipSword(SWORD_NAME);
        testThief.attack(enemytest);
        Assertions.assertEquals(previous_life-enemytest.getLife(), testThief.getEquippedWeapon().getDamage()-enemytest.getDp());
        while(enemytest.getStatus()){
            testThief.attack(enemytest);
        }
        Assertions.assertFalse(enemytest.getStatus());
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
