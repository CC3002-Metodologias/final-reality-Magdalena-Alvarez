package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

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
}
