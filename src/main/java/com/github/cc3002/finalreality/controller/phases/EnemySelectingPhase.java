package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

import java.util.Random;

public class EnemySelectingPhase extends Phase{
    private Random randNum = new Random(1234);
    private int num ;
    private IPlayer target;


    public EnemySelectingPhase(){

    }
    private  void selPlayer(){
        num = randNum.nextInt(5);
        target = controller.getPlayer(num);
        if (!controller.getCharacterStatus(target)){
            selPlayer();
        }
    }
    @Override
    public void toAttackPhase() {
        selPlayer();
        changePhase(new AttackPhase(target));
    }
}
