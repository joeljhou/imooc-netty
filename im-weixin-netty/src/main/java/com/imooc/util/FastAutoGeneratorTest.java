package com.imooc.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import org.apache.ibatis.cache.Cache;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 周宇
 * @create 2021-11-21 21:40
 * https://blog.csdn.net/qq_39038178/article/details/120580850
 */
public class FastAutoGeneratorTest {

    //数据库配置
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(
            "jdbc:mysql://127.0.0.1:3306/weixin-dev?characterEncoding=utf8", "root", "root");

    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置(GlobalConfig)
                .globalConfig((scanner, builder) -> {
                    builder.author("baomidou")   // 设置作者
                            //.enableKotlin()    // 开启 kotlin 模式
                            .enableSwagger()     // 开启 swagger 模式
                            .fileOverride()      // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir") + "/im-weixin-netty/src/main/java")  // 指定输出目录
                            .dateType(DateType.TIME_PACK)   // 时间策略  DateType.ONLY_DATE 默认值: DateType.TIME_PACK
                            .commentDate("yyyy-MM-dd")      // 日期格式化  默认值: yyyy-MM-dd
                    ;
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
                            // 设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    System.getProperty("user.dir") + "/im-weixin-netty/src/main/resources/mapper"));
                })
                // 模板配置(TemplateConfig)
                .templateConfig(builder -> {
                    builder.disable(TemplateType.ENTITY)
                            .entity("/templates/entity.java")
                            .service("/templates/service.java")
                            .serviceImpl("/templates/serviceImpl.java")
                            .mapper("/templates/mapper.java")
                            .mapperXml("/templates/mapper.xml")
                            .controller("/templates/controller.java")
                            .build();
                })
                // 注入配置(InjectionConfig)
                .injectionConfig(builder -> {
                    builder.beforeOutputFile((tableInfo, objectMap) -> {
                                System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
                            })  // 输出文件之前消费者
                            .customMap(Collections.singletonMap("test", "baomidou"))
                            //.customFile(Collections.singletonMap("test.txt", "/templates/test.vm"))   //自定义配置模板文件
                            .build();
                })
                // 策略配置(StrategyConfig)
                .strategyConfig(builder -> {
                    builder
                            /*基本参数配置*/
                            .addInclude(getTables("all"))         // 设置需要生成的表名
                            //.addInclude("users,my_friends,friends_request,chat_msg")   // 设置需要生成的表名
                            //.likeTable(new LikeTable("USER"))   // 模糊表匹配(sql 过滤)	likeTable 与 notLikeTable 只能配置一项
                            //.addTablePrefix("t_", "c_")         // 设置过滤表前缀
                            //.addFieldSuffix("_flag")            // 设置过滤表后缀
                            .enableCapitalMode()                  // 开启大写命名
                            .enableSkipView()                     // 开启跳过视图
                            .disableSqlFilter()                   // 禁用 sql 过滤	默认值:true，语法不能支持使用 sql 过滤表的话，可以考虑关闭此开关

                            /*实体策略配置*/
                            .entityBuilder()
                            //.superClass(BaseEntity.class)      // 设置父类
                            //.disableSerialVersionUID()         // 禁用生成 serialVersionUID
                            .enableChainModel()                  // 开启链式模型 @Accessors(chain = true)
                            .enableLombok()                      // 开启 lombok 模型
                            .enableRemoveIsPrefix()              // 开启 Boolean 类型字段移除 is 前缀
                            //.enableTableFieldAnnotation()      // 开启生成实体时生成字段注解
                            .enableActiveRecord()                // 开启 ActiveRecord 模型，即Model中封装了CURD;
                            //.versionColumnName("version")      // 乐观锁字段名(数据库)
                            //.versionPropertyName("version")    // 乐观锁属性名(实体)
                            //.logicDeleteColumnName("deleted")                 // 逻辑删除字段名(数据库)
                            //.logicDeletePropertyName("deleteFlag")            // 逻辑删除属性名(实体)
                            .naming(NamingStrategy.underline_to_camel)          // 数据库表映射到实体的命名策略
                            .columnNaming(NamingStrategy.underline_to_camel)    // 转驼峰命名
                            //.addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")  // 添加父类公共字段
                            //.addIgnoreColumns("age")           // 添加忽略字段
                            .addTableFills(new Column("create_time", FieldFill.INSERT))            // 添加表字段填充
                            .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))   // 添加表字段填充
                            .idType(IdType.AUTO)                 // 全局主键类型
                            .formatFileName("%sBean")            // 转换文件名称

                            /*Controller策略配置*/
                            //.controllerBuilder()
                            //.superClass(BaseController.class)  // 设置父类
                            //.enableHyphenStyle()               // 开启驼峰转连字符
                            //.enableRestStyle()                 // 开启生成@RestController 控制器
                            //.formatFileName("%sAction")        // 格式化文件名称

                            /*service 策略配置*/
                            //.serviceBuilder()
                            //.superServiceClass(BaseService.class)          // 设置 service 接口父类
                            //.superServiceImplClass(BaseServiceImpl.class)  // 设置 service 实现类父类
                            //.formatServiceFileName("%sService")            // 格式化 service 接口文件名称
                            //.formatServiceImplFileName("%sServiceImp")     // 格式化 service 实现类文件名称

                            /*mapper 策略配置	*/
                            .mapperBuilder()
                            //.superClass(BaseMapper.class)      // 设置父类
                            .enableMapperAnnotation()            // 开启 @Mapper 注解
                            .enableBaseResultMap()               // 启用 BaseResultMap 生成
                            .enableBaseColumnList()              // 启用 BaseColumnList
                            //.cache(MyMapperCache.class)        // 设置缓存实现类
                            //.formatMapperFileName("%sDao")     // 格式化 mapper 文件名称
                            //.formatXmlFileName("%sXml")        // 格式化 xml 实现类文件名称
                            .build();
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
