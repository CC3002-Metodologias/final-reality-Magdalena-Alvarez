package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
//import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Magdalena Álvarez>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  private final CharacterClass characterClass;
  protected int life = 0;
  protected int dp = 0;
  protected ScheduledExecutorService scheduledExecutor;


  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name, CharacterClass characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
    this.life = 50;
    this.dp = 3;
  }


  public abstract void waitTurn();
  // revisar si es necesario o no

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public CharacterClass getCharacterClass() {
    return characterClass;
  }

  @Override
  public int getLife() {
    return life;
  }

  @Override
  public int getDp() {
    return dp;
  }

  public abstract void attack(ICharacter character);
  @Override
  public void attackedByAxe(){
    this.life-= 8- this.dp;
  }

  @Override
  public void attackedByBow(){
    this.life-= 15- this.dp;
  }

  @Override
  public void attackedByKnife() {
    this.life-=5-this.dp;
  }

  @Override
  public void attackedBySword() {
    this.life-= 15-this.dp;
  }

  @Override
  public void attackedByStaff() {
    this.life-= 5-this.dp;
  }
}
