package com;

import java.util.Stack;

/**
 * @author cuijingbo
 * @date 2021/6/21 15:51
 */

/*
数据入栈、出栈 问题
 */
public class Minstack {
    //定义2个stack
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    //入栈操作
    public void push(int element){
        mainStack.push(element);
        //如果辅助栈为空，或者添加的值小于等于辅助栈顶值
        if (minStack.empty()||element<=minStack.peek()){
            //把小的数放入栈
            minStack.push(element);
        }
    }

    //出栈操作
    public Integer pop(){
        //如果出栈数值与辅助栈顶，顶值相同，辅助栈出栈
        if (mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    //寻找最小值
    public int getmin() throws Exception {
        if (mainStack.empty()){
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }


    public static void main(String[] args) throws Exception {
        Minstack stack=new Minstack();
        stack.push(4);
        stack.push(5);
        stack.push(9);
        stack.push(3);
        System.out.println(stack.getmin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getmin());
    }

}
