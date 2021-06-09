package ClothesDecoration;

import Decorator.Clothes;


public abstract class ClothesDecoration extends Clothes {
    public Clothes clothes;

    ClothesDecoration(Clothes clothes) {
        this.clothes = clothes;
    }
}

