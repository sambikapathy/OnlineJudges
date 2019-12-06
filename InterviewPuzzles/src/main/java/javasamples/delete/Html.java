package javasamples.delete;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Html {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("b")) {
                list.remove(i);
            }
            System.out.println(list.get(i));
        }
    }

}
