package Decorator;

public class Shirt extends Clothes {
    public static final int cost = 100;
    public static final int time = 1500;
    Clothes clothes;

    public String toString() {
        return "Shirt";
    }

    @Override
    public int costSum() {
        System.out.println("Basic shirt cost you 100 money");
        return cost;
    }

    @Override
    public int timeSum() {
        System.out.println("Wearin shirt takes 1.5h");
        return time;
    }

}
