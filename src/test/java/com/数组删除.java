package com;

/**
 * @author cuijingbo
 * @date 2021/6/15 18:56
 */
public class 数组删除 {

    public static void delete(int index){
        int[] array={1,4,5,6,78,0};
        for (int i=0;i<array.length;i++){
          //  System.out.println(array[i]);
        }
        int size=6;
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException("元素越界");
        }
        int deleteElement =array[index];
        for (int i=index;i<size-1;i++){
            array[i]=array[i+1];
            System.out.println(array[i]);
            System.out.println(array[i+1]);
        }
        size--;
        for (int i=0;i<array.length;i++){
          //  System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        delete(3);
    }
}
