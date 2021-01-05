package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

public interface IPhase {

    void setController (GameController controller);
    void setCharacter(ICharacter character);
    void changePhase(IPhase phase);


    void toDecisionPhase();
     void toEnemySelectingPhase();
     void toStartTurnPhase();
     void toAttackPhase();
     void toEndTurnPhase();
     void toMagicState();
     void toInventoryState();
     void toPlayerSelectingPhase();

    void equipFromTheInventory();

    void setTarget(ICharacter enemy);

    void toWaitingPhase();

    void setNumber(int i);

    void attack();

    void endTurn();
}
