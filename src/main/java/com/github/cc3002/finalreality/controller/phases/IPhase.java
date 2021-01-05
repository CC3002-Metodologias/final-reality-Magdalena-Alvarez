package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

public interface IPhase {

    void setController (GameController controller);
    void setCharacter(ICharacter character);
    void changePhase(IPhase phase);


    void toDecisionPhase() throws InvalidTransitionException;
     void toEnemySelectingPhase() throws InvalidTransitionException;
     void toStartTurnPhase() throws InvalidTransitionException;
     void toAttackPhase() throws InvalidTransitionException;
     void toEndTurnPhase() throws InvalidTransitionException;
     void toPlayerSelectingPhase() throws InvalidTransitionException;

    void equipFromTheInventory() throws InvalidMethodException;

    void setTarget(ICharacter enemy) throws InvalidMethodException;

    void toWaitingPhase() throws InvalidTransitionException;

    void setNumber(int i) throws InvalidMethodException;

    void attack();

    void endTurn() throws InvalidMethodException;
}
