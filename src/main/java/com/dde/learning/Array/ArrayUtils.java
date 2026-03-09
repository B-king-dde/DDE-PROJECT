package com.dde.learning.Array;


import java.util.Arrays;

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
     *
     * @param data 数据
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
     * 冒泡排序
     *
     * @param data 数组
     */
    public static void bubbleSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 二分查找
     *
     * @param data   数组
     * @param target 目标数
     * @return 目标数在数组中的下标
     */
    public static int binarySearch(int[] data, int target) {

        int left = 0;
        int right = data.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (data[mid] == target) {
                return mid;
            }

            if (target > data[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 获取二维数组的和
     *
     * @param data 数据
     * @return 结果
     */
    public static int sumOfTwoDimensionalArrays(int[][] data) {
        int sum = 0;
        for (int[] datum : data) {
            for (int j = 0; j < datum.length; j++) {
                sum += datum[j];
            }

        }
        return sum;
    }

    /**
     * 在升序数组中插入一个数
     *
     * @param data  数组（必须已按升序排列）
     * @param value 要插入的数
     * @return 插入新元素后的升序数组
     */
    public static int[] insertInToSortedArray(int[] data, int value) {
        validateArray(data);

        int[] newData = Arrays.copyOf(data, data.length + 1);

        // 找到第一个大于 value 的位置
        int insertIndex = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > value) {
                insertIndex = i;
                break;
            }
            // 如果 value 大于等于所有元素，插到最后
            if (i == data.length - 1) {
                insertIndex = data.length;
            }
        }

        // 复制 insertIndex 之前的元素
        for (int i = 0; i < insertIndex; i++) {
            newData[i] = data[i];
        }

        // 插入新元素
        newData[insertIndex] = value;

        // 复制 insertIndex 之后的元素
        for (int i = insertIndex; i < data.length; i++) {
            newData[i + 1] = data[i];
        }

        return newData;
    }

    public static void forTest(int target) {
        // 随机生成 int 数组
        int[] data = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 10);
        }
        
        // 降序排序（从大到小）
        for (int i = 0; i < data.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] < data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println("降序后数组：" + Arrays.toString(data));
        
        // 二分查找（降序数组）
        int left = 0;
        int right = data.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (data[mid] == target) {
                System.out.println("存在目标数：" + target + "，下标：" + mid);
                found = true;
                break;
            }
            
            // 降序数组：左边大，右边小
            if (target > data[mid]) {
                // 目标数更大，往左边找（左边是大数区域）
                right = mid - 1;
            } else {
                // 目标数更小，往右边找（右边是小数区域）
                left = mid + 1;
            }
        }
        
        if (!found) {
            System.out.println("未找到目标数：" + target);
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