package com.github.cc3002.finalreality.model;

import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Game {

    public List<PlayerCharacter> party = new ArrayList<>();

    public void addPlayerCharacter (PlayerCharacter p_character){
        if (party.size() < 5){
            party.add(p_character);
        }
    }
    @Override
    public boolean equals(final Object obj){
        return obj instanceof Game;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Game.class);
    }



    public void setParty(List<PlayerCharacter> party) {
        this.party = party;
    }

    public List <PlayerCharacter> getParty() {
        return List.copyOf( party);
    }
}
