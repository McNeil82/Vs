package de.moralis.vs;

import de.moralis.vs.general.Creature;
import de.moralis.vs.models.Mice;
import de.moralis.vs.models.Rat;

public class Vs {

    public static void main(String[] args) {
        Creature mice = new Mice();
        Creature rat = new Rat();

        Combat combat = new Combat(mice, rat);
        combat.fight();
    }
}
