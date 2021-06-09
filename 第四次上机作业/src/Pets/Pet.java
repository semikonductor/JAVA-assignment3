package Pets;

import java.util.ArrayList;

public class Pet {
    public String name;
    public String kind;
    public ArrayList<String> clothesList = new ArrayList<>();
    public ArrayList<String> hairList = new ArrayList<>();

    public Pet(String name, String kind) {
        this.name = name;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "name: " + name + "  " +
                "kind: " + kind + "  " +
                "clothesList: " + clothesList + "  " +
                "hairCutList: " + hairList;
    }
}
