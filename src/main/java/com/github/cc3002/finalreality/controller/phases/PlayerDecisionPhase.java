package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.character.player.Mage.IMages;

public class PlayerDecisionPhase extends Phase{
    private int number;
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
        //for ( IPlayer p: controller.getParty()) {
          //  if(p.equals(player)) {
            //    int index = controller.getParty().indexOf(p);
              //  controller.equip(controller.getPlayer(index), number);
                //controller.equip(player,number);
            //}
       // }
    }

    @Override
    public void toPlayerSelectingPhase() {
        changePhase(new PlayerSelectingPhase());
    }
}
