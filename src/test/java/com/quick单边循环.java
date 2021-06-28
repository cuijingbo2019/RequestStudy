package com;

import java.util.Arrays;

/**
 * @author cuijingbo
 * @date 2021/6/18 14:25
 */
public class quick单边循环 {

    public static void quick(int[] array,int startindex,int endindex){
        if (startindex>endindex){
            return;
        }
        int pivotindex=pattan(array,startindex,endindex);
        quick(array,startindex,pivotindex-1);
        quick(array,pivotindex+1,endindex);

    }

    public static int pattan(int[] array, int startindex,int endidex){
        //基准元素确定
        int pivot=array[startindex];
        //maxt为起始index
        int maxt=startindex;

        /*
        循环数组，找到比基准元素小的数
        1、起始元素后移一位
        2、起始元素和小于基准的数值互换
         */
        for (int i=startindex+1;i<=endidex;i++){
            if (array[i]<pivot){
                maxt++;
                int x=array[i];
                array[i]=array[maxt];
                array[maxt]=x;
                System.out.println(maxt);
            }
        }
        //循环结束后，交换pivot和maxt的值
        array[startindex]=array[maxt];
        array[maxt]=pivot;
        return maxt;
    }

    public static void main(String[] args) {
        int[] arry={1,23,5,21,4,2};
        quick(arry,0,arry.length-1);
        System.out.println(Arrays.toString(arry));
    }

}
