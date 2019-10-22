package com.csdn.demo.traditional;

/**
 * 客户端
 *
 * @author tony
 */
public class Client {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        System.out.println(String.format("读取配置文件参数 paramA:%s, paramB:%s", appConfig.getParamA(), appConfig.getParamB()));
    }

}
