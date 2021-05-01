package com.yanqin.bookdeal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.yanqin.bookdeal.mapper")
public class BookdealApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookdealApplication.class, args);
	}

}
