package com.utils;
/**
 * 字符串工具类
 *
*
* */


public class StringUtil {
    public static boolean isEmpty(String str){
        if("".equals(str)||str==null){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isNotEmtpty(String str){
        if(!"".equals(str)&&str!=null){
            return true;
        }else{
            return false;
        }
    }

}
