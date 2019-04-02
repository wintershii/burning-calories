package com.burn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.burn.burningcalories.dao")
public class BurningCaloriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurningCaloriesApplication.class, args);
    }

}
