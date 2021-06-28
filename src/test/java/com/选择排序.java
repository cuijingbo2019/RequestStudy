package com;

import com.jayway.jsonpath.internal.function.numeric.Min;

/**
 * @author cuijingbo
 * @date 2021/6/23 16:08
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] a={2,22,3,1,99,7};

        //比较N-1轮，a[i]从第1个，到第length-1
        for (int i=0;i<a.length-1;i++){
            int min=i;
            //每轮需要比较的次数，n-1;a[j]从第2个到最后一个
            for (int j=i+1;j<a.length;j++){
                //如果出现比a[min]小的，把min的值进行替换
                if (a[j]<a[min]){
                       min=j;
                }
            }
            //最终找到最小的值，和i的位置进行交换
            if(i !=min){
                int tmp=a[i];
                a[i]=a[min];
                a[min]=tmp;
            }
        }

        for (int i:a){
            System.out.println(i);
        }
    }
}
