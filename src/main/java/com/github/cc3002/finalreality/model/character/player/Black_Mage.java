package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.KnifeWeapon;
import com.github.cc3002.finalreality.model.weapon.StaffWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Black_Mage extends AbstractPlayerCharacter {
    protected int mana;
    protected int Mage_mana = 100;
    /**
     * Creates a new character that it's class is black mage.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     */
    public Black_Mage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.BLACK_MAGE);
        this.mana = Mage_mana;
    }

    @Override
    public void equip(IWeapon weapon) {
        if (this.status){
            weapon.equippedByBlack_Mage(this);
        }
    }

    /**
     * returns mage's mana
     * @return
     *      mage's mana
     */
    public int getMana() {
        return mana;
    }

}
