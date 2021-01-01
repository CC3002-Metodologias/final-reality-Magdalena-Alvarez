package com.github.cc3002.finalreality.model.character.player.Mage;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Black_Mage extends AbstractPlayerCharacter implements IMages{
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

    public int getMana() {
        return mana;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Black_Mage)) {
            return false;
        }
        final Black_Mage that = (Black_Mage) o;
        return getCharacterClass() == that.getCharacterClass()
                && getName().equals(that.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass(), getName());
    }
}