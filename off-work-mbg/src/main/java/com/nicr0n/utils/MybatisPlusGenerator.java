package com.nicr0n.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2021/10/19 10:38
 * @email: Nicr0nFF@gmail.com
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:postgresql://localhost:5432/system","offWorkCloud","123456")
                // 全局配置
                .globalConfig(builder -> builder.author("Nicr0n")
                        .fileOverride()
                        .enableSwagger()
                        .commentDate("yyyy/MM/dd HH:mm")
                )
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder()
                        .enableRestStyle()  // 开启rest风格
                        .enableHyphenStyle()    // 开启驼峰命名转换
                        .formatFileName("%sController")
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImp")
                        .mapperBuilder()
                        .formatMapperFileName("%sDao")
                        .formatXmlFileName("%sMapper")
                        .entityBuilder()
                        .enableLombok() // 启用lombok
                        .enableTableFieldAnnotation()   // 开启数据库备注注释生成
                        .logicDeleteColumnName("delete_flag")   // 设置逻辑删除字段
                        .addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).addTableFills(
                                new Column("update_time", FieldFill.UPDATE)
                        ).build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .execute();

    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
