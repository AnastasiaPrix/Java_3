package lesson1;


import lesson1.fruitTask.Apple;
import lesson1.fruitTask.Box;
import lesson1.fruitTask.Fruit;
import lesson1.fruitTask.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        changePosition(new Object[]{1, 3, 4, 5}, 2, 3);
        Integer[] mas = new Integer[]{1,2,4,5,6,7};
        ArrayList<Integer> arrayList = convertMas(mas);
        System.out.println(arrayList);

        Box<Fruit> box1= new Box<>();
        Box<Orange> box2 = new Box<>();
        Box<Apple> box3 = new Box<>();
        box2.addFruit(new Orange());
        box3.addFruit(new Apple());
        box3.addFruit(new Apple());
        System.out.println(box1.getWeight()+" "+box2.getWeight());
        box2.transfer(box1);
        System.out.println(box1.getWeight()+" "+box2.getWeight());
        if (box1.compare(box3)){
            System.out.println("Равны");
        }
        else {
            System.out.println("не равны");
        }
        System.out.println(box1.getWeight()+" "+box3.getWeight());

    }


    public static void changePosition(Object[] mas, int idx1, int idx2) {
        System.out.println(Arrays.asList(mas));
        Object buff = mas[idx1];
        mas[idx1] = mas [idx2];
        mas[idx2] = buff;
        System.out.println(Arrays.asList(mas));
    }

    public static <T> ArrayList<T> convertMas(T[] mas) {
        ArrayList<T> array = new ArrayList<>();
        for (T m:mas) {
            array.add(m);
        }
        return array;
    }
}
