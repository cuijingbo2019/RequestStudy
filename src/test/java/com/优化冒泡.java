package com;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author cuijingbo
 * @date 2021/6/18 11:24
 */
public class 优化冒泡 {
    public static void sort(int array[]){
        int lastExchangeIndex=0;
        int sortBoder=array.length-1;
        for (int i=0;i<array.length-1;i++){
            boolean isSorted=true;
            for (int j=0;j<sortBoder;j++){
                System.out.println("----ss------"+j);
                System.out.println("ssss"+sortBoder);
                int tmp=0;
                if(array[j]<array[j+1]){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    isSorted=false;
                    lastExchangeIndex=j;
                }
            }
            sortBoder=lastExchangeIndex;
            System.out.println(sortBoder);
            if (isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int array[]={9,8,7,5,3,6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }


}
