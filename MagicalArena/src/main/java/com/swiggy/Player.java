package com.swiggy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.UUID;


/**
 *This class represents a player in the  game
 */
@Log
@Data
@AllArgsConstructor
public class Player {
    private UUID id; // Unique identifier for the player
    private int health;
    private int strength;
    private int attack;

    /**
     * To check the player is alive or not
     * @return true/false
     */
    public boolean isAlive() {
        return this.health > 0;
    }

    /**
     *  To reduce the health of the player
     */
    public void reduceHealth(int damage) {
        this.health -= damage;
        log.info("Player with id -" + id + "Health is  reduced to " + health);
    }
}

