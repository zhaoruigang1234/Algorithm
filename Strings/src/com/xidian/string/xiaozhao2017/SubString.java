package com.xidian.string.xiaozhao2017;
/**
 * 牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒，藏宝盒上有一个机关，机关每次会显示两个字符串 s 和 t，
 * 根据古老的传说，牛牛需要每次都回答 t 是否是 s 的子序列。
 * 注意，子序列不要求在原字符串中是连续的，例如串 abc，它的子序列就有 {空串, a, b, c, ab, ac, bc, abc} 8 种。
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例包含两行长度不超过 10 的不包含空格的可见 ASCII 字符串。
 * 输出描述:
 * 输出一行 “Yes” 或者 “No” 表示结果。
 *
 * 输入: x.nowcoder.com
 *       ooo
 * 输出: Yes
 */

import java.util.Scanner;
import java.util.Stack;

public class SubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String objStr = scanner.nextLine();
        String subStr = scanner.nextLine();
        boolean res = isSub(objStr,subStr);
        if(res==true){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    public static boolean isSub(String str1,String str2){
        Stack<Character> objStack = new Stack<>();
        Stack<Character> subStack = new Stack<>();
        int len1 = str1.length();
        int len2 = str2.length();
        //构造两个栈结构,用栈结构来对子串进行匹配
        for(int i = len1-1;i>=0;i--){
            objStack.push(str1.charAt(i));
        }
        for(int i = len2-1;i>=0;i--){
            subStack.push(str2.charAt(i));
        }
        while(!objStack.isEmpty()&&!subStack.isEmpty()){
            if(subStack.peek()==objStack.peek()){//如果子串的第一个元素和目标串的第一个元素匹配，则进行下一个字符的匹配
                subStack.pop();
                objStack.pop();
            }else{
                objStack.pop();//如果不匹配，那么就从目标串中往下找
            }
        }

        if(objStack.isEmpty()&&!subStack.isEmpty()){
           return false;//当子串中的一个字符找不到对应的匹配，返回false
        }else {
            return true;

        }
    }
}
