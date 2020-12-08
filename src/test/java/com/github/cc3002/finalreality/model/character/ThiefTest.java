package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Black_Mage;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThiefTest extends AbstractPlayerCharacterTest{
    private static final String ThiefName = "Jeff";
    private static final String BOW_NAME = "Super Bow";
    private static final String BOW_NAME2 = "Super Bow2";
    private static final String ENEMY_NAME = "ENEMY";
    private Thief testThief;
    private Enemy enemytest;
    private final BowWeapon BowTest= new BowWeapon(BOW_NAME);
    private final BowWeapon BowTest2= new BowWeapon(BOW_NAME2);

    @BeforeEach
    void setUp(){
        basicSetUp();
        testThief = new Thief(ThiefName,turns);
        enemytest = new Enemy(ENEMY_NAME, 11, turns);
    }
    @Test
    void constructorTest(){
        var expectedThief = new Thief(ThiefName,turns);
        checkConstruction(expectedThief,testThief,
                new Black_Mage(ENEMY_NAME,turns),new Enemy(ENEMY_NAME, 11, turns),new Thief(ENEMY_NAME,turns));
    }

    @Test
    void equipTest(){
        checkEquippedWeapon(testThief, BowTest);
        checkDead(testThief, BowTest2,enemytest);
    }
    @Test
    void attackTest(){
        checkAttack(testThief,BowTest,enemytest);
    }


    @Test
    void waitTurnTest() {
        testThief.equip(BowTest);
        checkWaitTurn(testThief);
    }
}
