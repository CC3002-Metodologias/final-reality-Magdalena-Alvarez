package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Magdalena Álvarez>
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  private final int attack_points;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight,
      @NotNull final BlockingQueue<ICharacter> turnsQueue) {
    super(turnsQueue, name, CharacterClass.ENEMY);
    this.weight = weight;
    this.attack_points = 15;
    this.dp = 4;
    this.life = 30;
  }

  /**
   * Returns the weight of this enemy.
   * @return
   *    enemy's weight
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor
            .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }

  /**
   * Returns the enemy's attack points
   * @return
   *    attack points
   */
  public int getAttack_points() {
    return attack_points;
  }

  @Override
  public void attack(ICharacter character){
    if (this.status) {
      character.attackedByEnemy();
    }
  }

  @Override
  public void attackedByEnemy() {
  }

  @Override
  public void decision() {
    state.toEnemySelectingPhase();
    state.toAttackPhase();
    state.attack();
    state.endTurn();

  }

  @Override
  public boolean isPlayerCharacter() {
    return false;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight()
            && getAttack_points()==enemy.getAttack_points();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight(),getAttack_points());
  }
}
