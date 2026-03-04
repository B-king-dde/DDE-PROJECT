package com.dde.learning.Array;


/**
 * @author DDE
 * 数组工具类
 */
public final class ArrayUtils {

    // 防止被实例化
    private ArrayUtils() {
        throw new UnsupportedOperationException("工具类不能被实例化");
    }

    /**
     * 获取 A-Z 26 个大写字母
     */
    public static char[] getUpperCaseLetters() {
        char start = 'A';
        char end = 'Z';

        char[] letters = new char[end - start + 1];

        for (int i = 0; i < letters.length; i++) {
            letters[i] = (char) (start + i);
        }

        return letters;
    }

    /**
     * 获取数组最大值及其下标
     */
    public static MaxResult getMaxNumberAndIndex(int[] data) {

        validateArray(data);

        int maxNumber = data[0];
        int index = 0;

        for (int i = 1; i < data.length; i++) {
            if (data[i] > maxNumber) {
                maxNumber = data[i];
                index = i;
            }
        }

        return new MaxResult(maxNumber, index);
    }

    /**
     * 求数组平均值（防溢出 + 精度保留）
     */
    public static double getAverageValue(int[] data) {

        validateArray(data);

        long totalValue = 0; // 防止溢出

        for (int value : data) {
            totalValue += value;
        }

        return (double) totalValue / data.length;
    }

    /**
     * 数组翻转
     * @param data 数据
     * @return 结果
     */
    public static <T> void arrayReversal(T[] data) {
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            T temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 数组统一校验
     */
    private static void validateArray(int[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
    }

    /**
     * 最大值结果封装
     */
    public record MaxResult(int value, int index) {
    }
}