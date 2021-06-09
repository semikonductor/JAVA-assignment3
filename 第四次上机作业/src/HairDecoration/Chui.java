package HairDecoration;

public class Chui extends HairDecoration {
    public static final int cost = 0;
    public static final int time = 100;

    public Chui() {
        super();
    }


    @Override
    public String toString() {
        return "Chui";
    }


    @Override
    public int costSum() {
        System.out.println("吹干 cost 0 money");
        return 0;
    }

    @Override
    public int timeSum() {
        System.out.println("吹干 takes 0.1h");
        return time;
    }
}
