package ClothesDecoration;

import Decorator.Clothes;

public class Fur extends ClothesDecoration {
    public static final int cost = 50;
    public static final int time = 100;

    public Fur(Clothes clothes) {
        super(clothes);
    }

    public String toString() {
        return "Fur";
    }

    @Override
    public int costSum() {
        System.out.println("Making fur clothes cost 50 money");
        return cost + clothes.costSum();
    }

    @Override
    public int timeSum() {
        System.out.println("Making fur clothes takes 1h");
        return time + clothes.timeSum();
    }
}
