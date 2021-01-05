package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Mage.Black_Mage;
import com.github.cc3002.finalreality.model.character.player.Mage.White_Mage;
import com.github.cc3002.finalreality.model.weapon.StaffWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class White_MageTest extends  AbstractPlayerCharacterTest{
    private static final String White_MageName = "Mage";
    private White_Mage testWhite_Mage;
    private static final String ENEMY_NAME = "ENEMY";
    private static final String STAFF_NAME = "mystic Staff";
    private static final String STAFF_NAME2 = "super mystic Staff";
    private Enemy enemytest;
    private final StaffWeapon staffTest= new StaffWeapon(STAFF_NAME);
    private final StaffWeapon staffTest2= new StaffWeapon(STAFF_NAME2);

    @BeforeEach
    void setUp(){
        basicSetUp();
        testWhite_Mage = new White_Mage(White_MageName,turns);
        enemytest = new Enemy(ENEMY_NAME, 11, turns);
    }
    @Test
    void constructorTest(){
        var expectedWhite_Mage = new White_Mage(White_MageName,turns);
        checkConstruction(expectedWhite_Mage,testWhite_Mage,
                new Black_Mage(ENEMY_NAME,turns),new Enemy(ENEMY_NAME, 11, turns),new White_Mage(ENEMY_NAME, turns));
    }

    @Test
    void equipTest(){
        checkEquippedWeapon(testWhite_Mage, staffTest);
        checkDead(testWhite_Mage, staffTest2,enemytest);
    }
    @Test
    void attackTest(){
        checkAttack(testWhite_Mage,staffTest,enemytest);
    }


    @Test
    void waitTurnTest() {
        testWhite_Mage.equip(staffTest);
        checkWaitTurn(testWhite_Mage);
    }

}
