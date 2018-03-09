package com.petgoes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;

@SpringBootApplication
@MapperScan("com.petgoes.mapper")
public class PetgoApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "8901");
		SpringApplication.run(PetgoApplication.class, args);
		MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
	    System.out.println("Server start ...");
	    
//	    new ClassPathXmlApplicationContext("classpath*:motan_server.xml");
//	    MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
//	    System.out.println("Server start ...");

		
	}
}
