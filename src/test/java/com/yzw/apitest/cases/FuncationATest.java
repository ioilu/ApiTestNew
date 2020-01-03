package com.yzw.apitest.cases;

import com.yzw.apitest.service.OkHttpService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class FuncationATest  {
    @Autowired
    OkHttpService okHttpService;

    String host = "${host}";
    String api = "${api}";
    String header = "${header}";
    @Test
    public void noParams() throws IOException {
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("","");
        okHttpService.doPost(host,api,paramMap,header);
        System.out.println();
    }

}
