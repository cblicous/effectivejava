package de.plants;

class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL,BIENNIAL }

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
        this.name = name;
    }
}