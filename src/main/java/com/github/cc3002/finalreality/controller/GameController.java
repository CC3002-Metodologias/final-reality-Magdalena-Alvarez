package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.controller.phases.Phase;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.character.player.Mage.Black_Mage;
import com.github.cc3002.finalreality.model.character.player.Mage.White_Mage;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {
    private List<IPlayer> party = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();
    private List<IWeapon> inventory = new ArrayList<>();
    private int numPlayers = 0;
    private int numenemies = 0;
    private int maxPlayers = 5;
    private int alivePlayers = 0;
    private int maxenemies = 8;
    private int aliveenemies =0;
    private final BlockingQueue<ICharacter> turns;
    private boolean result;
    private final PlayerHandler pHandler = new PlayerHandler(this);
    private final EnemyHandler eHandler = new EnemyHandler(this);
    private Phase phase;

    /**
     * create a new controller.
     */
    public GameController() {
        this.turns = new LinkedBlockingQueue<>();
    }
    /**
     * get the game's result.
     * @return
     *      true you win, false if ypu lose
     */
    public boolean getResult(){return result;}

    /**
     * Creates a new Black Mage and adds to the player list unless the max. players is reached
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
     * creates a new Engineer and adds to the player list unless the max. players is reached
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
     * creates a new Knight and adds to the player list unless the max. players is reached
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

    /**
     * creates a new Thief and adds to the player list unless the max. players is reached
     * @param name
     *      name for new Thief
     */
    public void createThief(String name){
        if (numPlayers<maxPlayers){
            var player = new Thief(name, turns);
            party.add(player);
            player.addListener(pHandler);
            alivePlayers+=1;
        }
        numPlayers+=1;
    }

    /**
     * creates a new White Mage and add to the player list unless the max. players is reached
     * @param name
     *      name for the new White Mage
     */
    public void createWhiteMage(String name){
        if (numPlayers<maxPlayers){
            var player = new White_Mage(name, turns);
            party.add(player);
            player.addListener(pHandler);
            alivePlayers+=1;
        }
        numPlayers+=1;
    }

    /**
     * creates a new Axe and adds to the inventory
     * @param name
     *      name for the Axe
     */
    public void createAxe(String name){
        inventory.add(new AxeWeapon(name));
    }

    /**
     * creates a new Bow and adds to the inventory 
     * @param name
     *      name for the bow
     */
    public void createBow(String name){
        inventory.add(new BowWeapon(name));
    }

    /**
     * creates a new Knife and adds to the inventory
     * @param name
     *      name for the knife
     */
    public void createKnife(String name){
        inventory.add(new KnifeWeapon(name));
    }

    /**
     * creates a new staff and adds to the inventory
     * @param name
     * name for the staff
     */
    public void createStaff(String name){
        inventory.add(new StaffWeapon(name));
    }

    /**
     * creates a new sword and adds to the inventory
     * @param name
     *      name for the sword
     */
    public void createSword(String name){
        inventory.add(new SwordWeapon(name));
    }

    /**
     * creates a new enemy and adds to the enemy list unless the max. enemy is reached
     * @param name
     *      name for the enemy
     * @param weight
     *      weight for the enemy 
     */
    public void createEnemy(String name, int weight){
        if (numenemies<maxenemies){
            var enemy = new Enemy(name, weight, turns);
            enemies.add(enemy);
            enemy.addListener(eHandler);
            aliveenemies+=1;
        }
        numenemies+=1;
    }

    /**
     * returns the player in the i position of the party
     * @param i
     *      index
     * @return
     *      i-th player
     */
    public IPlayer getPlayer(int i){
        return party.get(i);
    }

    /**
     * returns player's equipped weapon
     * @param player
     * @return
     *      equipped weapon
     */
    public IWeapon getEquippedWeapon(IPlayer player){
        return player.getEquippedWeapon();
    }

    /**
     * returns i-weapon's name
     * @param i
     *      weapon's number
     * @return
     *      i-weapon's name
     */
    public String getWeaponName(int i){
        return inventory.get(i).getName();
    }

    /**
     * returns the number of players
     * @return
     *      number of player
     */
    public int getNumPlayers(){return numPlayers;}

    /**
     * returns the number of alive players
     * @return
     *      number of player that are not dead
     */
    public int getAlivePlayers(){return alivePlayers;}

    /**
     * returns the number of enemies
     * @return
     *      number of enemies
     */
    public int getNumenemies(){return numenemies;}

    /**
     * returns the number of alive enemies
     * @return
     *      number of enemies that are not dead
     */
    public int getAliveEnemies() {
        return aliveenemies;
    }

    /**
     * returns the user's party 
     * @return
     *      list of players
     */
    public List<IPlayer> getParty(){
        return List.copyOf(this.party);
    }

    /**
     * returns the enemy in i position
     * @param i
     *      index
     * @return
     *      i-th enemy
     */
    public Enemy getEnemy(int i){
        return enemies.get(i);
    }

    /**
     * returns the character's life points
     * @param character
     * @return
     *      character's life points
     */
    public int getCharacterLife(ICharacter character){
        return character.getLife();
    }

    /**
     * returns the character's defense points
     * @param character
     * @return
     *      character's defense points
     */
    public int getCharacterDp(ICharacter character){
        return character.getDp();
    }

    /**
     * returns the character's status
     * @param character
     * @return
     *      true if it's alive, false if not
     */
    public boolean getCharacterStatus(ICharacter character){
        return character.getStatus();
    }

    /**
     * returns the character's name
     * @param character
     * @return
     *      character's name
     */
    public String getCharacterName(ICharacter character){
        return character.getName();
    }

    /**
     * returns the enemy's attack points
     * @param enemy
     * @return
     *      enemy's attack points
     */
    public int getEnemyAttack(Enemy enemy){
        return enemy.getAttack_points();
    }

    /**
     * returns enemy's weight
     * @param enemy
     * @return
     * enemy's weight
     */
    public int getWeight(Enemy enemy){
        return enemy.getWeight();
    }

    /**
     * returns the weapon in i position in the inventory
     * @param i
     * index
     * @return
     *      i-th weapon
     */
    public IWeapon getFromInventory(int i){
        return inventory.get(i);
    }

    public List<IWeapon> getInventory() {
        return List.copyOf(inventory);
    }

    /**
     * equips the i-th weapon to the player
     * @param player
     * player to equip the weapon
     * @param i
     * index
     */
    public void equip(IPlayer player, int i){
        player.equip(inventory.get(i));
    }

    /**
     * make a character attacks another character
     * @param attacker
     *      character that attacks
     * @param victim
     *      character tha is attacked
     */
    public void attack(ICharacter attacker, ICharacter victim){
        attacker.attack(victim);
    }

    /**
     * when a player dies subtracts 1 to the alive players. If all players are dead, you lose
     */
    public void deadPlayer(){
        alivePlayers-=1;
        if (alivePlayers==0){
            result =false;
        }
    }

    /**
     * when a enemy dies subtracts 1 to the alive enemies. If all enemies are dead you win.
     */
    public void deadEnemy(){
        aliveenemies-=1;
        if (aliveenemies<=0){
            result =true;
        }
    }

    /**
     * starts the game making all the character wait for their turn
     */
    public void startGame(){
        for (int i=0; i<5; i++){
            createEnemy("Enemy"+i, 2*(i+1)+5);
        }
        for (int i=0; i<party.size();i++) {
            getPlayer(i).waitTurn();
        }
        for(int i = 0; i<enemies.size();i++){
            getEnemy(i).waitTurn();
        }
    }

    /**
     * when a turn starts gets out of the queue the first character, and returns it
     * @return
     *      first character in the turn queue
     */
    public ICharacter startTurn(){
        return turns.poll();
    }

    /**
     * when a turn ends make the character waits it's turn
     * @param character
     */
    public void endTurn(ICharacter character){
        if (character.getStatus()) {
            character.waitTurn();
        }
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
        phase.setController(this);
    }
}
