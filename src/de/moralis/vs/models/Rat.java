package de.moralis.vs.models;

import de.moralis.vs.general.Creature;

public class Rat extends Creature {
    private static final int TOTAL_LIFE_POINTS = 7;
    private static final int STRENGTH = 1;
    private static final int DEFENSE = 1;
    private static final String NAME = "Rat";

    public int getTotalLifePoints() {
        return TOTAL_LIFE_POINTS;
    }

    public int getStrength() {
        return STRENGTH;
    }

    public int getDefense() {
        return DEFENSE;
    }

    public String getName() {
        return NAME;
    }
}
