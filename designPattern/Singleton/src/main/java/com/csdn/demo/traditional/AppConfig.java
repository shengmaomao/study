package com.csdn.demo.traditional;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * 系统配置文件的内容
 *
 * @author tony
 */
public class AppConfig {

    private String paramA;

    private String paramB;

    /**
     * 构造方法
     */
    public AppConfig() {
        readConfig();
    }

    /**
     * 读取配置文件的内容
     */
    private void readConfig() {
        System.out.println("开始读取系统配置文件");
        Properties properties = new Properties();
        try (
                InputStream resourceAsStream = AppConfig.class.getResourceAsStream("/appConfig.properties");
        ) {
            if (Objects.isNull(resourceAsStream)) {
                System.out.println("读取配置文件失败 未找到配置文件");
                return;
            }
            properties.load(resourceAsStream);
            this.paramA = properties.getProperty("paramA");
            this.paramB = properties.getProperty("paramB");
            System.out.println("成功读取系统配置文件");
        } catch (IOException e) {
            System.out.println("读取配置文件异常");
            e.printStackTrace();
        }
    }

    public String getParamA() {
        return paramA;
    }

    public String getParamB() {
        return paramB;
    }
}
