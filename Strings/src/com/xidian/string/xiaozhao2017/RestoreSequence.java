package com.xidian.string.xiaozhao2017;

import java.util.Scanner;
import java.util.Stack;

public class RestoreSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        String[] data = line1.split(" ");
        System.out.println(correctSequence(data[0], data[1], line2));
    }

    private static Stack<Integer> zeroIndex = new Stack<>();
    private static Stack<Integer> unZeroIndex = new Stack<>();
    private static Stack<Integer> zeroIndex2 = new Stack<>();

    public static int correctSequence(String n, String k, String obj) {
        int count = 0;
        int area = Integer.valueOf(n);
        int correctCounter = Integer.valueOf(k);
        String[] data = obj.split(" ");
        int[] str = new int[data.length];
        int len = str.length;

        for (int i = 0; i < len; i++) {
            str[i] = Integer.valueOf(data[i]);
            if (str[i] == 0) {
                zeroIndex.add(i);
            } else {
                unZeroIndex.add(i);
            }
        }

        for (int i = zeroIndex.size() - 1; i >= 0; i--) {
            zeroIndex2.push(i);
        }
        //构造所有的情况
        int[] allArray = new int[len];

        //利用一个一维数组实现
        int[] allValue = new int[len];
        int[] pointer = new int[zeroIndex.size()];
        int pos = 0;
        //初始化可能的取值:1-n 的所有值
        for (int i = 1; i <= len; i++) {
            allValue[i] = i;
            pointer[pos++] = 0;
        }


        int number = 0;
        int counter = 0;
        int value = 1;


        //操作不为0的位置元素


        while (number < (int) Math.pow(area, str.length)) {


            //操作为0的位置元素
            while (!zeroIndex.isEmpty()) {
                allArray[zeroIndex.peek()] = value;
                counter++;
                if (counter == (int) Math.pow(area, zeroIndex2.peek())) {
                    value++;
                    counter = 0;
                }
                if (value == area) {
                    value = 1;
                }
                zeroIndex.pop();
                zeroIndex2.pop();
            }

            int temp = gtCounter(allArray);
            if (temp == correctCounter) {
                count++;
            }
            number++;
        }


//        for(int i = 0;i<allArray.length;i++){
//            System.out.println();
//            for(int j = 0;j<allArray[0].length;j++){
//                System.out.print(allArray[i][j]+" ");
//            }
//        }


        return count;
    }

//    public static int[] getVlaue(int number) {
//        int[] res = new int[zeroIndex.size()];
//
//        return res;
//    }

    public static int gtCounter(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
