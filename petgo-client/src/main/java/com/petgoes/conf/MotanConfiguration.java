package com.petgoes.conf;

import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicRefererConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuhaiming on 10/11/2016.
 */
@Configuration
public class MotanConfiguration {

	@Bean
	public AnnotationBean motanAnnotationBean() {
		AnnotationBean motanAnnotationBean = new AnnotationBean();
		motanAnnotationBean.setPackage("com.petgoes");
		return motanAnnotationBean;
	}

	@Bean(name = "motan")
	public ProtocolConfigBean protocolConfig1() {
		ProtocolConfigBean config = new ProtocolConfigBean();
		config.setDefault(true);
		config.setName("motan");
		config.setMaxContentLength(1048576);
		return config;
	}

	@Bean(name = "registry")
	public RegistryConfigBean registryConfig() {
		RegistryConfigBean config = new RegistryConfigBean();
		config.setRegProtocol("zookeeper");
		config.setAddress("127.0.0.1:2181");
		return config;
	}

	@Bean(name = "basicRefererConfig")
	public BasicRefererConfigBean basicRefererConfigBean() {
		BasicRefererConfigBean config = new BasicRefererConfigBean();
		config.setProtocol("motan");
		config.setRegistry("registry");
		config.setThrowException(true);
		config.setGroup("petgo");
	    config.setModule("motan-petgo-rpc");
	    config.setApplication("petgo");
	    config.setCheck(false);
	    config.setAccessLog(true);
	    config.setRetries(2);
		return config;
	}
}