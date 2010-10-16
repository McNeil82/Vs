package de.moralis.vs;

import de.moralis.vs.general.Creature;
import de.moralis.vs.models.Mice;
import de.moralis.vs.models.Rat;

public class Vs {

    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            if (args[0].startsWith("-debug=")) {
                System.setProperty("debug", args[0].substring(args[0].indexOf("=") + 1));
            }
        }

        Creature mice = new Mice();
        Creature rat = new Rat();

        Combat combat = new Combat(mice, rat);
        combat.fight();
    }
}
