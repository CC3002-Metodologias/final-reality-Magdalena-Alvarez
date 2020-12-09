package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Magdalena Álvarez>
 */
public abstract class AbstractWeapon implements IWeapon {

  protected final String name;
  protected int damage;
  protected int weight;
  protected final WeaponType type;

  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @see WeaponType
   */
  public AbstractWeapon(final String name, final int damage, final int weight,
      final WeaponType type) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = type;
  }


  @Override
  public String getName() {
    return name;
  }
  @Override
  public int getDamage() {
    return damage;
  }
  @Override
  public int getWeight() {
    return weight;
  }
  @Override
  public WeaponType getType() {
    return type;
  }

  public abstract void attack(ICharacter character);

  @Override
  public void equippedByWhite_Mage(White_Mage whiteMage) {

  }

  @Override
  public void equippedByBlack_Mage(Black_Mage blackMage) {

  }

  @Override
  public void equippedByEngineer(Engineer engineer) {

  }

  @Override
  public void equippedByKnight(Knight knight) {

  }

  @Override
  public void equippedByThief(Thief thief) {

  }
}
