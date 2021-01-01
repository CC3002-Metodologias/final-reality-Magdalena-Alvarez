package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.character.player.Mage.IMages;

public class InventoryPhase extends Phase {
    private final IPlayer playingChar;
    protected int num;

    public InventoryPhase(IPlayer playingChar) {
     this. playingChar = playingChar;
    }
    public void setNum(int number){
        this.num = number;
    }
    public void setEquip(){
        controller.equip(playingChar,num);
    }

    @Override
    public void toPlayerSelectingPhase() {
        changePhase(new PlayerSelectingPhase(playingChar));
    }

    @Override
    public void toMagicState() {
        changePhase(new MagicState((IMages)playingChar));
    }
}
