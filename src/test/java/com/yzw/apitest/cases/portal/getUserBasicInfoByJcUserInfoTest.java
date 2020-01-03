package com.yzw.apitest.cases.portal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yzw.apitest.service.OkHttpService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class getUserBasicInfoByJcUserInfoTest {
        @Autowired
        OkHttpService okHttpService;

        private String host = "http://172.16.30.234:8080";
        private String api = "/ms/userInfo/getUserBasicInfoByJcUserInfo";
        private String header = "application/json;charset=UTF-8";

        /**
         * 参数传递：不存在的用户名和用户ID
         * 结果：查不到数据
         * @throws IOException
         */
        @Test
        public void Case1() throws IOException {
                HashMap<String, Object> paramMap = new HashMap<>();
                paramMap.put("userId", "1");
                paramMap.put("loginName", "1");

                String result = okHttpService.doPost(host, api, paramMap, header);

                System.out.println(result);
                Assert.assertEquals("",result);
                Assert.assertEquals(0,result.length());

        }

        /**
         * 参数：不传参数
         * 结果：报500错误
         * @throws IOException
         */
        @Test
        public void Case2() throws IOException {
                HashMap<String, Object> paramMap = new HashMap<>();

                String result = okHttpService.doPost(host, api, paramMap, header);

                System.out.println(result);
                JSONObject jsonObject = new JSONObject();
                jsonObject = JSON.parseObject(result);
                Assert.assertEquals("500",jsonObject.getString("status"));

        }

        /**
         * 参数传递：两个参数值为空，传了不需要的参数
         * 结果：报500错误
         * @throws IOException
         */
        @Test
        public void Case3() throws IOException {
                HashMap<String, Object> paramMap = new HashMap<>();
                paramMap.put("userId", "148455");

                String result = okHttpService.doPost(host, api, paramMap, header);
                System.out.println(result);
                JSONObject jsonObject = new JSONObject();
                jsonObject = JSON.parseObject(result);
                Assert.assertEquals("500",jsonObject.getString("status"));

        }


        @Test
        public void test(){
                System.out.println(new Date());
        }
}

