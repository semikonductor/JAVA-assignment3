package Decorator;

public class Trousers extends Clothes {
    public static final int cost = 200;
    public static final int time = 1200;


    public String toString() {
        return "Trousers";
    }

    @Override
    public int costSum() {
        System.out.println("Basic trousers cost you 200 money");
        return cost;
    }

    @Override
    public int timeSum() {
        System.out.println("Wearing trousers takes 1.2h");
        return time;
    }

}
