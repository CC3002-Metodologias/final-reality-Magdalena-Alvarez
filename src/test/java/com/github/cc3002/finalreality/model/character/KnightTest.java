package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.SwordWeapon;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KnightTest extends PlayerCharacterTest{

   // protected List<PlayerCharacter> testPlayerCharacters = new ArrayList<>();
    private static final String knightName = "Johann";
    private static final String SWORD_NAME = "Slayer";
    private static final String BOW_NAME = "Super Bow";
    private static final String KNIFE_NAME = "Super Knife";
    private static Knight testKnight;


    @BeforeEach
    void setUp(){
        basicSetUp();
        testKnight = new Knight(knightName,turns);
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
    }

    @Test
    void equipBowTest() {
        var expectedbow = new BowWeapon(BOW_NAME);
        assertNull(testKnight.getEquippedWeapon());
        testKnight.equipBow(BOW_NAME);
        assertEquals(expectedbow, testKnight.getEquippedWeapon());
    }

    @Test
    void equipKnifeTest() {
        var expectedknife = new KnifeWeapon(KNIFE_NAME);
        assertNull(testKnight.getEquippedWeapon());
        testKnight.equipKnife(KNIFE_NAME);
        assertEquals(expectedknife, testKnight.getEquippedWeapon());
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
