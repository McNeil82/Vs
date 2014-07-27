package de.moralis.vs;

import de.moralis.logging.LoggingTransformer;
import de.moralis.vs.general.Creature;
import de.moralis.vs.models.Mouse;
import de.moralis.vs.models.Rat;

public class Vs {
    private static final String COMMAND_DEBUG = "debug";
    private static final String PROPERTY_DEBUG = "debug";
    private static final String EQUALS = "=";
    private static final String MINUS = "-";

    public static void main(String[] args) {
        evaluateArgs(args);

        Creature mouse1 = new Mouse();
        Creature mouse2 = new Mouse();
        Creature rat1 = new Rat();
        Creature rat2 = new Rat();

        Combat combat = new Combat(mouse1, rat1);
        combat.fight();

        combat = new Combat(mouse1, mouse2);
        combat.fight();

        combat = new Combat(rat1, rat2);
        combat.fight();

        generateLogs();
    }

    private static void evaluateArgs(String[] args) {
        if (args != null && args.length > 0) {
            if (args[0].startsWith(MINUS + COMMAND_DEBUG + EQUALS)) {
                System.setProperty(PROPERTY_DEBUG, args[0].substring(args[0].indexOf(EQUALS) + 1));
            }
        }
    }

    private static void generateLogs() {
        new LoggingTransformer().createHtml(false);
    }
}
