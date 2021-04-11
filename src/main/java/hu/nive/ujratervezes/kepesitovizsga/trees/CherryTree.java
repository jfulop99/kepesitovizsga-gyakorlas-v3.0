package hu.nive.ujratervezes.kepesitovizsga.trees;

public class CherryTree extends Tree {
    public CherryTree(int leaves) {
        super(leaves, Fruit.CHERRY);
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        leaves = leaves + numberOfSunnyDays * 20;
        return leaves;
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        weightOfFruit = growLeaves(numberOfSunnyDays) / 30;
    }
}
