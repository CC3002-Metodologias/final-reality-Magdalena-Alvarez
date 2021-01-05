package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.controller.phases.IPhase;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;


/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author <Magdalena Álvareze>
 */
public interface ICharacter {
    /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's class.
   */
  CharacterClass getCharacterClass();

  /**
   * Returns the character's life points
   */
  int getLife();

  /**
   * Returns the character's defense points
   */
  int getDp();

  /**
   *Returns the character's status
   * true if it's alive, false if not
   */
  boolean getStatus();

  /**
   * Returns the characters's turn phase
   * @return
   */
  IPhase getPhase();

  /**
   * Attacks a character
   * @param character
   *  character to attach
   */

  void attack(ICharacter character);

  /**
   * Descontar el ataque del hacha a los puntos de vida
   */
  void attackedByAxe();
  /**
   * Descontar el ataque del arco a los puntos de vida
   */
  void attackedByBow();
  /**
   * Descontar el ataque del cuchillo a los puntos de vida
   */
  void attackedByKnife();
  /**
   * Descontar el ataque de la espada a los puntos de vida
   */
  void attackedBySword();
  /**
   * Descontar el ataque del baston a los puntos de vida
   */
  void attackedByStaff();
  /**
   * Descontar el ataque del enemigo a los puntos de vida
   */
  void attackedByEnemy();

  /**
   * Set character's turn phase
   */
  void setState(IPhase phase);

  /**
   * the character decide what to do.
   */
  void decision();

  /**
   * returns if the character is player or not
   * @return
   *    true if it is, false if it isn't
   */
  boolean isPlayerCharacter();
}
