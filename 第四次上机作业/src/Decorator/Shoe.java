package Decorator;

public class Shoe extends Clothes {
    public static final int cost = 50;
    public static final int time = 1000;


    public String toString() {
        return "Shoe";
    }

    @Override
    public int costSum() {
        System.out.println("Basic shoes cost you 50 money");
        return cost;
    }

    @Override
    public int timeSum() {
        System.out.println("Wearing shoes takes 1h");
        return time;
    }

}
