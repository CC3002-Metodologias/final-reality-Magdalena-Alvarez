package com.github.cc3002.finalreality.model.character.player;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class White_Mage extends AbstractPlayerCharacter{
    protected int mana;
    protected int Mage_mana = 100;

    /**
     * Creates a new character that it's class is white mage.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     */
    public White_Mage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.WHITE_MAGE);
        this.mana = Mage_mana;
    }

    @Override
    public void equip(IWeapon weapon) {
        if (this.status){
            weapon.equippedByWhite_Mage(this);
        }
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof White_Mage)) {
            return false;
        }
        final White_Mage that = (White_Mage) o;
        return getCharacterClass() == that.getCharacterClass()
                && getName().equals(that.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass(), getName());
    }

}
