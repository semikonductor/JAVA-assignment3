package HairDecoration;

public abstract class HairDecoration {
    HairDecoration hairDecoration;

    public HairDecoration() {

    }

    public HairDecoration(HairDecoration hairDecoration) {
        this.hairDecoration = hairDecoration;
    }

    public abstract int costSum();

    public abstract int timeSum();
}

