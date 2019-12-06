package ooad;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Formatter {
    static class ValueObject{
        public String one;
        public String two;

        public String toString(){
            System.out.println(String.format("%1$10s %1$10s", one,two));
            //System.out.println(one +" "+ two);
            return null;
        }
    }
    public static void main(String[] args) {
        ValueObject one = new ValueObject();
        one.one = "123131";
        ValueObject two = new ValueObject();
        two.one="123";

        List<ValueObject> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.stream().forEach(item -> item.toString());

    }
}
