package hu.nive.ujratervezes.kepesitovizsga.trees;

public class WalnutTree extends Tree {
    public WalnutTree(int leaves) {
        super(leaves, Fruit.WALNUT);
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        leaves = leaves + numberOfSunnyDays * 30;
        return leaves;
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        weightOfFruit = growLeaves(numberOfSunnyDays) / 10;
    }
}
