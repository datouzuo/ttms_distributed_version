package xin.mengzuo.studiomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class StudioManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudioManagerApplication.class, args);
	}

}

