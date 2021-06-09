package ClothesDecoration;

import Decorator.Clothes;

public class Cotton extends ClothesDecoration {
    public static final int cost = 5;
    public static final int time = 20;

    public Cotton(Clothes clothes) {
        super(clothes);
    }

    public String toString() {
        return "Cotton";
    }


    @Override
    public int costSum() {
        System.out.println("Making cotton clothes cost 5 money");
        return cost + clothes.costSum();
    }

    @Override
    public int timeSum() {
        System.out.println("Making cotton clothes takes 0.2h");
        return time + clothes.timeSum();
    }
}
