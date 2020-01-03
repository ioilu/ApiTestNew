package com.mytest.cases;

import com.mytest.service.OkHttpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;
import java.util.HashMap;


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
        HashMap<String, Object> paramMap=new HashMap<>();
        paramMap.put("","");
        paramMap.put("","");

        String result=okHttpService.doPost(host,api,paramMap,header);
        System.out.println(result);

        }
}
