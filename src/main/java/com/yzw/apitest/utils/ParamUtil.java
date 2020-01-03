package com.yzw.apitest.utils;

import java.util.HashMap;

public class ParamUtil {
    public static String urlString(HashMap<String,String> paramMap){
        String result = "?";
        for(String key : paramMap.keySet()){
            result = result + key + "=" + paramMap.get(key)+ "&";
        }
        result = result.substring(0,result.length()-1);
        return result;
    }

    public static void main(String[] args) {
        HashMap<String,String> a = new HashMap<String,String>();
        a.put("a","a");
        a.put("b","b");
        a.put("c","c");
        a.put("d","d");


        System.out.println(        ParamUtil.urlString( a));
    }
}
