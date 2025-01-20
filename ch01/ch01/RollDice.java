/*
 * $Id$
 * Copyright (C) 2011 ARIN
 */
package ch01;

public class RollDice {
    public static void main(String[] args) {
        System.out.println(rollDice());
    }

    private static int rollDice() {
        return rollDie() + rollDie();
    }

    private static int rollDie() {
        return (int) (1 + 6 * Math.random());
    }
}
