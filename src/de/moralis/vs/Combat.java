package de.moralis.vs;

import de.moralis.logging.Logger;
import de.moralis.vs.general.Creature;

public class Combat {
    private static final double STANDARD_DEFENSE_VALUE = 0.2;

    private final Creature creature1;
    private final Creature creature2;

    private final Logger log = Logger.createLogger(this.getClass().getName());

    public Combat(Creature creature1, Creature creature2) {
        this.creature1 = creature1;
        this.creature2 = creature2;
    }

    public Creature fight() {
        log.info(creature1.toString());
        log.info(creature2.toString());

        int currentLifePointsCreature1 = creature1.getTotalLifePoints();
        int currentLifePointsCreature2 = creature2.getTotalLifePoints();

        while (currentLifePointsCreature1 > 0 && currentLifePointsCreature2 > 0) {
            double hitCreature1 = calculateHit(creature1);

            log.info(creature1.getName() + " hits " + creature2.getName() + " with " + hitCreature1);

            currentLifePointsCreature2 = calculateNewLifePoints(creature2, currentLifePointsCreature2, hitCreature1);

            log.info(creature2.getName() + " has now " + currentLifePointsCreature2 + "/" + creature2.getTotalLifePoints() + " LP");

            if (currentLifePointsCreature2 > 0) {
                double hitCreature2 = calculateHit(creature2);

                log.info(creature2.getName() + " hits " + creature1.getName() + " with " + hitCreature2);

                currentLifePointsCreature1 = calculateNewLifePoints(creature1, currentLifePointsCreature1, hitCreature2);

                log.info(creature1.getName() + " has now " + currentLifePointsCreature1 + "/" + creature1.getTotalLifePoints() + " LP");
            }
        }

        if (currentLifePointsCreature1 > 0) {
            log.info(creature1.getName() + " wins");
            return creature1;
        } else {
            log.info(creature2.getName() + " wins");
            return creature2;
        }
    }

    private int calculateNewLifePoints(Creature creature, int currentLifePoints, double hitOpponent) {
        double lifePointsToLose = hitOpponent;

        int defense = creature.getDefense();

        log.info(creature.getName() + " has " + defense + " Defense");

        if (defense > 0) {
            lifePointsToLose /= (defense + STANDARD_DEFENSE_VALUE);
        }

        log.warning(lifePointsToLose + "");

        int lostLifePoints = (int) Math.round(lifePointsToLose);

        log.info(creature.getName() + " loses " + lostLifePoints + " LP");

        int newLifePoints = currentLifePoints - lostLifePoints;

        return newLifePoints < 0 ? 0 : newLifePoints;
    }

    private double calculateHit(Creature creature) {
        return Math.random() * creature.getStrength();
    }
}
