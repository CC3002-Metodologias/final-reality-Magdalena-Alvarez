package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class GameController {
    public List<IPlayer> party = new ArrayList<>();
    public List<Enemy> enemys = new ArrayList<>();
    public List<IWeapon> inventary = new ArrayList<>();
    private int numPlayers = 0;
    private int numEnemys = 0;
    private int maxPlayers = 5;
    private int maxEnemys = 10;
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
    public void createAxe(String name){
        inventary.add(new AxeWeapon(name));
    }
    public void createBow(String name){
        inventary.add(new BowWeapon(name));
    }
    public void createKnife(String name){
        inventary.add(new KnifeWeapon(name));
    }
    public void createStaff(String name){
        inventary.add(new StaffWeapon(name));
    }
    public void createSword(String name){
        inventary.add(new SwordWeapon(name));
    }
    public void createEnemy(String name, int weight){
        if (numEnemys<maxEnemys){
            enemys.add(new Enemy(name, weight, turns));
        }
    }
    public IPlayer getPlayer(int i){
        return party.get(i);
    }
    public List<IPlayer> getParty(){
        return this.party;
    }
    public Enemy getEnemy(int i){
        return enemys.get(i);
    }
    public int getCharacterLife(ICharacter character){
        return character.getLife();
    }
    public int getCharacterDp(ICharacter character){
        return character.getDp();
    }
    public boolean getCharacterStatus(ICharacter character){
        return character.getStatus();
    }
    public String getCharacterName(ICharacter character){
        return character.getName();
    }
    public int getEnemyAttack(Enemy enemy){
        return enemy.getAttack_points();
    }
    public int getWeight(Enemy enemy){
        return enemy.getWeight();
    }
    public List<IWeapon> getInventary(){
        return this.inventary;
    }
    public void equip(IPlayer player, int i){
        player.equip(inventary.get(i));
    }
}
