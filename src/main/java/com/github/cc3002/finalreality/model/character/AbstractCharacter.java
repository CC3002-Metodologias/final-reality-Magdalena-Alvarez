package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.controller.phases.IPhase;
import com.github.cc3002.finalreality.controller.phases.WaitingState;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
  protected int life;
  protected int dp;
  protected boolean status;
  protected IPhase state;
  protected ScheduledExecutorService scheduledExecutor;
  protected final PropertyChangeSupport c = new PropertyChangeSupport(this);

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name, CharacterClass characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
    this.life = 50;
    this.dp = 5;
    this.status = true;
    setState(new WaitingState());

  }

  public void setState(IPhase phase) {
    this.state= phase;
    state.setCharacter(this);
  }
  public abstract boolean isPlayerCharacter();
  public abstract void waitTurn();
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
  public IPhase getPhase() {
    return state;
  }

  @Override
  public abstract void decision();

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

  @Override
  public boolean getStatus(){ return status;}

  public abstract void attack(ICharacter character);

  public void addListener(PropertyChangeListener listener){
    c.addPropertyChangeListener(listener);
  }
  @Override
  public void attackedByAxe(){

    this.life-= 8- this.dp;
    if (this.life <=0) {
      this.status = false;
      c.firePropertyChange("StatusCharacter",true, false);
    }
  }

  @Override
  public void attackedByBow(){
    this.life-= 15- this.dp;
    if (this.life <=0) {
      this.status = false;
      c.firePropertyChange("StatusCharacter",true, false);
    }
  }

  @Override
  public void attackedByKnife() {
    this.life-=5-this.dp;
    if (this.life <=0) {
      this.status = false;
      c.firePropertyChange("StatusCharacter",true, false);
    }
  }

  @Override
  public void attackedBySword() {
    this.life-= 15-this.dp;
    if (this.life <=0) {
      this.status = false;
      c.firePropertyChange("StatusCharacter",true, false);
    }
  }

  @Override
  public void attackedByStaff() {
    this.life-= 5-this.dp;
    if (this.life <=0) {
      this.status = false;
      c.firePropertyChange("StatusCharacter",true, false);
    }
  }
  public abstract void attackedByEnemy();
}
