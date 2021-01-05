package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.controller.phases.PlayerDecisionPhase;
import com.github.cc3002.finalreality.model.character.AbstractCharacter;
//import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  public void setEquippedWeapon(IWeapon equippedWeapon) {
    this.equippedWeapon = equippedWeapon;
  }

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
    this.life-= 13-this.dp;
    if (this.life <=0){
      this.life=0;
      this.status = false;
      c.firePropertyChange("StatusCharacter",true, false);
    }
  }

  @Override
  public boolean isPlayerCharacter() {
    return true;
  }

  @Override
  public void decision() {
    state.toDecisionPhase();
  }
}
