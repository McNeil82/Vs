package de.moralis.vs;

import de.moralis.testapi.AbstractTest;
import de.moralis.vs.general.Creature;
import de.moralis.vs.models.Mouse;
import de.moralis.vs.models.Rat;
import org.testng.annotations.Test;

public class CombatTest extends AbstractTest {

    @Test
    public void testWinnerRatioMouseVsRat() {
        log.comment("Mouse vs. Rat");

        Creature mouse = new Mouse();
        Creature rat = new Rat();

        int mouseCounter = 0;
        int ratCounter = 0;

        Combat combat = new Combat(mouse, rat);

        for (int i = 1; i <= 1000; ++i) {
            Creature winner = combat.fight();

            if (winner.equals(rat)) {
                ++ratCounter;
            } else {
                ++mouseCounter;
            }
        }

        double mouseRatio = mouseCounter / 10d;
        double ratRatio = ratCounter / 10d;

        log.info("mouse wins: " + mouseCounter + " times");
        log.info("rat wins: " + ratCounter + " times");
        log.info("mouse ratio: " + mouseRatio + "%");
        log.info("rat ratio: " + ratRatio + "%");
    }

    @Test
    public void testWinnerRatioMouse1VsMouse2() {
        log.comment("Mouse1 vs. Mouse2");

        Creature mouse1 = new Mouse();
        Creature mouse2 = new Mouse();

        int mouse1Counter = 0;
        int mouse2Counter = 0;

        Combat combat = new Combat(mouse1, mouse2);

        for (int i = 1; i <= 1000; ++i) {
            Creature winner = combat.fight();

            if (winner.equals(mouse2)) {
                ++mouse2Counter;
            } else {
                ++mouse1Counter;
            }
        }

        double mouse1Ratio = mouse1Counter / 10d;
        double mouse2Ratio = mouse2Counter / 10d;

        log.info("mouse1 wins: " + mouse1Counter + " times");
        log.info("mouse2 wins: " + mouse2Counter + " times");
        log.info("mouse1 ratio: " + mouse1Ratio + "%");
        log.info("mouse2 ratio: " + mouse2Ratio + "%");
    }

    @Test
    public void testWinnerRatioMouse2VsMouse1() {
        log.comment("Mouse1 vs. Mouse2");

        Creature mouse1 = new Mouse();
        Creature mouse2 = new Mouse();

        int mouse1Counter = 0;
        int mouse2Counter = 0;

        Combat combat = new Combat(mouse2, mouse1);

        for (int i = 1; i <= 1000; ++i) {
            Creature winner = combat.fight();

            if (winner.equals(mouse2)) {
                ++mouse2Counter;
            } else {
                ++mouse1Counter;
            }
        }

        double mouse1Ratio = mouse1Counter / 10d;
        double mouse2Ratio = mouse2Counter / 10d;

        log.info("mouse1 wins: " + mouse1Counter + " times");
        log.info("mouse2 wins: " + mouse2Counter + " times");
        log.info("mouse1 ratio: " + mouse1Ratio + "%");
        log.info("mouse2 ratio: " + mouse2Ratio + "%");
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
