package es.indra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroServiciosPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiciosPedidosApplication.class, args);
	}

}
