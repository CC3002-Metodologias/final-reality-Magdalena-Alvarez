package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Mage.Black_Mage;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.SwordWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ThiefTest extends AbstractPlayerCharacterTest{
    private static final String ThiefName = "Jeff";
    private static final String BOW_NAME = "Super Bow";
    private static final String Knife_NAME = "Super knife";
    private static final String swordName = "slayer";
    private static final String ENEMY_NAME = "ENEMY";
    private Thief testThief;
    private Enemy enemytest;
    private final BowWeapon BowTest= new BowWeapon(BOW_NAME);
    private final KnifeWeapon knifeTest= new KnifeWeapon(Knife_NAME);
    private final SwordWeapon swordTest = new SwordWeapon(swordName);
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
        checkDead(testThief, knifeTest,enemytest);
    }
    @Test
    void attackTest(){
        checkAttack(testThief,BowTest,enemytest);
    }


    @Test
    void waitTurnTest() {
        testThief.equip(swordTest);
        checkWaitTurn(testThief);
    }
}
