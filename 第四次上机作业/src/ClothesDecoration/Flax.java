package ClothesDecoration;

import Decorator.Clothes;

public class Flax extends ClothesDecoration {
    public static final int cost = 10;
    public static final int time = 30;

    public Flax(Clothes clothes) {
        super(clothes);
    }

    public String toString() {
        return "Flax";
    }

    @Override
    public int costSum() {
        System.out.println("Making flax clothes cost 10 money");
        return cost + clothes.costSum();
    }

    @Override
    public int timeSum() {
        System.out.println("Making flax clothes takes 0.3h");
        return time + clothes.timeSum();
    }
}
