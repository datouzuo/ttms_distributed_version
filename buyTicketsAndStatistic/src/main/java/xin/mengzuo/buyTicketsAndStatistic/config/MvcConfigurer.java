package xin.mengzuo.buyTicketsAndStatistic.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域处理
 * @author 左利伟
 *
 */
@Configuration
public class MvcConfigurer  implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
		WebMvcConfigurer.super.addCorsMappings(registry);
	}

  
}
