package com.stackroute.ZuulMicroService;

import com.stackroute.ZuulMicroService.filters.ErrorFilter;
import com.stackroute.ZuulMicroService.filters.PostFilter;
import com.stackroute.ZuulMicroService.filters.PreFilter;
import com.stackroute.ZuulMicroService.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulMicroServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZuulMicroServiceApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
