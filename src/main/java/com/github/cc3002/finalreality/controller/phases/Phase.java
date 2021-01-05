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
    public void toDecisionPhase(){
    }
    @Override
    public void toEnemySelectingPhase() {
    }
    @Override
    public void toStartTurnPhase(){}
    @Override
    public void toAttackPhase() {
    }
    @Override
    public void toEndTurnPhase() {
    }
    @Override
    public void toPlayerSelectingPhase() {
    }

    @Override
    public void toWaitingPhase() {
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
    public void equipFromTheInventory() {
    }

    @Override
    public void setTarget(ICharacter enemy) {
    }

    public void setNumber(int i) {
    }

    @Override
    public void endTurn()  {
    }
}
