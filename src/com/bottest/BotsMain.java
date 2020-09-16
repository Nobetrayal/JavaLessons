package com.bottest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class BotsMain {

    final static int numberOfSimulations = 10000;

    public static void main(String[] args) {


        Map<Bot, Integer> winRates = new HashMap<>();


        for (int i = 1; i <= numberOfSimulations; i++) {

            boolean someoneDead = false;
            boolean aToB = false;
//            boolean aToB = true;
//            Bot botA = new Bot("Alex", 1000, 25, 0, 1, 10);
            Bot botA = new Bot("Alex", 500, 35, 0.25f, 3, 5);
            Bot botB = new Bot("Bex", 300, 35, 0.5f, 4, 1);
            boolean isEquals = botA.equals(botB);

            while (!someoneDead) {

                if (aToB) {
                    someoneDead = isSomeoneDead(winRates, someoneDead, botA, botB);
                } else {

                    someoneDead = isSomeoneDead(winRates, someoneDead, botB, botA);

                }
                aToB = !aToB;
            }


        }

        for (Bot bot : winRates.keySet()) {

            System.out.println("bot " + bot.getName() + " wins " + winRates.get(bot) + " times");

        }

    }

    private static boolean isSomeoneDead(Map<Bot, Integer> winRates, boolean someoneDead, Bot botA, Bot botB) {
        makeHit(botA, botB);

        if (botB.health <= 0) {
            someoneDead = true;

            if (winRates.get(botA) == null) {
                winRates.put(botA, 1);
            } else {
                winRates.put(botA, winRates.get(botA) + 1);
            }

        }
        return someoneDead;
    }

    private static void makeHit(Bot attacker, Bot defender) {

        float damage;

        if (isCrit(attacker.getCritChance())) {

            damage = attacker.getDamage() * attacker.getCritMultipler() - defender.getDefence();

        } else {

            damage = attacker.getDamage() - defender.getDefence();

        }

        defender.health = (int) (defender.health - damage);

//        double damage = attacker.getDamage() * attacker.getCritChance() * attacker.getCritMultipler() + attacker.getDamage() * (1 - attacker.getCritChance());

    }

    private static boolean isCrit(float critChance) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100);


        return critChance * 100 >= randomNum;
    }

}
