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
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see AbstractPlayerCharacter
 */
class AbstractPlayerCharacterTest extends AbstractCharacterTest {

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  /*
  protected void checkConstruction(final IPlayer expectedCharacter,
                                   final IPlayer testEqualCharacter,
                                   final IPlayer sameClassDifferentCharacter,
                                   final IPlayer differentClassCharacter) {
    assertEquals(expectedCharacter, testEqualCharacter);
    assertNotEquals(sameClassDifferentCharacter, testEqualCharacter);
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertEquals(expectedCharacter.hashCode(), testEqualCharacter.hashCode());
  }

   */
  /*
  protected void tryToEquip(PlayerCharacter character) {

    character.equip(weapontest);
  }
   */
/*
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
*/

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
