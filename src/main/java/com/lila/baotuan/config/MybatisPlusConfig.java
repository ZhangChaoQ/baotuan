package com.lila.baotuan.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan(basePackages = {"com.lila.baotuan.mapper","com.lila.baotuan.entity"})
public class MybatisPlusConfig {

}