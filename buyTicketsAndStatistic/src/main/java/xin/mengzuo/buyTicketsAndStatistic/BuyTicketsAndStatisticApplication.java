package xin.mengzuo.buyTicketsAndStatistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class BuyTicketsAndStatisticApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyTicketsAndStatisticApplication.class, args);
	}

}
