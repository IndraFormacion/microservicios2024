package es.indra.filters;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// Activar o desactivar el filtro
		//Si devuelve true se ejecuta el metodo run()
		//Si se devuelve false lo ignora
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// Lo que queramos hacer en el filtro va aqui
		
		//Recuperar el tiempo inicial del atributo de la peticion.
		RequestContext ctx = RequestContext.getCurrentContext();
		Long tiempoInicio= (Long)ctx.getRequest().getAttribute("tiempoInicio");
		
		//Hallar el tiempo final 
		Long tiempoFinal=System.currentTimeMillis();
		System.out.println("********************************");
		System.out.println("Tiempo Transcurrido: "+(tiempoFinal-tiempoInicio)+" mseg");
		System.out.println("********************************");
		return null;
	}

	@Override
	public String filterType() {
		// Hay que retornar uno de estos valores: "pre", "post", "route"
		return "post";
	}

	@Override
	public int filterOrder() {
		// Podemos tener varios filtros
		//Orden de ejecucion 1,2,3,4,...
		return 1;
	}

}
