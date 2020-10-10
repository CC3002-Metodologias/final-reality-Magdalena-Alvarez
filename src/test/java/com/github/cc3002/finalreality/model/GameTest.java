package com.github.cc3002.finalreality.model;

import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    private Game testGame;
    @BeforeEach
    void setUp(){
        testGame = new Game();
    }

    @Test
    void playTest(){
        var expectedGame = new Game();
        assertEquals(expectedGame, testGame);
        assertEquals(expectedGame.hashCode(), testGame.hashCode());
    }

    @Test
    void partyTest(){
        assertTrue(testGame.getParty().isEmpty());
        for (int i = 0; i<5; i++){
            testGame.addPlayerCharacter(PlayerCharacter);
            assertEquals(i+1,testGame.getParty().size());
        }
        testGame.addPlayerCharacter( PlayerCharacter);
        assertEquals(5, testGame.getParty().size());
    }

}
