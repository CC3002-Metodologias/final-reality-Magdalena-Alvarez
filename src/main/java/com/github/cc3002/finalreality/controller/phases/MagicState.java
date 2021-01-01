package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.Mage.IMages;

public class MagicState extends Phase {
    private final IMages playingChar;

    public MagicState(IMages playingChar) {
        this.playingChar = playingChar;
    }

    @Override
    public void toPlayerSelectingPhase() {
        changePhase(new PlayerSelectingPhase(playingChar));
    }

    @Override
    public void toInventoryState() {
        changePhase(new InventoryPhase(playingChar));
    }
}
