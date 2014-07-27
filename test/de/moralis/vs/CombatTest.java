package de.moralis.vs;

import de.moralis.testapi.AbstractTest;
import de.moralis.vs.general.Creature;
import de.moralis.vs.models.Mice;
import de.moralis.vs.models.Rat;
import org.testng.annotations.Test;

public class CombatTest extends AbstractTest {

    @Test
    public void testWinnerRatioMiceVsRat() {
        log.comment("Mice vs. Rat");

        Creature mice = new Mice();
        Creature rat = new Rat();

        int miceCounter = 0;
        int ratCounter = 0;

        Combat combat = new Combat(mice, rat);

        for (int i = 1; i <= 1000; ++i) {
            Creature winner = combat.fight();

            if (winner.equals(rat)) {
                ++ratCounter;
            } else {
                ++miceCounter;
            }
        }

        double miceRatio = miceCounter / 10d;
        double ratRatio = ratCounter / 10d;

        log.info("mice wins: " + miceCounter + " times");
        log.info("rat wins: " + ratCounter + " times");
        log.info("mice ratio: " + miceRatio + "%");
        log.info("rat ratio: " + ratRatio + "%");
    }

    @Test
    public void testWinnerRatioMice1VsMice2() {
        log.comment("Mice1 vs. Mice2");

        Creature mice1 = new Mice();
        Creature mice2 = new Mice();

        int mice1Counter = 0;
        int mice2Counter = 0;

        Combat combat = new Combat(mice1, mice2);

        for (int i = 1; i <= 1000; ++i) {
            Creature winner = combat.fight();

            if (winner.equals(mice2)) {
                ++mice2Counter;
            } else {
                ++mice1Counter;
            }
        }

        double mice1Ratio = mice1Counter / 10d;
        double mice2Ratio = mice2Counter / 10d;

        log.info("mice1 wins: " + mice1Counter + " times");
        log.info("mice2 wins: " + mice2Counter + " times");
        log.info("mice1 ratio: " + mice1Ratio + "%");
        log.info("mice2 ratio: " + mice2Ratio + "%");
    }

    @Test
    public void testWinnerRatioMice2VsMice1() {
        log.comment("Mice1 vs. Mice2");

        Creature mice1 = new Mice();
        Creature mice2 = new Mice();

        int mice1Counter = 0;
        int mice2Counter = 0;

        Combat combat = new Combat(mice2, mice1);

        for (int i = 1; i <= 1000; ++i) {
            Creature winner = combat.fight();

            if (winner.equals(mice2)) {
                ++mice2Counter;
            } else {
                ++mice1Counter;
            }
        }

        double mice1Ratio = mice1Counter / 10d;
        double mice2Ratio = mice2Counter / 10d;

        log.info("mice1 wins: " + mice1Counter + " times");
        log.info("mice2 wins: " + mice2Counter + " times");
        log.info("mice1 ratio: " + mice1Ratio + "%");
        log.info("mice2 ratio: " + mice2Ratio + "%");
    }

    @Test
    public void testWinnerRatioRat1VsRat2() {
        log.comment("Rat1 vs. Rat2");

        Creature rat1 = new Rat();
        Creature rat2 = new Rat();

        int rat1Counter = 0;
        int rat2Counter = 0;

        Combat combat = new Combat(rat1, rat2);

        for (int i = 1; i <= 1000; ++i) {
            Creature winner = combat.fight();

            if (winner.equals(rat2)) {
                ++rat2Counter;
            } else {
                ++rat1Counter;
            }
        }

        double rat1Ratio = rat1Counter / 10d;
        double rat2Ratio = rat2Counter / 10d;

        log.info("rat1 wins: " + rat1Counter + " times");
        log.info("rat2 wins: " + rat2Counter + " times");
        log.info("rat1 ratio: " + rat1Ratio + "%");
        log.info("rat2 ratio: " + rat2Ratio + "%");
    }

    @Test
    public void testWinnerRatioRat2VsRat1() {
        log.comment("Rat1 vs. Rat2");

        Creature rat1 = new Rat();
        Creature rat2 = new Rat();

        int rat1Counter = 0;
        int rat2Counter = 0;

        Combat combat = new Combat(rat2, rat1);

        for (int i = 1; i <= 1000; ++i) {
            Creature winner = combat.fight();

            if (winner.equals(rat2)) {
                ++rat2Counter;
            } else {
                ++rat1Counter;
            }
        }

        double rat1Ratio = rat1Counter / 10d;
        double rat2Ratio = rat2Counter / 10d;

        log.info("rat1 wins: " + rat1Counter + " times");
        log.info("rat2 wins: " + rat2Counter + " times");
        log.info("rat1 ratio: " + rat1Ratio + "%");
        log.info("rat2 ratio: " + rat2Ratio + "%");
    }
}
