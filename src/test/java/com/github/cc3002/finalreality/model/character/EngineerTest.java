package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Mage.Black_Mage;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.weapon.AxeWeapon;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EngineerTest extends AbstractPlayerCharacterTest {

    private static final String EngineerName = "Kevin";
    private static final String AXE_NAME = "Super Axe";
    private static final String AXE_NAME2 = "Super Axe2";
    private static final String ENEMY_NAME = "ENEMY";
    private final AxeWeapon axeTest= new AxeWeapon(AXE_NAME);
    private final AxeWeapon axeTest2= new AxeWeapon(AXE_NAME2);
    private final String bowName = "super Bow";
    private final BowWeapon bowTest = new BowWeapon(bowName);
    private Engineer testEngineer;
    private Enemy enemytest;

    @BeforeEach
    void setUp(){
        basicSetUp();
        testEngineer = new Engineer(EngineerName,turns);
        enemytest = new Enemy(ENEMY_NAME, 11, turns);
    }
    @Test
    void constructorTest(){
        var expectedEngineer = new Engineer(EngineerName,turns);
        checkConstruction(expectedEngineer,testEngineer,
                new Black_Mage(ENEMY_NAME,turns),new Enemy(ENEMY_NAME, 11, turns),new Engineer(ENEMY_NAME, turns));
    }

    @Test
    void equipTest(){
        checkEquippedWeapon(testEngineer, axeTest);
        checkDead(testEngineer, axeTest2,enemytest);
    }
    @Test
    void attackTest(){
        checkAttack(testEngineer,axeTest,enemytest);
    }

    @Test
    void waitTurnTest() {
        testEngineer.equip(bowTest);
        checkWaitTurn(testEngineer);
    }

}
