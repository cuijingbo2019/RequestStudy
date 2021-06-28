package com;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author cuijingbo
 * @date 2021/6/11 17:58
 */
public class 去除重复数 {

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i = i + 1;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] a={1,1,2,3,4,5};
        System.out.println(removeDuplicates(a));

    }

}
