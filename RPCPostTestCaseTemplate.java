package com.mytest.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mytest.service.OkHttpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;
import java.util.HashMap;

/**
 * rpc类型的接口的请求参数：{"jsonrpc":"2.0", "id":"1", "method":"userRegister", "params":[{"loginCode":"aa","loginPassword":"bb"}]}
 * header：json
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class $!{FuncationName}Test{
@Autowired
        OkHttpService okHttpService;

private String host="${host}";
private String api="${api}";
private String header="${header}";

@Test
public void CorrectCase()throws IOException{
        /**
         * 需要根据参数确实使用开发的对象构造参数或者用hashMap来存放参数
         */
//        举例
//        User user = new User();
//        user.setId(1);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("jsonrpc","2.0");
        jsonObject.put("id","1");
        jsonObject.put("method","userRegister");
        jsonObject.put("params",请传入变量);

        HashMap<String,Object> paramMap = JSON.parseObject(jsonObject.toJSONString(),HashMap.class);

        String result=okHttpService.doPost(host,api,paramMap,header);
        System.out.println(result);
        }
}
