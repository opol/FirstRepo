package hw1;

import java.util.*;

/**
 * Created by Ulyana_Opolska on 2/19/2016.
 */
public class task1 {
    public static void main(String[] args) {
        List<String> aList = new ArrayList<String>();

        aList.add("E1");
        aList.add("E1");
        aList.add("E3");
        aList.add("E3");


        for (int counter = 0; counter < aList.size()/2; counter++) {
            if (aList.get(counter).equals("E1")){
                aList.set(counter, "E2");
            }
        }
        System.out.println(aList);
    }
}
