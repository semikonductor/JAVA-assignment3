package HairDecoration;

public class Wash extends HairDecoration {
    public static final int cost = 10;
    public static final int time = 100;

    public Wash(HairDecoration hairDecoration) {
        super((hairDecoration));
    }

    public String toString() {
        return "Wash";
    }

    @Override
    public int costSum() {
        System.out.println("洗澡 cost 10 money");
        return cost + hairDecoration.costSum();
    }

    @Override
    public int timeSum() {
        System.out.println("洗澡 takes 0.1h");
        return time + hairDecoration.timeSum();
    }
}
