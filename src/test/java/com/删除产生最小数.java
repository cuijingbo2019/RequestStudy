package com;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;

/**
 * @author cuijingbo
 * @date 2021/6/22 16:01
 */
public class 删除产生最小数 {


    public static void main(String[] args) {
        String num="1527394";
        int k=3;
        for (int i=0;i<k;i++){
            boolean a=false;
            for (int j=0;j<num.length()-1;j++){
                if (num.charAt(j)>num.charAt(j+1)){
                    num=num.substring(0,j)+num.substring(j+1,num.length());
                    a=true;
                    break;
                }
            }
            System.out.println("-------------"+num);
            if (!a){
                num=num.substring(0,num.length()-1);
            }
            if (num.length()==0){
                num="0";
            }

        }

        System.out.println(num);
    }

}
