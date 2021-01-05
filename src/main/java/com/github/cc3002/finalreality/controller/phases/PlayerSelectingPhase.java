package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

public class PlayerSelectingPhase extends Phase {

    /**
     * creates a new player selection phase
     */
    public PlayerSelectingPhase(){
    }
    @Override
    public void setTarget(ICharacter enemy) {
        this.target= enemy;
        toAttackPhase();
    }

    @Override
    public void toAttackPhase() {
        changePhase(new AttackPhase(target));
    }
}
