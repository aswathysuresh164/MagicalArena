package com.swiggy;

import lombok.Data;
import lombok.extern.java.Log;
import lombok.AllArgsConstructor;

/**
 *This class  represents an arena where two players battle using dice rolls.
 */
@Log
@Data
@AllArgsConstructor
public class Arena {
    private Player firstPlayer;
    private Player secondPlayer;
    private Dice dice;

    /**
     * Starts the battle between the two players.
     */
    public void startBattle() {
        log.info("Battle starts between " + firstPlayer + " and " + secondPlayer);
        while (firstPlayer.isAlive() && secondPlayer.isAlive()) {
            if (firstPlayer.getHealth() <= secondPlayer.getHealth()) {
                takeTurn(firstPlayer, secondPlayer);
                if (secondPlayer.isAlive()) {
                    takeTurn(secondPlayer, firstPlayer);
                }
            }
            else {
                takeTurn(secondPlayer, firstPlayer);
                if (firstPlayer.isAlive()) {
                    takeTurn(firstPlayer, secondPlayer);
                }
            }
        }
        declareWinner();
    }

    /**
     * Handles a turn in the battle where one player attacks the other.
     *
     * @param attacker The attacking player
     * @param defender The defending player
     */
    private void takeTurn(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defendRoll = dice.roll();

        int damage = attacker.getAttack() * attackRoll - defender.getStrength() * defendRoll;

        if (damage > 0) {
            defender.reduceHealth(damage);
            log.info(attacker.getId() + " attacks " + defender.getId() + " for " + damage + " damage.");
        } else {
            log.info(defender.getId() + " defends successfully against " + attacker.getId() + ".");
        }
        log.info(defender.toString());
    }

    /**
     * Declares the winner of the battle.
     */
    private void declareWinner() {
        if (firstPlayer.isAlive()) {
            log.info(firstPlayer.getId() + " wins!");
        } else {
            log.info(secondPlayer.getId() + " wins!");
        }
    }
}

