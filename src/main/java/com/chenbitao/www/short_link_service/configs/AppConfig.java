package com.chenbitao.www.short_link_service.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "server")
@Data
public class AppConfig {
	/** 服务端口 */
	private String port;
	/** 服务域名 */
	private String domain = "http://127.0.0.1";
}
