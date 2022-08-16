package com.huang;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * MP代码自动生成代码
 */
public class CodeGenerator {

    /*读取控制台信息*/
    public static String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入"+ tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()){
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)){
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }

    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //项目根目录  不可修改
        String projectPath = System.getProperty("user.dir");
        //用来获取Mybatis-Plus.properties文件的配置信息
        //ResourceBundle rb = ResourceBundle.getBundle("genreator");

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("huang");
        // 自动打开生成后的文件夹
        gc.setOpen(false);
        // 是否覆盖，最好不要为true，覆盖过去，会把之前的代码去掉
        //gc.setFileOverride(true);
        gc.setSwagger2(true);
        gc.setServiceName("%sService");
        // 开启 activeRecord 模式
        //gc.setActiveRecord(true);
        // XML 二级缓存
        //gc.setEnableCache(false);
        // XML ResultMap 映射图
        //gc.setBaseResultMap(true);
        // XML columList
        //gc.setBaseColumnList(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mall-mysql?serverTime=UTC&useUnicode=true&characterEncoding=utf-8");
        //注意Mysql 驱动版本问题 我这为8版本
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.huang");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);


        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        //如果模板引擎是freemarker则下列配置，如果是velocity则为/templates/mapper.xml.vm
        String templatePath = "/templates/mapper.xml.ftl";


        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/" +tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        // 调整 query 生成目录
/*        focList.add(new FileOutConfig("/templates/query.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("OutputDomainDir")+ "/cn/leilei/query/" + tableInfo.getEntityName() + "Query.java";
            }
        });*/

        //调整 entity 生成目录
//        focList.add(new FileOutConfig("/templates/entity.java.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return projectPath+ "/src/main/java/com/leilei/entity/" + tableInfo.getEntityName() + ".java";
//            }
//        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig templateConfig = new TemplateConfig();


        //tc.setController("/templates/controller.java.vm");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        //templateConfig.setEntity(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        // 执行生成


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        /** 此处可以修改为您的表前缀，如果没有，注释掉即可*/
        //strategy.setTablePrefix(new String[] { "t_" });
        /** 表名生成策略 表名生成策略,下划线转驼峰*/
        strategy.setNaming(NamingStrategy.underline_to_camel);
        /** 需要生成的表*/
        //strategy.setInclude(new String[]{"dept"}
        //字段生成策略,下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        //公共父类
        strategy.setSuperControllerClass("BaseController");
        //写于父类的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
