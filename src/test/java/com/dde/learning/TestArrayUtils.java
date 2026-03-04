package com.dde.learning;

import com.dde.learning.数组.ArrayUtils;

import java.util.Arrays;
public class TestArrayUtils {

    public static void main(String[] args) {

        // 1️⃣ 测试字母
        char[] letters = ArrayUtils.getUpperCaseLetters();
        System.out.println("字母列表: " + Arrays.toString(letters));

        // 2️⃣ 测试最大值
        int[] data = {1, 3, 5, 7, 89, 32, 11};

        ArrayUtils.MaxResult maxResult = ArrayUtils.getMaxNumberAndIndex(data);
        System.out.println("最大值: " + maxResult.value() + " 下标: " + maxResult.index());

        // 3️⃣ 测试平均值
        double avg = ArrayUtils.getAverageValue(data);
        System.out.printf("平均值: %.2f%n", avg);
    }
}