package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.StaffWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Black_Mage extends PlayerCharacter {
    protected int mana;
    protected int Mage_mana = 100;
    public Black_Mage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, turnsQueue, CharacterClass.BLACK_MAGE);
        this.mana = Mage_mana;
    }

    public void equipStaff(String staff_name){
        this.equippedWeapon = new StaffWeapon(staff_name);
    }
}
