package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.Objects;

public abstract class Phase implements IPhase{
    protected GameController controller;
    protected ICharacter character;

    public void setController (GameController c){
        this.controller = c;
        this.character = null;
    }

    @Override
    public void setCharacter(ICharacter character) {
        this.character=character;
    }
    @Override
    public void changePhase(IPhase phase){
        controller.setPhase(phase);
        character.setState(phase);
        //phase.setController(controller);
        phase.setCharacter(character);

    }

    @Override
    public void attack() {
    }

    @Override
    public void toDecisionPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("You can't go to Decision from here");
    }
    @Override
    public void toEnemySelectingPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("You can't go to Enemy Selection from here");
    }
    @Override
    public void toStartTurnPhase() throws InvalidTransitionException {throw new InvalidTransitionException("You can't go to Start turn from here");}
    @Override
    public void toAttackPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("You can't go to Attack from here");
    }
    @Override
    public void toEndTurnPhase() throws InvalidTransitionException {throw new InvalidTransitionException("You can't go to end turn from here");}
    @Override
    public void toPlayerSelectingPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("You can't go to Player selection from here");
    }

    @Override
    public void toWaitingPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("You can't go to Waiting from here");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phase phase = (Phase) o;
        return Objects.equals(controller, phase.controller) && Objects.equals(character, phase.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(controller, character);
    }

    @Override
    public void equipFromTheInventory() throws InvalidMethodException {
        throw new InvalidMethodException("You can't equip from the inventory in this phase");
    }

    @Override
    public void setTarget(ICharacter enemy) throws InvalidMethodException {
        throw new InvalidMethodException("You can't set the target in this phase");
    }

    public void setNumber(int i) throws InvalidMethodException {
        throw new InvalidMethodException("You can't set the number in this phase");
    }

    @Override
    public void endTurn() throws InvalidMethodException {
        throw new InvalidMethodException("You can't end the turn in this phase");
    }
}
