package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThiefTest extends PlayerCharacterTest{
    private static final String ThiefName = "Kevin";
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
        //testPlayerCharacters.add(testKnight);
    }

    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        tryToEquip(testThief);
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
