package com.pagoda.goods;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEShop {


    @Test
    public void test1() {

        List<Integer> list = null;
 /*        List<Integer> list = new ArrayList<>();
       list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(9);*/

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);

        List<Integer> integers = list2.subList(0, 2);
        list2.subList(0, 2).clear();
        System.out.println(integers);
        System.out.println(list2);


        integers.add(3);
        integers.addAll(list2);
        System.out.println(list2);
        System.out.println(integers);

    }


}
