package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.github.cc3002.finalreality.model.weapon.StaffWeapon;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see PlayerCharacter
 */
class PlayerCharacterTest extends AbstractCharacterTest {

  protected List<PlayerCharacter> testPlayerCharacters = new ArrayList<>();


  private static final String BLACK_MAGE_NAME = "Vivi";
  private static final String KNIGHT_NAME = "Adelbert";
  private static final String WHITE_MAGE_NAME = "Eiko";
  private static final String ENGINEER_NAME = "Cid";
  private static final String THIEF_NAME = "Zidane";
  private static final String Staff_NAME = "Test Staff";
  private Map<CharacterClass, String> characterNames;
  private Weapon weapontest = new Weapon("knife", 15, 15, WeaponType.KNIFE);


  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */

  @BeforeEach
  void setUp() {
    super.basicSetUp();
    characterNames = new EnumMap<>(CharacterClass.class);
    characterNames.put(CharacterClass.BLACK_MAGE, BLACK_MAGE_NAME);
    characterNames.put(CharacterClass.KNIGHT, KNIGHT_NAME);
    characterNames.put(CharacterClass.WHITE_MAGE, WHITE_MAGE_NAME);
    characterNames.put(CharacterClass.ENGINEER, ENGINEER_NAME);
    characterNames.put(CharacterClass.THIEF, THIEF_NAME);

    for (var characterClass:
      characterNames.keySet())
      testPlayerCharacters.add(
              new PlayerCharacter(characterNames.get(characterClass), turns, characterClass));


  }


  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var enemy = new Enemy("Enemy", 10, turns);
    for (var character :
            testPlayerCharacters) {
      var characterClass = character.getCharacterClass();
      var characterName = characterNames.get(characterClass);
      checkConstruction(new PlayerCharacter(characterName, turns, characterClass),
          character,
          new PlayerCharacter("Test", turns, characterClass),
          new PlayerCharacter(characterName, turns,
              characterClass == CharacterClass.THIEF ? CharacterClass.BLACK_MAGE
                  : CharacterClass.THIEF));
      assertNotEquals(character, enemy);
    }

  }
  protected void tryToEquip(PlayerCharacter character) {

    character.equip(weapontest);
  }

  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    tryToEquip(testPlayerCharacters.get(0));
    testPlayerCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testPlayerCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


/*
//  @Test
 // void equipWeaponTest() {
   // for (var character :
     //   testPlayerCharacters) {
      //assertNull(character.getEquippedWeapon());
      //character.equip(testWeapon);
      //assertEquals(testWeapon, character.getEquippedWeapon());
    //}
  //}

   */
}
