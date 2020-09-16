package com.bottest;

import java.util.Objects;

public class Bot {

    private String name;
//    private int maxHealth = 0;
    public int health = 0;
    private int damage = 0;
    private int defence = 0;
    private float critChance = 0;
    private float critMultipler = 1;

    public Bot(String name, int health, int damage, float critChance, float critMultipler, int defence) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.critChance = critChance;
        this.critMultipler = critMultipler;
        this.defence = defence;
    }

    public int getDefence() {
        return defence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bot bot = (Bot) o;
        return Objects.equals(name, bot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public float getCritChance() {
        return critChance;
    }

    public float getCritMultipler() {
        return critMultipler;
    }
}
