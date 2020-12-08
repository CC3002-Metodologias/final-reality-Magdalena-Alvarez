package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class WeaponTest {
  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 10;
  private static final int SPEED = 10;
  private static final String KNIFE_NAME2 = "Test Knife2";
  private static final String  PLAYER_NAME = "Test Player";
  protected BlockingQueue<ICharacter> turns;

  private AxeWeapon testAxe;
  private StaffWeapon testStaff;
  private SwordWeapon testSword;
  private BowWeapon testBow;
  private KnifeWeapon testKnife;
  private StaffWeapon testStaff2;
  private SwordWeapon testSword2;
  private KnifeWeapon testKnife2;
  private IPlayer testplayer;


  @BeforeEach
  void setUp() {
    turns = new LinkedBlockingQueue<>();
    testAxe = new AxeWeapon(AXE_NAME);
    testStaff = new StaffWeapon(STAFF_NAME);
    testSword = new SwordWeapon(SWORD_NAME);
    testBow = new BowWeapon(BOW_NAME);
    testKnife = new KnifeWeapon(KNIFE_NAME);
    testStaff2 = new StaffWeapon(STAFF_NAME);
    testSword2 = new SwordWeapon(SWORD_NAME);
    testKnife2 = new KnifeWeapon(KNIFE_NAME2);
    testplayer = new Thief(PLAYER_NAME, turns);
    testStaff2.damage = DAMAGE;
    testSword2.weight = SPEED;

  }

  @Test
  void constructorTest() {
    var expectedAxe = new AxeWeapon(AXE_NAME);
    var expectedStaff = new StaffWeapon(STAFF_NAME);
    var expectedSword = new SwordWeapon(SWORD_NAME);
    var expectedBow = new BowWeapon(BOW_NAME);
    var expectedKnife = new KnifeWeapon(KNIFE_NAME);

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
    assertNotEquals(testBow,testplayer);
    assertNotEquals(testBow.hashCode(),testplayer.hashCode());
    assertNotEquals( testAxe, testplayer);
    assertNotEquals(testAxe.hashCode(), testplayer.hashCode());
    assertNotEquals(testStaff, testplayer);
    assertNotEquals(testStaff.hashCode(), testplayer.hashCode());
    assertNotEquals(testSword, testplayer);
    assertNotEquals(testSword.hashCode(), testplayer.hashCode());
    assertNotEquals(testKnife, testplayer);
    assertNotEquals(testKnife.hashCode(), testplayer.hashCode());
    assertNotEquals(expectedAxe, testBow);
    assertNotEquals(expectedKnife, testKnife2);
    assertNotEquals(expectedStaff, testStaff2);
    assertNotEquals(expectedStaff.hashCode(),testStaff2.hashCode());
    assertNotEquals(expectedSword,testSword2);
    assertNotEquals(expectedSword.hashCode(),testSword2.hashCode());
  }
}