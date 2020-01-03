package com.yzw.apitest.cases;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class GenerateTestCode {
//    private String targetPath = "src/test/java/com/mytest/cases/";//生成的测试代码存放路径
    private String targetPath = "src/main/resources/GeneratedCode/";//生成的测试代码存放路径

    private String PostTemplateFileName = "PostTestCaseTemplate.java";//模板文件路径
    private String GetTemplateFileName = "GetTestCaseTemplate.java";//模板文件路径
    private String RPCPostTemplateFileName = "RPCPostTestCaseTemplate.java";//模板文件路径
    private String RPCGetTemplateFileName = "RPCGetTestCaseTemplate.java";//模板文件路径

    private String host = "http://172.16.30.234:8080/";//测试代码中host
    private String api = "/ums.rpc";//测试代码中api
    private String header = "application/json;charset=UTF-8";//测试代码中的header，穿空的话，则使用通用的
    private String FuncationName = "userRegister";//被测试的方法名或者api name,用于文件命名

    private String HttpMethod = "post";//请求方法，暂时只支持get和post，小写;
    private Integer IsRPC = 1;//1表示是，0表示否

    @Test
    public void generateCase() throws IOException {
        Properties pro = new Properties();
        pro.setProperty(Velocity.INPUT_ENCODING, "UTF-8");

        VelocityEngine ve = new VelocityEngine(pro);
        VelocityContext context = new VelocityContext();

        context.put("host",host);
        context.put("api",api);
        context.put("FuncationName",FuncationName);
        context.put("header",header);

        Template t = null;
        if (IsRPC == 1){
            //prc接口获取模板
            if("post".equals(HttpMethod)){
                t = ve.getTemplate(  RPCPostTemplateFileName, "UTF-8");
            }else if ("get".equals(HttpMethod)){
                t = ve.getTemplate(  RPCGetTemplateFileName, "UTF-8");
            }else {
                System.out.println("暂时不支持该类型的方法");
            }
        }else if (IsRPC == 0){
            //非rpc接口获取模板
            if("post".equals(HttpMethod)){
                t = ve.getTemplate(  PostTemplateFileName, "UTF-8");
            }else if ("get".equals(HttpMethod)){
                t = ve.getTemplate(  GetTemplateFileName, "UTF-8");
            }else {
                System.out.println("暂时不支持该类型的方法");
            }
        }else {
            System.out.println("错误的接口类型");
        }



        File file = new File(targetPath, FuncationName + "Test.java");
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream outStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outStream,
                "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        t.merge(context, bufferedWriter);
        bufferedWriter.flush();
        bufferedWriter.close();
        outStream.close();
        System.out.println("======================");
        System.out.printf("生成的文件名为：%s ,路径为：%s",
                FuncationName + "Test.java",
                targetPath);
        System.out.println();
        System.out.println("======================");

    }



    public static void writeFile(String filename, String str){
        try {
            FileWriter fileWriter = new FileWriter(new File(filename),true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/resoucres/Templeate/PostTestCaseTemplate.java");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        System.out.println(bufferedReader.readLine());
    }
}
