package com.ven.arith.offer;

/**
 * 二维数组的查找
 * @author wangwenwen
 * @date 2020/3/2 17:06
 * @version v1.0.0
 */
/*
题目描述：
在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。
 */
public class Demo1 {
    public static void main(String[] args) {
        int[][] array1 = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target1 = 7;
        System.out.println(new Demo1().Find1(target1, array1));
    }

    //case pass rate 58.82%
    //example [1,2,6,7],[2,3,10,12] target 10
    public boolean Find1(int target, int [][] array) {
        int length = array[0].length;
        int index = -1;

        if (length == 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (target == array[0][i]) {
                return true;
            } else if (target < array[0][i]){
                index = i - 1 < 0 ? 0 : i -1;
                break;
            } else {
                index++;
            }
        }

        for (int j = 0; j < array.length; j++) {
            if (array[j][index] == target) {
                return true;
            }
        }

        return false;
    }

    public boolean Find2(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int rows = array.length;
        int cols = array[0].length;

        int r = 0;
        int c = cols - 1;

        while (r < rows && c >= 0) {
            if (target == array[r][c]) {
                return  true;
            } else if (target > array[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

}
