package com.dde.learning;

import com.dde.learning.Array.ArrayUtils;

import java.util.Arrays;

public class TestArrayUtils {

    public static void main(String[] args) {

        // 1️⃣ 测试字母
        char[] letters = ArrayUtils.getUpperCaseLetters();
        System.out.println("字母列表: " + Arrays.toString(letters));

        // 2️⃣ 测试最大值
        int[] data = {1, 3, 5, 7, 89, 32, 11, 2, 4, 55};

        ArrayUtils.MaxResult maxResult = ArrayUtils.getMaxNumberAndIndex(data);
        System.out.println("最大值: " + maxResult.value() + " 下标: " + maxResult.index());

        // 3️⃣ 测试平均值
        double avg = ArrayUtils.getAverageValue(data);
        System.out.printf("平均值: %.2f%n", avg);


        Integer[] data1 = {1, 2, 3, 4, 5};
        ArrayUtils.arrayReversal(data1);
        System.out.println("翻转数组：" + Arrays.toString(data1));

        ArrayUtils.bubbleSort(data);
        System.out.println("冒泡排序后数组：" + Arrays.toString(data));

        int[] data2= {1, 3, 5, 7, 89, 32, 11, 2, 4, 55};
        System.out.println("目标数下标:"+ArrayUtils.binarySearch(data2,89));
    }
}