package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.BowWeapon;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  private static final String THIEF_NAME = "THIEF";
  private static final String KNIFE_NAME = "KNIFE";
  private Enemy enemytest;
  private Thief thieftest;
  private final KnifeWeapon knifeTest= new KnifeWeapon(KNIFE_NAME);
  @BeforeEach
  void setUp() {
    basicSetUp();
    enemytest = new Enemy(ENEMY_NAME, 10, turns);
    thieftest = new Thief(ENEMY_NAME, turns);
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns),
        enemytest,
        new Enemy(ENEMY_NAME, 11, turns),
        thieftest,new Enemy(KNIFE_NAME, 12, turns));

  }
  @Test
  void waitTurnTest() {
    checkWaitTurn(enemytest);
  }

  @Test
  void attackTest(){
    int previous_life = thieftest.getLife();
    enemytest.attack(thieftest);
    Assertions.assertEquals(previous_life-thieftest.getLife(), enemytest.getAttack_points()-thieftest.getDp());
    while(thieftest.getStatus()){
      enemytest.attack(thieftest);
    }
    Assertions.assertFalse(thieftest.getStatus());
    thieftest = new Thief(THIEF_NAME, turns);
    thieftest.equip(knifeTest);
    while(enemytest.getStatus()){
      thieftest.attack(enemytest);
    }
    previous_life = thieftest.getLife();
    enemytest.attack(thieftest);
    Assertions.assertEquals(previous_life, thieftest.getLife());

  }

}