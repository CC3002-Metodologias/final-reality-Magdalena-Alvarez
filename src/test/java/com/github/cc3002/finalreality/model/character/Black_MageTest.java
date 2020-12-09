package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Black_Mage;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.StaffWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Black_MageTest extends AbstractPlayerCharacterTest{
    private static final String Black_MageName = "Jack";
    private static final String ENEMY_NAME = "EMEMY";
    private Black_Mage testBlack_Mage;
    private Enemy enemytest;

    private static final String KNIFE_NAME = "Super Knife";
    private final KnifeWeapon knifeTest= new KnifeWeapon(KNIFE_NAME);
    private static final String KNIFE_NAME2 = "Super Knife2";
    private final KnifeWeapon knifeTest2= new KnifeWeapon(KNIFE_NAME2);
    private final String StaffName = "Super Staff";
    private final StaffWeapon staffTest = new StaffWeapon(StaffName);

    @BeforeEach
    void setUp(){
        basicSetUp();
        testBlack_Mage = new Black_Mage(Black_MageName,turns);
        enemytest = new Enemy(ENEMY_NAME, 11, turns);
    }
    @Test
    void constructorTest(){
        var expectedBlack_Mage = new Black_Mage(Black_MageName,turns);
        checkConstruction(expectedBlack_Mage,testBlack_Mage,
                new Black_Mage(ENEMY_NAME,turns),new Enemy(ENEMY_NAME, 11, turns),new Black_Mage(ENEMY_NAME,turns));
    }

    @Test
    void equipTest(){
        checkEquippedWeapon(testBlack_Mage, knifeTest);
        checkDead(testBlack_Mage, knifeTest2,enemytest);
    }
    @Test
    void waitTurnTest() {
        testBlack_Mage.equip(staffTest);
        checkWaitTurn(testBlack_Mage);
    }
    @Test
    void attackTest(){
        checkAttack(testBlack_Mage,knifeTest, enemytest);
    }

}
