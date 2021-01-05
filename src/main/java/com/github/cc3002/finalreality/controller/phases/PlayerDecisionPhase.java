package com.github.cc3002.finalreality.controller.phases;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

public class PlayerDecisionPhase extends Phase{

    /**
     * creates a new player decision phase
     */
    public PlayerDecisionPhase() {
    }
    @Override
    public void setNumber(int i) {
        this.number =i;
    }
    @Override
    public void equipFromTheInventory() {
        IPlayer player = (IPlayer) character;
        controller.equip(player,number);
    }
    @Override
    public void toPlayerSelectingPhase() {
        changePhase(new PlayerSelectingPhase());
    }
}
