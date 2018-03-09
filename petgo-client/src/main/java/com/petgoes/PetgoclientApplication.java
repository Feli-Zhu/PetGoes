package com.petgoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.petgoes.api.UserService;
import com.weibo.api.motan.config.ProtocolConfig;
import com.weibo.api.motan.config.RefererConfig;
import com.weibo.api.motan.config.RegistryConfig;
@EnableAutoConfiguration
@SpringBootApplication
public class PetgoclientApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "8700");
		SpringApplication.run(PetgoclientApplication.class, args);
		System.out.println("Client start ...");
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:motan_client.xml");
//		UserService fooService = (UserService) applicationContext.getBean("userService");
//	    System.out.println(fooService.sayHello("world"));
//		PetgoclientApplication.configFileStart();
	}
	
	public static void startFromConfigFile() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:motan_client.xml");
		System.out.println("Client start ...");
		UserService fooService = (UserService) applicationContext.getBean("userService");
	    System.out.println(fooService.sayHello("world"));
		
	}
	
	public static void configFileStart() {
		RefererConfig<UserService> motanDemoServiceReferer = new RefererConfig<UserService>();
        // 设置接口及实现类
        motanDemoServiceReferer.setInterface(UserService.class);
        // 配置服务的group以及版本号
        motanDemoServiceReferer.setGroup("petgo");
        motanDemoServiceReferer.setModule("motan-petgo-rpc");
        motanDemoServiceReferer.setVersion("1.0");
        motanDemoServiceReferer.setRequestTimeout(300);

        // 配置ZooKeeper注册中心
        RegistryConfig zookeeperRegistry = new RegistryConfig();
        zookeeperRegistry.setRegProtocol("zookeeper");
        zookeeperRegistry.setAddress("127.0.0.1:2181");
        motanDemoServiceReferer.setRegistry(zookeeperRegistry);
        // 配置RPC协议
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setId("motan");
        protocol.setName("motan");
        motanDemoServiceReferer.setProtocol(protocol);
        System.out.println("Client start ...");
        // 使用服务
        UserService service = motanDemoServiceReferer.getRef();
        System.out.println(service.sayHello("World"));
//        System.exit(0);
	}
}
