package es.indra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiciosCarritoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiciosCarritoApplication.class, args);
	}

}
