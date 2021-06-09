package Decorator;

public class Hat extends Clothes {
    public static final int cost = 20;
    public static final int time = 100;


    @Override
    public String toString() {
        return "Hat";
    }

    @Override
    public int costSum() {
        System.out.println("Basic hat costs you 50 money");
        return cost;
    }

    @Override
    public int timeSum() {
        System.out.println("Wearing a hat takes 0.1h");
        return time;
    }

}
