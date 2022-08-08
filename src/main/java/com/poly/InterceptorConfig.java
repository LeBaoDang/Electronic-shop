package com.poly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poly.interceptor.GlobalInterceptor;

// cấu hình chắc các url ko được cho phép
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	GlobalInterceptor globalInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// đưa globalInterceptor vào registry của hệ thống
		registry.addInterceptor(globalInterceptor)
		// chạy tất cả
		.addPathPatterns("/**")
		// chỉ ra url muốn inter chặn 
		.excludePathPatterns("/rest/**","/admin/**","/assets/**");
	}

}
