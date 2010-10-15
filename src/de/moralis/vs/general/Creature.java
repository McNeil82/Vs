package de.moralis.vs.general;

public abstract class Creature implements Attributes {
    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
                "Total Life Points: " + getTotalLifePoints() + "\n" +
                "Strength: " + getStrength() + "\n" +
                "Defense: " + getDefense();
    }
}
