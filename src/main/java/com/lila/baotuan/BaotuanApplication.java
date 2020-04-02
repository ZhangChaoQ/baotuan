package com.lila.baotuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.lila.baotuan.mapper"})
public class BaotuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaotuanApplication.class, args);
    }

}
