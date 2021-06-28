package com;

import java.util.Arrays;

/**
 * @author cuijingbo
 * @date 2021/6/18 14:11
 */

//双边循环方法
public class quick双边循环 {
     public static void quickSort(int[] arr, int startIndex, int endIndex) {
         // 递归结束条件：startIndex大于或等于endIndex时
         if (startIndex >= endIndex) {
             return;
             }
        // 得到基准元素位置
         int pivotIndex = partition(arr, startIndex, endIndex);
         // 根据基准元素，分成两部分进行递归排序
         //左半部分，0~left-1
         quickSort(arr, startIndex, pivotIndex - 1);
         //右半部分，left+1~end
         quickSort(arr, pivotIndex + 1, endIndex);
     }


 //控制left指针比较并右移
    private static int partition(int[] arr, int startIndex, int endIndex) {
         // 取第1个位置（也可以选择随机位置）的元素作为基准元素
         int pivot = arr[startIndex];
         int left = startIndex;
         int right = endIndex;

         while( left != right) {
        //控制right 指针比较,并向左移
            while(left<right && arr[right] > pivot){
                 right--;
             }
         //控制left 指针比较并右移
             while( left<right && arr[left] <= pivot) {
                left++;
            }
         //当交换left和right,指针所指向的元素
            if(left<right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
                }
        }
         //pivot 和指针重合点,就是index 所在位置，把pivot值放到index中
         arr[startIndex] = arr[left];
         arr[left] = pivot;
         System.out.println(left);
         return left;
    }


    public static void main(String[] args) {
        int[] array={1,8,4,7,9,5};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
