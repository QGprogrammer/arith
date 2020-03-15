package com.ven.arith.offer;

/**
 * 替换空格
 * @author wangwenwen
 * @date 2020/3/5 17:30
 * @version v1.0.0
 */
/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
We Are Happy
We%20Are%20Happy
           Happy
 */
public class Demo2 {

    public static void main(String[] args) {
        System.out.println(new Demo2().replaceSpace2(new StringBuffer(" ")));

    }

    /**
     * 运行时间：18ms
     * 占用内存：9328k
     * @param str
     * @return
     */
    public String replaceSpace1(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    /**
     * 运行时间：157ms
     * 占用内存：16120k
     * @param str
     * @return
     */
    public String replaceSpace2(StringBuffer str) {
        //lambda表达式性能损耗大 替换掉 运行时间会控制在19ms左右
        int count = (int)str.chars().filter(value -> value == ' ').count();
        /*
        String str1 = str.toString();
        if(str1.equals(""))
            return str1;
        char [] strArray = str1.toCharArray();
        int i =0;
        int count = 0;
        while(i < strArray.length){
            if(strArray[i] == ' ')
                count++;
            i++;
        }
         */
        char[] chars = str.toString().toCharArray();
        StringBuffer sb = new StringBuffer(str.length() + 2 * count);
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     *运行时间：19ms
     * 占用内存：9536k
     * @param str
     * @return
     */
    public String replaceSpace3(StringBuffer str) {
        String str1 = str.toString();
        if(str1.equals(""))
            return str1;
        char [] strArray = str1.toCharArray();
        int i =0;
        int lengthSpace = 0;
        while(i < strArray.length){
            if(strArray[i] == ' ')
                lengthSpace++;
            i++;
        }
        int newStrLength = strArray.length + lengthSpace*2;
        char [] newStr = new char[newStrLength];
        int j = newStrLength-1;
        i = strArray.length - 1;
        while(i >= 0){
            if(strArray[i] !=  ' '){
                newStr[j--] = strArray[i--];
            }else{
                newStr[j--] = '0';
                newStr[j--] = '2';
                newStr[j--] = '%';
                i--;
            }
        }
        return new String(newStr);
    }

}


