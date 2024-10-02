package es.indra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import es.indra.persistence.CarritosDAO;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroServiciosCarritoEurekaApplication implements CommandLineRunner{
	@Autowired
	private CarritosDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiciosCarritoEurekaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Eliminar todos los datos para probar
		dao.deleteAll();
	}

}
