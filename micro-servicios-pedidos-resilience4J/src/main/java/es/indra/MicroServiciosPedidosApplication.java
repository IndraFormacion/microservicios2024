package es.indra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@RibbonClient(name="servicios-productos")
@EnableEurekaClient
public class MicroServiciosPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiciosPedidosApplication.class, args);
	}

}
