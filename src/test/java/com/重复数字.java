package com;

import java.awt.*;
import java.awt.print.Printable;
import java.sql.SQLOutput;
import java.util.HashMap;

/**
 * @author cuijingbo
 * @date 2021/6/23 17:46
 */
public class 重复数字 {
    public static void main(String[] args) {
        int[] a={1,2,3,5,2,2,2,3,2,34,3,2,4};
        int z=0;
        for (int i=0;i<a.length;i++){
            for (int j=i+1;j<a.length;j++) {
                if (a[i] != z) {
                    z = a[i];
                }
            }
        }
        System.out.printf("重复数字为%d",z);
    }

}

