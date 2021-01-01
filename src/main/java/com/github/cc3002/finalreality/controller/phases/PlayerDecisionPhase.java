package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.character.player.Mage.IMages;

public class PlayerDecisionPhase extends Phase{
    private final IPlayer playingChar;

    public PlayerDecisionPhase(ICharacter playingChar) {
        this.playingChar = (IPlayer) playingChar;
    }

    @Override
    public void toMagicState() {
        changePhase(new MagicState((IMages) playingChar));
    }

    @Override
    public void toInventoryState() {
        changePhase(new InventoryPhase(playingChar));
    }

    @Override
    public void toPlayerSelectingPhase() {
        super.toPlayerSelectingPhase();
    }
}
