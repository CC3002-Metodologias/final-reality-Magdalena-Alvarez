package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

public class AttackPhase extends Phase {
    private ICharacter target;

    public AttackPhase(ICharacter target) {
        this.target = target;

    }
    public void attack(){
        if (controller.getCharacterStatus(target)) {
            controller.attack(character, target);
        }
        toEndTurnPhase();
    }
    @Override
    public void toEndTurnPhase() {
        changePhase(new EndTurnPhase());
    }
}
