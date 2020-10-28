package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.weapon.AxeWeapon;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EngineerTest extends AbstractPlayerCharacterTest {

    private static final String EngineerName = "Kevin";
    private static final String AXE_NAME = "Super Axe";
    private static final String BOW_NAME = "Super Bow";
    private Engineer testEngineer;
    @BeforeEach
    void setUp(){
        basicSetUp();
        testEngineer = new Engineer(EngineerName,turns);
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
    }

    @Test
    void equipBowTest() {
        var expectedbow = new BowWeapon(BOW_NAME);
        assertNull(testEngineer.getEquippedWeapon());
        testEngineer.equipBow(BOW_NAME);
        assertEquals(expectedbow, testEngineer.getEquippedWeapon());
    }
    protected void tryToEquipAxe(Engineer character) {

        character.equipAxe(AXE_NAME);
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
