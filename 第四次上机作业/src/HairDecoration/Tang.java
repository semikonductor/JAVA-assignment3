package HairDecoration;

public class Tang extends HairDecoration {
    public static final int cost = 10;
    public static final int time = 100;

    public Tang(HairDecoration hairDecoration) {
        super(hairDecoration);
    }

    public String toString() {
        return "Tang";
    }

    @Override
    public int costSum() {
        System.out.println("烫毛 cost 10 money");
        return cost + hairDecoration.costSum();
    }

    @Override
    public int timeSum() {
        System.out.println("烫毛 takes 0.1h");
        return time + hairDecoration.timeSum();
    }
}
