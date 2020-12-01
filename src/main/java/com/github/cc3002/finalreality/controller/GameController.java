package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class GameController {
    public List<IPlayer> party = new ArrayList<>();
    private int numPlayers = 0;
    private int maxPlayers = 5;
    private BlockingQueue<ICharacter> turns;
    public GameController( @NotNull BlockingQueue<ICharacter> turnsQueue) {
        this.turns = turnsQueue;
    }

    public void createBlackMage(String name){
        if (numPlayers<maxPlayers){
            party.add(new Black_Mage(name, turns));
            numPlayers+=1;
        }
    }
    public void createEngineer(String name){
        if (numPlayers<maxPlayers){
            party.add(new Engineer(name, turns));
            numPlayers+=1;
        }
    }
    public void createKnight(String name){
        if (numPlayers<maxPlayers){
            party.add(new Knight(name, turns));
            numPlayers+=1;
        }
    }
    public void createThief(String name){
        if (numPlayers<maxPlayers){
            party.add(new Thief(name, turns));
            numPlayers+=1;
        }
    }
    public void createWhiteMage(String name){
        if (numPlayers<maxPlayers){
            party.add(new White_Mage(name, turns));
            numPlayers+=1;
        }
    }
}
