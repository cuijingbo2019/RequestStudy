package com;

/**
 * @author cuijingbo
 * @date 2021/6/21 16:20
 */
public class 最大公约数 {
    public static void main(String[] args) {
        int a=20;
        int b=50;
        int x=a>>1;
        System.out.println(x);
        int big=a>b ? a:b;//2个数中最大的
        int small=a<b ? a:b; //2个数中最小的
        if(big%small==0){
            System.out.println(small);
        }
        System.out.println("-----------");
        for (int i=small/2;i>1;i--){
            if (small%i==0 && big%i==0){
                System.out.println(i);
                break;
            }
        }

    }
}
