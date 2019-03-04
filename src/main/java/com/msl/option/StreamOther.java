package com.msl.option;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by msl on 2019/2/28.
 */
public class StreamOther {


    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,34,5};
//        OptionalDouble average = Arrays.stream(arr).average();
//        System.out.println("average:"+average.getAsDouble());

//        Stream.iterate(0,x->x+1).limit(10).forEach(System.out::println);
//        System.out.println("---");
//        Stream.iterate(0,x->x+2).limit(10).forEach(System.out::println);


//        String[] arr = new String[]{"yes", "YES", "no", "NO"};
//        Arrays.stream(arr).map(x -> x.toLowerCase()).forEach(System.out::println);


        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
        // Stream.of(arr1, arr2, arr3).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
//        long count = Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).count();
//        System.out.println(count);
//        拆分流
//        List<String> collect = Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream)
//            .collect(Collectors.toList());
//        System.out.println(collect);


//        Integer[] arr = {1,2,3,4,5};
//        List<Integer> ints = Arrays.asList(arr);
//        ints.stream().max((e1, e2) -> e1.compareTo(e2)).ifPresent(System.out::println);
//        Stream.of(arr).min((e1,e2)->e1.compareTo(e2)).ifPresent(System.out::println);

        Optional optional = Stream.of(1,2,3).reduce((x,y)->{
            System.out.println("acc : "  + x);
            x += y;
            System.out.println("item: " + y);
            System.out.println("acc+ : "  + x);
            System.out.println("--------");
            return x;
        });
        System.out.println(optional.get());


    }



}
