package com.xidian.zuo;

import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 利用双端队列来确定最大窗口值
 * 最大窗口：给定一个数组，从头开始，以固定的窗口宽度圈定其中的元素。窗口每次往后移动一个元素的长度。这样总共形成：n-w+1个窗口
 * n为数组长度，w为窗口宽度。要求的就是这所有的窗口中，每个窗口中包含的最大元素值。
 */
public class MaxWindows {
    public ArrayList<Integer> getMaxWindows(int[] obj, int width) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> maxIndexQueue = new LinkedList<>();
        //遍历数组中的元素，一次取出一个元素进行操作
        for (int i = 0; i < obj.length; i++) {
            //若最大索引队列为空，也就是第一个元素到来时，直接将元素的下标放入队列中
            if (maxIndexQueue.isEmpty()) {
                maxIndexQueue.addLast(i);
            } else {//若最大索引队列中已经有元素了，那么就要分情况来处理当前元素的索引值了
                if (obj[i] < obj[maxIndexQueue.getLast()]) {//如果当前元素的值小于队尾索引处的值，那么就将当前索引加到队尾
                    maxIndexQueue.addLast(i);
                } else {//如果当前值大于等于队尾索引处的值，那么就从当前队尾元素开始往外弹数据，直到当前元素的值小于队尾索引处的值，
                    // 或者是队列弹成空队列。其实这里与用一个栈实现另外一个栈的排序这个题的思路差不多，都是通过两个集合中的数据比较倒腾。
                    while (!maxIndexQueue.isEmpty() && obj[i] >= obj[maxIndexQueue.getLast()]) {
                        maxIndexQueue.removeLast();
                    }
                    maxIndexQueue.addLast(i);//将当前索引加入到弹完元素的队列中，也就是说这时给当前索引找到了一个合适的位置。
                }
            }

            //当值大于等于窗口宽度时，每次都会形成一个窗口
            if (i >= width - 1) {
                //注意：这里还需要判断当前最大索引队列的头结点有没有过期，也就是当前索引有没有超过它的作用范围。
                if (i > maxIndexQueue.getFirst() + width - 1) {
                    maxIndexQueue.removeFirst();
                }
                res.add(obj[maxIndexQueue.getFirst()]);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        ArrayList<Integer> res = getMaxWindows(arr, 3);
        for (Integer ele : res
                ) {
            System.out.println(ele);
        }
    }
}

