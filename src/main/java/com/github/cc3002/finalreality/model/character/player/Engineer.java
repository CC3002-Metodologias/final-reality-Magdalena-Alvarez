package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Engineer extends AbstractPlayerCharacter{
    /**
     * Creates a new character that it's class is engineer.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     */
    public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.ENGINEER);
        this.dp =2;
    }

    @Override
    public void equip(IWeapon weapon) {
        if (this.status){
            weapon.equippedByEngineer(this);
        }
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Engineer)) {
            return false;
        }
        final Engineer that = (Engineer) o;
        return getCharacterClass() == that.getCharacterClass()
                && getName().equals(that.getName());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getCharacterClass(),getName());
    }
}
