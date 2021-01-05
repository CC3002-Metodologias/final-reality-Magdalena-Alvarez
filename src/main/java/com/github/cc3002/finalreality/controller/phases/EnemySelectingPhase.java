package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

import java.util.Random;

public class EnemySelectingPhase extends Phase{
    private final Random randNum = new Random();
    /**
     * creates a new enemy selection phase
     */
    public EnemySelectingPhase(){
    }
    private  IPlayer selPlayer(){
        this.number = randNum.nextInt(5);
        if (!controller.getCharacterStatus(controller.getPlayer(number))){
            return selPlayer();
        }
        else {
            return controller.getPlayer(number);
        }
    }
    @Override
    public void toAttackPhase() {
        this.target= selPlayer();
        changePhase(new AttackPhase(target));
    }
}
