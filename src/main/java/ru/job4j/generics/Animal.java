package ru.job4j.generics;

public class Animal {
    private String name;
    private int population;

    public Animal(String name, int population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {"
                + "name='" + name + '\''
                + ", population=" + population
                + '}';
    }
}
