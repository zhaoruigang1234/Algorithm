package com.xidian.zuo;

import org.junit.Test;

import java.util.Stack;

/**
 * 用两个栈来组成一个队列结构
 * 思路：数据push到一个固定的栈中，然后从另外一个固定的栈中去pop。数据中途由一个栈导入另一栈中
 * 导数据的条件：1）pop栈中有数据时，向其不能倒入数据 2）push往出倒的时候一次性倒尽，不能保留
 */

public class QueueComByStack {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public void add(int obj) {
        pushStack.push(obj);
    }

    //导数据函数，前提是popStack为空才能倒，而且一次性将pushStack中的元素倒尽
    public void dao() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public int poll() {
        dao();
        if (popStack.isEmpty()) {
            throw new IllegalArgumentException("队列为空！");
        }
        return popStack.pop();
    }

    public int peak() {
        dao();
        if (popStack.isEmpty()) {
            throw new IllegalArgumentException("队列为空！");
        }
        int temp = popStack.pop();
        popStack.push(temp);
        return temp;
    }

    @Test
    public void test() {
        QueueComByStack queue = new QueueComByStack();
        queue.add(1);
        queue.add(5);
        queue.add(2);
        queue.add(4);
        System.out.println(queue.poll());
        System.out.println(queue.peak());
    }
}
