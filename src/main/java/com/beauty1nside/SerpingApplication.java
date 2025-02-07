package com.beauty1nside;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan(basePackages = "com.beauty1nside.**.mapper")	// {"",""} 로도 됨
//@EnableAspectJAutoProxy(proxyTargetClass = true)	// AOP 필요시 활성화 하기	// false = 인터페이스 기반, 인터페이스가 필요 // true=클래스 기반, 인터페이스 없어도 사용 가능
@SpringBootApplication
public class SerpingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerpingApplication.class, args);
	}

}
