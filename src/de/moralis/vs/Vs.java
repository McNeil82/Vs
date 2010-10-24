package de.moralis.vs;

import de.moralis.logging.LoggingTransformer;
import de.moralis.vs.general.Creature;
import de.moralis.vs.models.Mice;
import de.moralis.vs.models.Rat;

public class Vs {
    private static final String COMMAND_DEBUG = "debug";
    private static final String PROPERTY_DEBUG = "debug";
    private static final String EQUALS = "=";
    private static final String MINUS = "-";

    public static void main(String[] args) {
        evaluateArgs(args);

        Creature mice = new Mice();
        Creature rat = new Rat();

        Combat combat = new Combat(mice, rat);
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
