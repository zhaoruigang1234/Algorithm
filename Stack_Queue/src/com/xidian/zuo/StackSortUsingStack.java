package com.xidian.zuo;

import org.junit.Test;

import java.util.Stack;

/**
 * 借助另外一个栈结构实现一个栈结构的排序操作
 */
public class StackSortUsingStack {
    public Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();//定义辅助空间
        if (stack.isEmpty()) {
            return null;
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();//每次从stack栈中弹出一个元素，把它用一个临时变量保存下来，并且把它放入temp栈中的合适位置。
            if (temp.isEmpty()) {//第一个元素，temp栈为空，所以无论元素大小直接将其放入temp中
                temp.push(cur);
            } else {
                if (cur <= temp.peek()) {//当temp栈不为空时，放入每个之前都和temp栈顶元素比较，如果这个元素小于等于栈顶元素，则符合顺序，直接压入栈中
                    temp.push(cur);
                } else {//如果当前元素大于栈顶元素，那么就将temp中所有小于当前元素的值都放入到stack栈中，这些导出去的元素进入stack中进行下一次判断，再次进入temp中
                    while (!temp.isEmpty() && cur > temp.peek()) {//这里导数存在两个终止条件，要么当前值小于等于temp栈顶元素了；要么这个值比temp中的所有值都大，
                        // 那么temp栈中所有的值都倒入stack中了，也就是temp空了，那么就将当前值压入temp栈底。
                        stack.push(temp.pop());
                    }
                    temp.push(cur);//所有不符合顺序的元素都腾出去之后，将当前元素压入temp中。
                }
            }
        }
        return temp;
    }

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(6);
        stack.push(3);
        stack.push(2);
        stack.push(9);
        Stack<Integer> res = sortStack(stack);
        while (!res.isEmpty()) {
            System.out.println(res.pop());
        }
    }
}
