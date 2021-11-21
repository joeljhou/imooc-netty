package com.imooc.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 周宇
 * @create 2021-11-21 21:40
 * https://blog.csdn.net/qq_39038178/article/details/120580850
 */
public class FastAutoGeneratorTest {

    /**
     * 数据库配置(DataSourceConfig)
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(
            "jdbc:mysql://127.0.0.1:3306/weixin-dev?characterEncoding=utf8", "root", "root");


    public static void main(String[] args) {

        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置(GlobalConfig)
                .globalConfig((scanner, builder) -> {
                    builder.author("baomidou")   // 设置作者
                            .enableSwagger()     // 开启 swagger 模式
                            .fileOverride()      // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir") + "/im-weixin-netty/src/main/java");  // 指定输出目录
                })
                // 包配置(PackageConfig)
                .packageConfig(builder -> {
                    builder.parent("com.imooc")     // 设置父包名
                            //.moduleName("system") // 设置父包模块名 无
                            .entity("pojo")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .controller("controller")
                            //.other("other")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    // 设置mapperXml生成路径
                                    System.getProperty("user.dir") + "/im-weixin-netty/src/main/resources/mapper"));
                })
                // 模板配置(TemplateConfig)
                // 注入配置(InjectionConfig)
                // 策略配置(StrategyConfig)
                .strategyConfig(builder -> {
                    builder.addInclude(getTables("all"))   // 设置需要生成的表名
                            //.addInclude("users,my_friends,friends_request,chat_msg")
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })

                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
