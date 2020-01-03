package com.yzw.apitest.cases.portal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yzw.apitest.entity.portal.User;
import com.yzw.apitest.service.JdbcService;
import com.yzw.apitest.service.OkHttpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * rpc类型的接口的请求参数：{"jsonrpc":"2.0", "id":"1", "method":"userRegister", "params":[{"loginCode":"aa","loginPassword":"bb"}]}
 * header：json
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class userRegisterTest {
    @Autowired
    OkHttpService okHttpService;

    @Autowired
    JdbcService jdbcService;

    private String host = "http://172.16.30.234:8080/";
    private String api = "/ums.rpc";
    private String header = "application/json;charset=UTF-8";

    /**
     * 参数传递：两个参数值为空，传了不需要的参数
     * 结果：报500错误
     *
     * @throws IOException
     */
    @Test
    public void Case4() throws IOException {
        User user = new User();
        user.setAppId("22");
        user.setAvatarImageUrl("");
        user.setCompanyId(1);
        user.setCountryCode("1");
        user.setEmail("ioilu@163.com");
        user.setExtendContent("nothing");
        user.setGender(1);
        user.setJcId(1L);
        user.setJobTitle("123");
        user.setLastChangePwdDate(new Date());
        user.setLastLoginTime(new Date());
        user.setLoginCode("11");
        user.setLoginPassword("123123");
        user.setMobile("15928914269");
        user.setName("ioilu123");
        user.setNote("2222");
        user.setOpenId("23423");
        user.setOrgCode("2343");
        user.setOrgId(55);
        user.setParentSupplierId(234L);
        user.setQq("23423422");
        user.setRandomCode("srgegrr");
        user.setStatus(1);
        user.setSubcontractorId(1);
        user.setSupplierId(1L);
        user.setSupplierType(1);
        user.setType(1);
        user.setCreateTime(new Date());
        user.setCreateUser("hello");
        user.setDeleteTag(1);
        user.setId(19L);
        user.setUpdateTime(new Date());
        user.setUpdateUser("ioilu");


        JSONArray jsonArray = new JSONArray();
        jsonArray.add(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("jsonrpc", "2.0");
        jsonObject.put("id", "1");
        jsonObject.put("method", "userRegister");
        jsonObject.put("params", jsonArray);

        HashMap<String, Object> hashMap = JSON.parseObject(jsonObject.toJSONString(), HashMap.class);


        String result = okHttpService.doPost("http://172.16.30.234:8080", "/ums.rpc", hashMap, header);
        System.out.println(result);
//                JSONObject jsonObject = new JSONObject();
//                jsonObject = JSON.parseObject(result);
//                Assert.assertEquals("500",jsonObject.getString("status"));

    }
}
