package de.moralis.vs;

import de.moralis.testapi.AbstractTest;
import de.moralis.vs.general.Creature;
import de.moralis.vs.models.Mice;
import de.moralis.vs.models.Rat;
import org.testng.annotations.Test;

public class CombatTest extends AbstractTest {

    @Test()
    public void testWinnerRatio() {
        Creature mice = new Mice();
        Creature rat = new Rat();

        int miceCounter = 0;
        int ratCounter = 0;

        Combat combat = new Combat(mice, rat);

        for (int i = 1; i <= 1000; ++i) {
            Creature winner = combat.fight();

            if (Rat.class.isAssignableFrom(winner.getClass())) {
                ++ratCounter;
            } else {
                ++miceCounter;
            }
        }

        double ratio = Math.round(((double) miceCounter / ratCounter) * 10000) / 100d;

        log.info("mice wins: " + miceCounter + " times");
        log.info("rat wins: " + ratCounter + " times");
        log.info("ratio: " + ratio + "%");
    }
}
