package com.yanqin.bookdeal.common.config;

import com.yanqin.bookdeal.filter.LoginFilter;
import com.yanqin.bookdeal.filter.LoginFilter2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Administrator
 * @create 2021-04-05
 **/
@Configuration
public class Config2 extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginFilter()).addPathPatterns("/**")
				.excludePathPatterns("/page/**","/login/**","/img/**");
		registry.addInterceptor(new LoginFilter2()).addPathPatterns("/admin/**")
				;
		super.addInterceptors(registry);
	}
}
