package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.IPlayer;

import java.util.Random;

public class EnemySelectingPhase extends Phase{
    private final Enemy playingChar;
    private Random randNum = new Random(1234);
    private int num = randNum.nextInt();
    private IPlayer target = controller.getPlayer(num);


    public EnemySelectingPhase(Enemy playingChar) {
        this.playingChar = playingChar;
    }

    @Override
    public void toAttackPhase() {
        changePhase(new AttackPhase(target, playingChar));
    }
}
