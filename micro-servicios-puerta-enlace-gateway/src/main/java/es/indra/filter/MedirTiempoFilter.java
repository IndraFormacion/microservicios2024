/**
 * 
 */
package es.indra.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * 
 */
@Component
public class MedirTiempoFilter implements GlobalFilter, Ordered{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// pre
		//Tomar el riempo de inicio
		
		Long tiempoInicio=System.currentTimeMillis();
		
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			//post
			//Tomar el tiempo final
			Long tiempoFinal=System.currentTimeMillis();
			System.out.println("********************************");
			System.out.println("Tiempo Transcurrido: "+(tiempoFinal-tiempoInicio)+" mseg");
			System.out.println("********************************");
		}));
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
