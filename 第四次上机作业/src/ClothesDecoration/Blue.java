package ClothesDecoration;

import Decorator.Clothes;

public class Blue extends ClothesDecoration {
    public static final int cost = 5;
    public static final int time = 100;

    public Blue(Clothes clothes) {
        super(clothes);
    }

    public String toString() {
        return "Blue";
    }

    @Override
    public int costSum() {
        System.out.println("Making blue clothes cost 5 money");
        return cost + clothes.costSum();
    }

    @Override
    public int timeSum() {
        System.out.println("Making blue clothes takes 0.1h");
        return time + clothes.timeSum();
    }
}
