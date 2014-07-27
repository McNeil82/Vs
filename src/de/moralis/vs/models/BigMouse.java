package de.moralis.vs.models;

import de.moralis.vs.general.Creature;

public class BigMouse extends Creature {
    private static final int TOTAL_LIFE_POINTS = 6;
    private static final int STRENGTH = 2;
    private static final int DEFENSE = 0;
    private static final String NAME = "Big Mouse";

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
