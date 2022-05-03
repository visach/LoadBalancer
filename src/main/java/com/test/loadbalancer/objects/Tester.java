package com.test.loadbalancer.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tester {
    public Tester()
    {
        System.out.println("Dentro del tester");
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(1);//P1 - 1
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(3);//P2 - 5
        lista.add(3);
        lista.add(3);
        lista.add(3);

        //List<Integer> lista2 = Arrays.asList(1,2,3);
        List<Integer> x1 = new ArrayList<>();
        List<Integer> x2 = new ArrayList<>();
        List<Integer> x3 = new ArrayList<>();
        Integer x1sum;
        Integer x2sum;

        x1 = lista.stream().limit(2).collect(Collectors.toList());
        x1sum = lista.stream().limit(2).reduce(0,Integer::sum);
        System.out.println("x1 = " + x1sum);
        x2 = lista.stream().skip(2).limit(6).collect(Collectors.toList());
        x2sum = lista.stream().skip(2).limit(6).reduce(0,Integer::sum);
        System.out.println("x2 = " + x2sum);
    }
}
