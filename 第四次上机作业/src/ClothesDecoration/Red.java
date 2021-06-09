package ClothesDecoration;

import Decorator.Clothes;

public class Red extends ClothesDecoration {
    public static final int cost = 1;
    public static final int time = 100;

    public Red(Clothes clothes) {
        super(clothes);
    }

    public String toString() {
        return "Red";
    }


    @Override
    public int costSum() {
        System.out.println("Making red clothes cost 1 money");
        return cost + clothes.costSum();
    }

    @Override
    public int timeSum() {
        System.out.println("Making red clothes takes 0.1h");
        return time + clothes.timeSum();
    }


}
