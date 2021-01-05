package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

public interface IPhase {
    /**
     * sets a controller to the phase
     * @param controller
     *      controller to set
     */
    void setController (GameController controller);

    /**
     * sets a character to the phase
     * @param character
     *      character to set
     */
    void setCharacter(ICharacter character);

    /**
     * goes to a new phase and set the corresponding controller and character to the the new phase,
     * and set the new phase to that controller and character
     * @param phase
     *      new phase
     */
    void changePhase(IPhase phase);

    /**
     * changes current phase, if appropriate, to the decision phase
     */
    void toDecisionPhase() ;

    /**
     * changes the current phase, if appropriate, to the enemy's selection phase
     */
     void toEnemySelectingPhase() ;

    /**
     * changes the current phase, if appropriate, to start turn phase
     */
    void toStartTurnPhase() ;

    /**
     * changes the current phase, if appropriate, to attack phase
     */
     void toAttackPhase() ;

    /**
     * changes the current phase, if appropriate, to end turn phase
     */
    void toEndTurnPhase() ;

    /**
     *changes the current phase, if appropriate, to player selection phase
     */
     void toPlayerSelectingPhase();

    /**
     * changes the current phase, if appropriate, to waiting phase
     */
    void toWaitingPhase();

    /**
     * if your are in decision phase, you can equip a weapon to the character that is plating
     */
    void equipFromTheInventory();

    /**
     * sets a number to use it in the phase.
     * @param i
     *      the number value
     */
    void setNumber(int i) ;

    /**
     * sets a target to attack
     * @param enemy
     *      enemy to attack
     */
    void setTarget(ICharacter enemy);

    /**
     * attack the target
     */
    void attack();

    /**
     * finish the turn
     */
    void endTurn();
}
