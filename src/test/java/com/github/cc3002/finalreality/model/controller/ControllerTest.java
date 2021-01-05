package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.controller.phases.IPhase;
import com.github.cc3002.finalreality.controller.phases.PlayerDecisionPhase;
import com.github.cc3002.finalreality.controller.phases.StartTurnPhase;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    private final Random index = new Random(4234);
    private final GameController c = new GameController();
    private final String BlackMageName = "Mage 1";
    private final String EnemyName = "Enemy";
    private final String EngineerName = "Engie";
    private final String KnightName = "John";
    private final String ThiefName = "Luke";
    private final String WhiteMageName = "Mage 2";
    private final String AxeName = "Super Axe";
    private final String BowName = "Super Bow";
    private final String KnifeName = "Super Knife";
    private final String StaffName = "Super Staff";
    private final String SwordName = "Super Sword";

    @BeforeEach
    void set_Up(){
        c.createBlackMage(BlackMageName);
        c.createEngineer(EngineerName);
        c.createKnight(KnightName);
        c.createThief(ThiefName);
        c.createWhiteMage(WhiteMageName);
        for (int i =0; i<3;i++){
            String name=EnemyName+ String.valueOf(i);
            c.createEnemy(name,15);
        }
        c.createStaff(StaffName);
        c.createAxe(AxeName);
        c.createBow(BowName);
        c.createKnife(KnifeName);
        c.createSword(SwordName);

    }

    @Test
    void playerTest(){
        ICharacter player1 = c.getPlayer(0);
        assertEquals(c.getCharacterName(player1),BlackMageName);
        int expected_life = 50;
        assertEquals(c.getCharacterLife(player1),expected_life);
        int expected_dp = 5;
        assertEquals(c.getCharacterDp(player1),expected_dp);
        assertTrue(c.getCharacterStatus(player1));
        c.createKnight(EnemyName);
        c.createEngineer(EnemyName);
        c.createBlackMage(EnemyName);
        c.createThief(EnemyName);
        c.createWhiteMage(EnemyName);
        assertEquals(c.getParty().size(),5);
        assertEquals(c.getNumPlayers(),10);
    }
    @Test
    void enemyTest(){
        ICharacter enemy1 =c.getEnemy(0);
        String expected_name=EnemyName+ String.valueOf(0);
        assertEquals(c.getCharacterName(enemy1),expected_name);
        int expected_weight = 15;
        assertEquals(c.getWeight((Enemy) enemy1),expected_weight);
        int expected_AP = 15;
        assertEquals(c.getEnemyAttack((Enemy) enemy1),expected_AP);
    }
    @Test
    void inventoryTest(){
        IPlayer player1 = c.getPlayer(0);
        c.equip(player1,0);
        assertEquals(c.getEquippedWeapon(player1),c.getFromInventory(0));
    }
    private void starGame(){
        c.equip(c.getPlayer(0),3);
        c.equip(c.getPlayer(1),1);
        c.equip(c.getPlayer(2),4);
        c.equip(c.getPlayer(3),2);
        c.equip(c.getPlayer(4),0);
        c.startGame();
    }
    @Test
    void gameTestVictory() throws InterruptedException {
        starGame();
        for (int i = 0; i<c.getNumenemies();i++){
            while (c.getCharacterStatus(c.getEnemy(i))) {
                Thread.sleep(1200);
                c.startTurn();
                ICharacter playingCharacter = c.getPlayingChar();
                c.attack(playingCharacter,c.getEnemy(i));
                c.endTurn(playingCharacter);
            }
        }
        assertTrue(c.getResult());

    }
    @Test
    void gameTestDefeat() throws InterruptedException {
        starGame();
        for (int i = 0; i<c.getNumPlayers();i++){
            while (c.getCharacterStatus(c.getPlayer(i))) {
                Thread.sleep(1200);
                c.startTurn();
                ICharacter playingCharacter = c.getPlayingChar();
                c.attack(playingCharacter,c.getPlayer(i));
                c.endTurn(playingCharacter);
            }
        }
        assertFalse(c.getResult());

    }
    void oneTurn(ICharacter playingChar){
        IPhase expectedStart = new StartTurnPhase();
        expectedStart.setController(c);
        expectedStart.setCharacter(playingChar);
        assertEquals(expectedStart, c.getPhase());
        assertEquals(expectedStart,playingChar.getPhase());
        expectedStart.setController(new GameController());
        assertNotEquals(expectedStart,c.getPhase());
        c.toDecision(playingChar);
        if (playingChar.isPlayerCharacter()){
            IPhase expectedPhase = new PlayerDecisionPhase();
            expectedPhase.setController(c);
            expectedPhase.setCharacter(c.getPlayingChar());
            assertEquals(expectedPhase,c.getPhase());
            assertEquals(expectedPhase,c.getPlayingChar().getPhase());
            c.goToInventory(2);
            c.goToInventory(4);
            c.selectTarget(c.getEnemy(3));
            c.toAttack();
        }
        assertNotEquals(expectedStart,c.getPhase());
    }
    @Test
    void gameTurnTest() throws InterruptedException {
        starGame();
        Thread.sleep(1200);
        c.startTurn();
        ICharacter playingChar = c.getPlayingChar();
        oneTurn(playingChar);
        c.startTurn();
        playingChar = c.getPlayingChar();
        oneTurn(playingChar);
        c.startTurn();
        playingChar = c.getPlayingChar();
        oneTurn(playingChar);
        c.startTurn();
        playingChar = c.getPlayingChar();
        oneTurn(playingChar);
        c.startTurn();
        playingChar = c.getPlayingChar();
        oneTurn(playingChar);
        c.startTurn();
        playingChar = c.getPlayingChar();
        oneTurn(playingChar);


    }
}
