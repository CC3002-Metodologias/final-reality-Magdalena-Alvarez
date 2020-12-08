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
    private List<IPlayer> party = new ArrayList<>();
    private List<Enemy> enemys = new ArrayList<>();
    public List<IWeapon> inventory = new ArrayList<>();
    private int numPlayers = 0;
    private int numEnemys = 0;
    private int maxPlayers = 5;
    private int alivePlayers = 0;
    private int maxEnemys = 10;
    private int aliveEnemys =0;
    private final BlockingQueue<ICharacter> turns;
    private boolean result;
    private final PlayerHandler pHandler = new PlayerHandler(this);
    private final EnemyHandler eHandler = new EnemyHandler(this);

    /**
     * create a new controller.
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     */
    public GameController(@NotNull BlockingQueue<ICharacter> turnsQueue) {
        this.turns = turnsQueue;
    }
    /**
     * get the game's result.
     * @return
     *      true you win, false if ypu lose
     */
    public boolean getResult(){return result;}

    /**
     * Creates a new Black Mage and adds to the player list
     * @param name
     *      name for the new Black Mage
     */
    public void createBlackMage(String name){
        if (numPlayers<maxPlayers){
            var player = new Black_Mage(name, turns);
            party.add(player);
            player.addListener(pHandler);
            alivePlayers+=1;
        }
        numPlayers+=1;
    }

    /**
     * creates a new Engineer and adds to the player list
     * @param name
     *      name for the new Engineer
     */
    public void createEngineer(String name){
        if (numPlayers<maxPlayers){
            var player = new Engineer(name, turns);
            party.add(player);
            player.addListener(pHandler);
            alivePlayers+=1;
        }
        numPlayers+=1;
    }

    /**
     * creates a new Knight and adds to the player list until reaching the 
     * @param name
     *      name for new Knight
     */
    public void createKnight(String name){
        if (numPlayers<maxPlayers){
            var player = new Knight(name, turns);
            party.add(player);
            player.addListener(pHandler);
            alivePlayers+=1;
        }
        numPlayers+=1;
    }
    public void createThief(String name){
        if (numPlayers<maxPlayers){
            var player = new Thief(name, turns);
            party.add(player);
            player.addListener(pHandler);
            alivePlayers+=1;
        }
        numPlayers+=1;
    }
    public void createWhiteMage(String name){
        if (numPlayers<maxPlayers){
            var player = new White_Mage(name, turns);
            party.add(player);
            player.addListener(pHandler);
            alivePlayers+=1;
        }
        numPlayers+=1;
    }
    public void createAxe(String name){
        inventory.add(new AxeWeapon(name));
    }
    public void createBow(String name){
        inventory.add(new BowWeapon(name));
    }
    public void createKnife(String name){
        inventory.add(new KnifeWeapon(name));
    }
    public void createStaff(String name){
        inventory.add(new StaffWeapon(name));
    }
    public void createSword(String name){
        inventory.add(new SwordWeapon(name));
    }
    public void createEnemy(String name, int weight){
        if (numEnemys<maxEnemys){
            var enemy = new Enemy(name, weight, turns);
            enemys.add(enemy);
            enemy.addListener(eHandler);
            aliveEnemys+=1;
        }
        numEnemys+=1;
    }
    public IPlayer getPlayer(int i){
        return party.get(i);
    }
    public IWeapon getEquippedWeapon(IPlayer player){
        return player.getEquippedWeapon();
    }
    public int getNumPlayers(){return numPlayers;}
    public int getNumEnemys(){return numEnemys;}
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
    public IWeapon getFromInventory(int i){
        return inventory.get(i);
    }
    public void equip(IPlayer player, int i){
        player.equip(inventory.get(i));
    }
    public void attack(ICharacter attacker, ICharacter victim){
        attacker.attack(victim);
    }
    public void deadPlayer(){
        alivePlayers-=1;
        if (alivePlayers==0){
            result =false;
        }
    }
    public void deadEnemy(){
        aliveEnemys-=1;
        if (aliveEnemys<=0){
            result =true;
        }
    }
    public void startGame(){
        for (int i=0; i<party.size();i++){
            getPlayer(i).waitTurn();
        }
        for(int i = 0; i<enemys.size();i++){
            getEnemy(i).waitTurn();
        }
    }
    public ICharacter startTurn(){
        return turns.poll();
    }
    public void endTurn(ICharacter character){
        character.waitTurn();
    }
}
