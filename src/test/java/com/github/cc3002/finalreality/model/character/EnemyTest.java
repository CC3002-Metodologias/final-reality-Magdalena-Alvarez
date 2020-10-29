package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  private static final String BLACKM_NAME = "MAGE1";
  private static final String THIEF_NAME = "THIEF";
  private static final String KNIGHT_NAME = "KNIGHT";
  private static final String KNIFE_NAME = "KNIFE";
  private ICharacter enemytest;
  private Thief thieftest;
  private ICharacter blackmtest;
  private ICharacter knighttest;

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(ENEMY_NAME, 10, turns));
    enemytest = new Enemy(ENEMY_NAME, 11, turns);
    thieftest = new Thief(THIEF_NAME, turns);
    blackmtest = new Black_Mage(BLACKM_NAME, turns);
    knighttest = new Knight(KNIGHT_NAME, turns);
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, 11, turns),
        new Thief(ENEMY_NAME, turns));

  }
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  void attackTest(){
    ICharacter testcharacter = new Thief(ENEMY_NAME, turns);
    int previous_life = testcharacter.getLife();
    enemytest.attack(testcharacter);
    Enemy enemy = (Enemy) enemytest;
    Assertions.assertEquals(previous_life-testcharacter.getLife(), enemy.getAttack_points()-testcharacter.getDp());
    while(testcharacter.getStatus()){
      enemytest.attack(testcharacter);
    }
    Assertions.assertFalse(testcharacter.getStatus());
    thieftest.equipKnife(KNIFE_NAME);
    while(enemytest.getStatus()){
      thieftest.attack(enemytest);
    }
    previous_life = thieftest.getLife();
    enemytest.attack(thieftest);
    Assertions.assertEquals(previous_life, thieftest.getLife());

  }

}