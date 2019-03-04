package com.msl.option;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by msl on 2019/2/27
 *
 * stream 测试
 *
 * 1、listTomap
 * 2、listToSet
 * 3、过滤数据
 * 4、求平均数
 * 5、排序后获取最大或最小数据
 * 6、数据聚合
 *
 *
 *
 */
public class EmployeeTest {

    private static List<Employee> employeeList = new ArrayList();

    static {
        employeeList.add(Employee.builder().name("Matt").salary(5000).office("New York").build());
        employeeList.add(Employee.builder().name("Steve").salary(6000).office("London").build());
        employeeList
            .add(Employee.builder().name("Carrie").salary(20000).office("New York").build());
        employeeList.add(Employee.builder().name("Peter").salary(7000).office("New York").build());
        employeeList.add(Employee.builder().name("Pat").salary(8000).office("London").build());
        employeeList.add(Employee.builder().name("Tammy").salary(29000).office("Shanghai").build());
        employeeList.add(Employee.builder().name("marry").salary(19000).office("Shanghai").build());
    }


    public static void main(String[] args) {
//        System.out.println("start");
//        anyMatch();
//        System.out.println("------------");
//        allMatch();
//        System.out.println("------------");
//        findMaxSalary();
//        System.out.println("------------");
//        returnNameList();
//        System.out.println("------------");
//        listToMap();
//        System.out.println("------------");
//        CountOffice();
//        System.out.println("------------");
//        distinctListName();
//        System.out.println("------------");
//        findSalaryOfOffice();
//        System.out.println("------------");
//        orderByNameUp();
//        System.out.println("------------");
//        findThe2HeadOfHightSalaryPerson();
//        System.out.println("------------");
//        getAllPersonAvarageSalary();
//        System.out.println("------------");
//        getSomeOfficePersonAvarageSalary();
//        System.out.println("------------");
        groupByOffice();

    }






    /*anyMatch
    *
    * */

    public static void anyMatch() {
        boolean flag = employeeList.stream().anyMatch(e1 -> e1.getOffice().equals("London"));
        System.out.println("集合是否有London办公室人员" + flag);
    }


    /*
    查找是否所有人工资超过某个值（金额）
    * */
    public static void allMatch() {
        boolean flag = employeeList.stream().allMatch(e1 -> e1.getSalary() >= 5000);
        System.out.println("所有办公室人员，工资是否都超过5000元？" + flag);
    }

    /*
    找出工资最高
    */
    public static void findMaxSalary() {
        Employee flag = employeeList.stream()
            .max((e1, e2) -> e1.getSalary().compareTo(e2.getSalary())).get();
        System.out.println("工资最高的人为：" + flag);
    }

    //返回姓名列表
    public static void returnNameList() {
        List<String> flag = employeeList.stream().map(employee -> employee.getName()).collect(
            Collectors.toList());
        System.out.println("所有人员姓名如下：" + flag);
    }


    //List转换成Map
    public static void listToMap() {
        Map<String, Employee> collect = employeeList.stream()
            .collect(Collectors.toMap((key -> key.getName()), (value -> value)));
        System.out.println("map信息展示");
        collect.forEach((key, value) -> System.out.println("name:" + key + "----个人信息" + value));
    }


    /*统计办公室是Shanghai的个数*/
    public static void CountOffice() {
        System.out.println("上海办公室有几个员工：" + employeeList.stream()
            .filter(employee -> employee.getOffice().equals("Shanghai")).count());
    }

    /*List转换为Set*/
    public static void distinctListName() {
        Set<String> collect = employeeList.stream().map(e1 -> e1.getOffice()).distinct()
            .collect(Collectors.toSet());
        System.out.println("公司在全球有的办公室如下" + collect);
    }

    //查找办公室地点是New York的员工,并且针对销售额进行降序

    public static void findSalaryOfOffice() {

        List<Employee> collect = employeeList.stream()
            .filter(employee -> employee.getOffice().equals("New York"))
            .sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary()))
            .collect(Collectors.toList());
        System.out.println("办公室在纽约的人员以工资降序排列有以下人员：" + collect);
        Collections.reverse(collect);
        System.out.println("升序：" + collect);
    }

    //按照名字的升序列出员工信息
    public static void orderByNameUp() {

        List<Employee> collect = employeeList.stream()
            .sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
        System.out.println("按名字生序，员工信息如下：：" + collect);


    }

    //获取工资最高的前2条员工信息
    public static void findThe2HeadOfHightSalaryPerson() {
        List<Employee> collect = employeeList.stream()
            .sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary())).limit(2)
            .collect(Collectors.toList());
        System.out.println("按名字生序，员工信息如下：：" + collect);
    }

    //        //获取所有员工平均工资
    public static void getAllPersonAvarageSalary() {
        Double collect = employeeList.stream().map(employee -> employee.getSalary())
            .collect(Collectors.averagingLong(e1 -> e1.longValue()));

        OptionalDouble average = employeeList.stream().mapToInt(e1 -> e1.getSalary()).average();

        System.out.println("所有员工平均工资如下：：" + collect + "---------" + average);
    }

    //查找New York办公室的平均工资
    public static void getSomeOfficePersonAvarageSalary() {
        OptionalDouble average = employeeList.stream().filter(employee -> employee.getOffice().equals("New York")).mapToInt(e1 -> e1.getSalary()).average();

        System.out.println("New York办公室员工平均工资如下：：" + average.getAsDouble()+"-----"+String.format("%.2f", average.getAsDouble()));
    }

    public static void groupByOffice() {
        Map<String, List<Employee>> collect = employeeList.stream()
            .collect(Collectors.groupingBy(e1 -> e1.getOffice()));
        System.out.println("按办公室员区分人员信息：：" + collect);
        Collection<List<Employee>> values = collect.values();
        ArrayList<Employee> objects = new ArrayList<>();
        for (List<Employee> em:values){
            objects.addAll(em);
        }
        for (Employee e:objects) {
            System.out.println(e);
        }
    }
}
