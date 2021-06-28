package com;

/**
 * @author cuijingbo
 * @date 2021/6/23 16:26
 */
public class Search_Bin {
    //二分查找法，只对已排好的数组最快查找
    public static void main(String[] args) {
        int[] a={1,3,7,22,33,99,180};
        System.out.println(Search_Bin.index(a, 22));

    }
    public static int index(int[] a, int b){

        int low=0;
        int hight=a.length;
        //当low和hight 不相等时
        while (low<hight){
            //取中间值为基准点
            int mid=(low+hight)/2;
            //查找元素=基准，直接返回
            if (b==a[mid]){
                return mid;
                //查找元素小于基准值，从【low,mid-1】中查找
            }else if (b<a[mid]){
                hight=mid-1;
                //查找元素大于基准值，从[mid+1,hight]中查找
            }else {
                low=mid+1;
            }
        }
        //当low=hight时，说明不存在，返回0
        return 0;
    }

}

