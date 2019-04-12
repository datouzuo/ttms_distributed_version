package xin.mengzuo.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class CustemerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustemerApplication.class, args);
	}

}
