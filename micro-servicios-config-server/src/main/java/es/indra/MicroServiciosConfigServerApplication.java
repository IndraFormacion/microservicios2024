package es.indra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroServiciosConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiciosConfigServerApplication.class, args);
	}

}
