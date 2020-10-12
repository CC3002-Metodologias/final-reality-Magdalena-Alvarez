package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class WeaponTest {
  protected BlockingQueue<ICharacter> turns;
  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int DAMAGE2 = 10;
  private static final int SPEED = 10;
  private static final int SPEED2 = 15;
  private static final String Player_Name = "Test Player";

  private Weapon testAxe;
  private Weapon testStaff;
  private Weapon testSword;
  private Weapon testBow;
  private Weapon testKnife;
  private Weapon testStaff2;
  private Weapon testSword2;

  private PlayerCharacter testPlayer;

  @BeforeEach
  void setUp() {

    turns = new LinkedBlockingQueue<>();
    testAxe = new Weapon(AXE_NAME, DAMAGE, SPEED, WeaponType.AXE);
    testStaff = new Weapon(STAFF_NAME, DAMAGE, SPEED, WeaponType.STAFF);
    testSword = new Weapon(SWORD_NAME, DAMAGE, SPEED, WeaponType.SWORD);
    testBow = new Weapon(BOW_NAME, DAMAGE, SPEED, WeaponType.BOW);
    testKnife = new Weapon(KNIFE_NAME, DAMAGE, SPEED, WeaponType.KNIFE);
    testPlayer = new PlayerCharacter(Player_Name,turns, CharacterClass.BLACK_MAGE);
    testStaff2 = new Weapon(STAFF_NAME, DAMAGE2, SPEED, WeaponType.STAFF);
    testSword2 = new Weapon(SWORD_NAME, DAMAGE, SPEED2, WeaponType.SWORD);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new Weapon(AXE_NAME, DAMAGE, SPEED, WeaponType.AXE);
    var expectedStaff = new Weapon(STAFF_NAME, DAMAGE, SPEED, WeaponType.STAFF);
    var expectedSword = new Weapon(SWORD_NAME, DAMAGE, SPEED, WeaponType.SWORD);
    var expectedBow = new Weapon(BOW_NAME, DAMAGE, SPEED, WeaponType.BOW);
    var expectedKnife = new Weapon(KNIFE_NAME, DAMAGE, SPEED, WeaponType.KNIFE);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
    assertNotEquals(expectedAxe,testPlayer);
    assertNotEquals(testBow, testAxe);
    assertNotEquals(expectedStaff, testStaff2);
    assertNotEquals(expectedSword,testSword2);
  }
}