package com.msl.option;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by msl on 2019/2/27.
 */
public class Lamda {

    private static List<String> items = new ArrayList<>();
    private static Map<String, Integer> mapItems = new HashMap<>();
    private static List<Person> personList = new ArrayList();
    private static Map<Integer, String> map_ = new HashMap();

    static {
        items.add("A");
        items.add("BC");
        items.add("C");
        items.add("BD");
        items.add("E");

        mapItems.put("A", 10);
        mapItems.put("B", 20);
        mapItems.put("C", 30);
        mapItems.put("D", 40);
        mapItems.put("E", 50);
        mapItems.put("F", 60);

        personList.add(Person.builder().id(10).name("apple1").address("shanghai").build());
        personList.add(Person.builder().id(12).name("apple2").address("wuhan").build());
        personList.add(Person.builder().id(16).name("apple3").address("nanjing").build());

        personList.add(Person.builder().id(17).name("apple4").address("tianjin").build());
        personList.add(Person.builder().id(18).name("apple5").address("wuhan").build());
        personList.add(Person.builder().id(19).name("apple6").address("nanjing").build());

        map_.put(1, "linode.com");
        map_.put(2, "heroku.com");
        map_.put(3, "digitalocean.com");
        map_.put(4, "aws.amazon.com");

    }


    public static void main(String[] args) {
//        testList();
//        testMap();
//        testListToGroup();
//        testListToMap();
//          filterMap();
        OptionHandle();
    }


    public static void OptionHandle() {
        Optional<String> optional = Optional.of("info");
        System.out.println(optional.isPresent());//true
        System.out.println(optional.get());//hello
        System.out.println(optional.orElse("false"));
        optional.ifPresent(s-> System.out.println(s.charAt(0)));//
    }


    public static void filterMap() {
        //before java iterator map
        String result = null;
        for (Map.Entry<Integer, String> entry : map_.entrySet()) {
            if ("heroku.com".equals(entry.getValue())) {
                result = entry.getValue();
            }
        }
        System.out.println("Before Java 8 :" + result);
        //Java8 Map->Stream->Filter->String
        result = map_.entrySet().stream().
            filter(map -> "heroku.com".equals(map.getValue()))
            .map(map -> map.getValue())
            .collect(Collectors.joining());
        System.out.println("Java 8 :" + result);

        Map<Integer, String> collect = map_.entrySet().stream()
            .filter(c -> c.getKey() == 2)
            .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        System.out.println(collect);
    }


    public static void testListToMap() {
        //Java8 List转换Map
        Map<Integer, Person> map_ = personList.stream()
            .collect(Collectors.toMap((key -> key.getId()), (value -> value)));
        map_.forEach((key, value) -> System.out.println(key + ":" + value));

        Map<Integer, Person> mappedMovies = personList.stream().collect(
            Collectors.toMap((key -> key.getId()), (value -> value)));

    }


    public static void testListToGroup() {
//        Map<String, List<Person>> collect1 = personList.stream()
//            .collect(Collectors.groupingBy(c -> c.getAddress()));
//        System.out.println(collect1);
        long nanjingCount = personList.parallelStream()
            .filter(item -> item.getAddress().equals("nanjing")).count();
        System.out.println(nanjingCount);

        //分组
        Map<String, List<Person>> collect = personList.stream()
            .collect(Collectors.groupingBy(c -> c.getAddress()));
        System.out.println(collect);
        collect.forEach((key, value) -> System.out.println(key + "--" + value.size()));
    }


    public static void testMap() {
        //Java8之前遍历是这样遍历map
        for (Map.Entry<String, Integer> entry : mapItems.entrySet()) {
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }
        System.out.println("------");
        //Java8遍历map
        mapItems.forEach((key, value) -> System.out.println("key:" + key + " value:" + value));

    }


    public static void testList() {
        //Java8之前操作List
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("------1");
        //Java8 lambda遍历list
        items.forEach(c -> System.out.println(c));
        System.out.println("------2");
        items.forEach(item -> {
            if ("C".equals(item)) {
                System.out.println(item);
            }
        });
        System.out.println("--------3");

        //先过滤
        items.stream().filter(s -> s.contains("B")).forEach(c1 -> System.out.println(c1));
    }




}
