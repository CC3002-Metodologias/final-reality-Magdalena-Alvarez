package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.*;

import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;


/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see AbstractPlayerCharacter
 */
class AbstractPlayerCharacterTest extends AbstractCharacterTest {

    protected void checkEquippedWeapon(IPlayer character, IWeapon weapon) {
        assertNull(character.getEquippedWeapon());
        character.equip(weapon);
        assertEquals(weapon, character.getEquippedWeapon());
    }
    protected void checkAttack(IPlayer player, IWeapon weapon, ICharacter enemy){
        int previous_life = enemy.getLife();
        player.attack(enemy);
        Assertions.assertEquals(previous_life, enemy.getLife());
        player.equip(weapon);
        player.attack(enemy);
        Assertions.assertEquals(previous_life-enemy.getLife(), player.getEquippedWeapon().getDamage()-enemy.getDp());
        while(enemy.getStatus()){
            player.attack(enemy);
        }
        Assertions.assertFalse(enemy.getStatus());
    }
    protected void checkDead(IPlayer player, IWeapon weapon,ICharacter enemy){
        while(player.getStatus()){
            enemy.attack(player);
        }
        var expectedWeapon = player.getEquippedWeapon();
        player.equip(weapon);
        assertEquals(player.getEquippedWeapon(),expectedWeapon);
    }
}
