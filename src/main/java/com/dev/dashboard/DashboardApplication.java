package com.dev.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;

import com.dev.service.DashboardService;

/**
 * DashBoard Application Class
 * @author Vivek Gupta
 *
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.dev.entity"})
@ComponentScan(basePackages = {"com.dev.config.model","com.dev.config.response","com.dev.config.service",
		"com.dev.controller","com.dev.security.config","com.dev.service","com.dev.invoke.external"})
@EnableJpaRepositories(basePackages =  {"com.dev.repository"})
@PropertySource({"classpath:serviceURLs.properties"})
public class DashboardApplication {

	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@Autowired
	private DashboardService dashboardService;
	
	public static void main(String[] args) {
		
		SpringApplication.run(DashboardApplication.class, args);
		
	}

}
