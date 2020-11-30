package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
//import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Magdalena Álvarez>
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayer{
  protected IWeapon equippedWeapon = null;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   */


  public AbstractPlayerCharacter(@NotNull String name,
      @NotNull BlockingQueue<ICharacter> turnsQueue,
      final CharacterClass characterClass) {
    super(turnsQueue, name, characterClass);

  }

  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass());
  }


  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  public void setEquippedWeapon(IWeapon equippedWeapon) {
    this.equippedWeapon = equippedWeapon;
  }


    /**
     * Equips a weapon to the player character.
     * @param weapon
     *    weapon that is going be equipped
    */
    public abstract void equip(IWeapon weapon);

  @Override
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }
  @Override
  public void attack(ICharacter character){
    if (this.equippedWeapon != null && this.status) {
      this.equippedWeapon.attack(character);
    }
  }
  @Override
  public void attackedByEnemy() {
    this.life-= 8-this.dp;
    if (this.life <=0){
      this.status = false;
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IPlayer)) {
      return false;
    }
    final IPlayer that = (IPlayer) o;
    return getCharacterClass() == that.getCharacterClass()
        && getName().equals(that.getName());
  }

}
