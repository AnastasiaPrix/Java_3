package lesson1.fruitTask;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    private ArrayList<T> list;

    public Box(T... arr) {
        list = new ArrayList<T>(Arrays.asList(arr));
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T a: list) {
            weight+=a.getWeight();
        }
        return weight;
    }

    public void addFruit(T fruit) {
        list.add(fruit);
    }

    public boolean compare(Box another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    public void transfer(Box<? super T> another) {
        another.list.addAll(this.list);
        this.list.clear();
    }
}
