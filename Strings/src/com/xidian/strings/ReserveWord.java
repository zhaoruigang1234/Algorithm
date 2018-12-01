package com.xidian.strings;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 反转字符串
 */
public class ReserveWord {
    public String reverseWord(String str) {
        //下面这个条件判断就是针对整个字符串都是空格的情况，注意，这时不能用trim函数给人家都撸了！！！此时要求有几个空格就输出
        //几个空格
        if (str.length() != 0 && str.trim().length() == 0) {
            String temp = "";
            for (int i = 0; i < str.length(); i++) {
                temp += " ";
            }
            return temp;
        }

        String strProcess = str.trim();
        String res = "";
        if (strProcess == null || strProcess.length() == 0) {
            return res;
        }
        String[] data = strProcess.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
            res += " ";
        }
        return res.trim();
    }

    @Test
    public void test() {
        String str = "student. a I'm ";
        System.out.print(reverseWord(str));
    }

    @Test
    public void test2() {
        PriorityQueue queue = new PriorityQueue(new MyComparator());
        queue.add(7);
        queue.add(3);
        queue.add(5);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}