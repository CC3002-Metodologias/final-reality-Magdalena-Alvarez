package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

import java.util.Random;

public class EnemySelectingPhase extends Phase{
    private Random randNum = new Random();
    private int num ;
    private IPlayer target;


    public EnemySelectingPhase(){

    }
    private  IPlayer selPlayer(){
        num = randNum.nextInt(5);

        if (!controller.getCharacterStatus(controller.getPlayer(num))){
            return selPlayer();
        }
        else {
            return controller.getPlayer(num);
        }
    }
    @Override
    public void toAttackPhase() {
        target= selPlayer();
        changePhase(new AttackPhase(target));
    }
}
