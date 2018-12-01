package com.xidian.zuo;

import org.junit.Test;

import java.util.Stack;

/**
 * 仅用递归函数和栈结构实现一个栈结构的反转操作
 */
public class ReserveStack {
    public int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);

        System.out.println(stack.push(i));
    }
    @Test
    public void test(){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        ReserveStack stack1 = new ReserveStack();
        stack1.reverse(stack);
    }
}
