package hu.nive.ujratervezes.kepesitovizsga.trees;

public abstract class Tree {

    protected int weightOfFruit;
    protected int leaves;
    private Fruit fruit;

    public Tree(int leaves, Fruit fruit) {
        this.leaves = leaves;
        this.fruit = fruit;
    }

    public int getLeaves() {
        return leaves;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public abstract int growLeaves(int numberOfSunnyDays);

    public abstract void ripenFruit(int numberOfSunnyDays);

    public int hostBirdNest() {
        return leaves / 200;
    }
}
