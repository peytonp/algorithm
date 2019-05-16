package LeetCode;

import java.util.HashSet;

/**
 * @ClassName LongestCommonPrefix_14
 * @Author xy
 * @Date 2019/4/1011:08
 * @Version 1.0
 */
public class LongestCommonPrefix_14 {
    /**
     * @FunctionName: longestCommonPrefix
     * @Description: 判断数组字符串中的最大共同前缀
     * @Author: xy
     * @Date: 2019/4/10 11:33
     * @Version: 1.0
     * @Param: [strs]
     * @Return: java.lang.String
     */
    public static String longestCommonPrefix(String[] strs){
        if(strs.length==0) return "";
        String prefix=strs[0];
        //遍历所有的字符串
        for(int i=1;i<strs.length;i++){
            //如果包含前缀则换下一个字符串，如果不包含前缀则截取前缀减1，
            while (strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.length()==0) return "";
            }
        }
        return prefix;
    }

}
