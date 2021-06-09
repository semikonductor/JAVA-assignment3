package HairDecoration;

public class Cut extends HairDecoration {
    public static final int cost = 10;
    public static final int time = 500;


    public Cut(HairDecoration hairDecoration) {
        super(hairDecoration);
    }

    @Override
    public int costSum() {
        System.out.println("毛发修理 cost 10 money");
        return cost + hairDecoration.costSum();
    }

    @Override
    public int timeSum() {
        System.out.println("毛发修理 takes 0.5h");
        return time + hairDecoration.timeSum();
    }
}
