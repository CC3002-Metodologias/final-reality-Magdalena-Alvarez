package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class WeaponTest {

  protected void ckeckConstructor(IWeapon test, IWeapon expected, IWeapon differentClass, IWeapon differentDamage,
                                  IWeapon differentName, IWeapon differentSpeed){
    assertEquals(test,expected);
    assertNotEquals(test, differentClass);
    assertNotEquals(test, differentName);
    assertNotEquals(test, differentDamage);
    assertNotEquals(test, differentSpeed);
  }

}