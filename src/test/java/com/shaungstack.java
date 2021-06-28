package com;

import com.sun.glass.utils.NativeLibLoader;
import sun.invoke.empty.Empty;

import java.util.Stack;

/**
 * @author cuijingbo
 * @date 2021/6/21 19:01
 */
public class shaungstack {
    private Stack<Integer> stackA =new Stack<>();
    private Stack<Integer> stackB =new Stack<>();

    //先进A，然后从A出后，入B
   public void inA( int element){
       stackA.push(element);
   }
   //从A出，进入B
   public Integer outB(){
       if (stackB.isEmpty()){
           if (stackA.isEmpty()){
               return null;
           }
           while (!stackA.isEmpty()){  //如果A不为空，则把A出的值放到B中
               stackB.push(stackA.pop());
           }
       }
       return stackB.pop();  //返回B出的值
   }

    public static void main(String[] args) {
        shaungstack  test=new  shaungstack();
        test.inA(1);
        test.inA(2);
        test.inA(5);
        test.inA(7);
        System.out.println(test.outB());
    }


}
