package de.moralis.vs;

import de.moralis.testapi.AbstractTest;
import de.moralis.vs.general.Creature;
import de.moralis.vs.models.BigMouse;
import de.moralis.vs.models.BigRat;
import de.moralis.vs.models.Mouse;
import de.moralis.vs.models.Rat;
import org.testng.annotations.Test;

public class CombatTest extends AbstractTest {

    @Test
    public void testWinnerRatio() throws IllegalAccessException, InstantiationException {
        Class[] creatureClasses = new Class[] {
                Mouse.class,
                Rat.class,
                BigMouse.class,
                BigRat.class
        };

        for (Class classCreature1 : creatureClasses) {
            for (Class classCreature2 : creatureClasses) {

                Creature creature1 = (Creature) classCreature1.newInstance();
                Creature creature2 = (Creature) classCreature2.newInstance();

                String creature1Name = creature1.getName();
                String creature2Name = creature2.getName();

                log.comment(creature1Name + " vs. " + creature2Name);

                int creature1Counter = 0;
                int creature2Counter = 0;

                Combat combat = new Combat(creature1, creature2);

                for (int i = 1; i <= 1000; ++i) {
                    Creature winner = combat.fight();

                    if (winner.equals(creature1)) {
                        ++creature1Counter;
                    } else {
                        ++creature2Counter;
                    }
                }

                double creature1Ratio = creature1Counter / 10d;
                double creature2Ratio = creature2Counter / 10d;

                log.info(creature1Name + " wins: " + creature1Counter + " times");
                log.info(creature2Name + " wins: " + creature2Counter + " times");
                log.info(creature1Name + " ratio: " + creature1Ratio + "%");
                log.info(creature2Name + " ratio: " + creature2Ratio + "%");
            }
        }
    }
}
