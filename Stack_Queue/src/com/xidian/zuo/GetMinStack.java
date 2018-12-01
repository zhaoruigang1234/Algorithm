package com.xidian.zuo;

import org.junit.Test;

import java.util.Stack;

/**
 * 设计一个具有返回当前栈中最小值的栈结构
 * 思路：定义两个栈结构，一个用来操作正常的数据DataStack，另外一个用来操作数据中的最小值MinStack
 */
public class GetMinStack {
    Stack<Integer> DataStack = new Stack<>();
    Stack<Integer> MinStack = new Stack<>();

    public void push(int obj) {
        if (MinStack.isEmpty()) {
            MinStack.push(obj);
        } else {
            int temp = MinStack.peek();
            if (temp < obj) {
                MinStack.push(temp);
            } else {
                MinStack.push(obj);
            }
        }
        DataStack.push(obj);//将数据正常压入到数据栈中
    }

    public int pop() {
        if (DataStack.isEmpty()) {
            throw new IllegalArgumentException("目标栈为空！");
        }
        MinStack.pop();
        return DataStack.pop();
    }

    public int getMin() {
        if (MinStack.isEmpty()) {
            throw new IllegalArgumentException("栈为空！");
        }
        return MinStack.peek();
    }

    @Test
    public void test() {
        GetMinStack stack = new GetMinStack();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(8);
        System.out.println(stack.getMin());
    }
}
