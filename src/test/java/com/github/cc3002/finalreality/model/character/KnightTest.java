package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class KnightTest extends PlayerCharacterTest{

    protected List<PlayerCharacter> testPlayerCharacters = new ArrayList<>();
    private static final String knightName = "Johann";
    private Knight testKnight;
    //protected Weapon testWeapon = new Weapon("Sword",15,10, WeaponType.SWORD);
    @BeforeEach
    void setUp(){
        basicSetUp();
        testKnight = new Knight(knightName,turns);
    }
    @Test
    void constructorTest(){
        var expectedKnight = new Knight(knightName,turns);
        assertEquals(expectedKnight,testKnight);
    }

    @Test
    void waitTurnTest() {
        Assertions.assertTrue(turns.isEmpty());
        tryToEquip(testKnight);
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
