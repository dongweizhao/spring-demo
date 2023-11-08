//package com.example.spring.demo.genertor;
//
//import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//
//public class GeneratorMain {
//
//    /**
//     * <p>
//     * 读取控制台内容
//     * </p>
//     */
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotBlank(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//    /**
//     * 全局配置
//     * @return
//     */
//    public static GlobalConfig getGlobalConfig(String projectPath){
//        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir(projectPath + "/src/main/java");
//        gc.setAuthor(scanner("作者"));
//        gc.setOpen(false);
//        gc.setSwagger2(true);
//        gc.setFileOverride(true);
//        gc.setBaseColumnList(true);
//        gc.setBaseResultMap(true);
//        gc.setDateType(DateType.ONLY_DATE);
//        return gc;
//    }
//
//    /**
//     * 获取数据源
//     * @return
//     */
//    public static DataSourceConfig getDataSourceConfig(){
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("root");
//        return dsc;
//    }
//
//    /**
//     * 获取包配置
//     * @return
//     */
//    public static PackageConfig getPackageConfig(){
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("com.example.spring.demo");
//        pc.setEntity("po");
//        pc.setMapper("mapper");
//        return pc;
//    }
//
//    public static void main(String[] args) {
//        String projectPath = "generator";
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//        //获取全局配置
//        mpg.setGlobalConfig(getGlobalConfig(projectPath));
//        // 数据源配置
//        mpg.setDataSource(getDataSourceConfig());
//        // 包配置
//        PackageConfig pc = getPackageConfig();
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//
//        strategy.setEntityLombokModel(true);
//        strategy.setEntityTableFieldAnnotationEnable(true);
//        strategy.setLogicDeleteFieldName("deleted");
//        strategy.setEntityColumnConstant(true);
////        strategy.setSuperEntityClass(BasePo.class);
//        // 公共类
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategy.setTablePrefix(scanner("表名前缀，多个英文逗号分割").split(","));
//        strategy.setControllerMappingHyphenStyle(true);
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
//
//}
