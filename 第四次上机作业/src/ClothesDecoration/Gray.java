package ClothesDecoration;

import Decorator.Clothes;

public class Gray extends ClothesDecoration {
    public static final int cost = 5;
    public static final int time = 100;

    public Gray(Clothes clothes) {
        super(clothes);
    }

    public String toString() {
        return "Gray";
    }


    @Override
    public int costSum() {
        System.out.println("Making gray clothes cost 5 money");
        return cost + clothes.costSum();
    }

    @Override
    public int timeSum() {
        System.out.println("Making gray clothes takes 0.1h");
        return time + clothes.timeSum();
    }
}
