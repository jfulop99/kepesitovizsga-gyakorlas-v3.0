package hu.nive.ujratervezes.kepesitovizsga.trees;

public class AppleTree extends Tree {
    public AppleTree(int leaves) {
        super(leaves, Fruit.APPLE);
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        leaves = leaves + numberOfSunnyDays *10;
        return leaves;
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {

        weightOfFruit = growLeaves(numberOfSunnyDays) / 50;

    }
}
