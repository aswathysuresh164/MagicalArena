package com.swiggy;

import lombok.Data;
import lombok.extern.java.Log;


/**
 *This class represents a player in the  game
 */
@Log
@Data
public class Player {

    private int health;
    private int strength;
    private int attack;

    public boolean isAlive() {
        return this.health > 0;
    }



}

