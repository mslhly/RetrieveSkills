package com.msl.stream;

import java.util.Arrays;

/**
 * Created by msl on 2019/2/27.
 */
public class StreamTest {

    public static void main(String[] args) {

        Integer[] sortSZ = {10,40,9,23,44,99,2};
        int temp = 0;
        for (int i = 0; i < sortSZ.length-1; i++) {
            for (int j = 0; j <sortSZ.length-1-i ; j++) {
                if (sortSZ[j]>sortSZ[j+1]){
                    temp=sortSZ[j];
                    sortSZ[j] = sortSZ[j+1];
                    sortSZ[j+1] = temp;
                    Arrays.asList(sortSZ).forEach(item-> System.out.println(item));
                    System.out.println("------------");
                }
            }
        }
        System.out.println("------------");
        Arrays.asList(sortSZ).forEach(item-> System.out.println(item));
        
    }



}
