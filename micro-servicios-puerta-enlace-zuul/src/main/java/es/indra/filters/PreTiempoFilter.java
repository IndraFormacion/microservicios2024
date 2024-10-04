/**
 * 
 */
package es.indra.filters;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 
 */
@Component
public class PreTiempoFilter extends ZuulFilter{

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
		
		//Tomar el tiempo de inicio
		Long tiempoInicio=System.currentTimeMillis();
		//Lo guardamos como atributo de peticion.
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.getRequest().setAttribute("tiempoInicio", tiempoInicio);
		return null;
	}

	@Override
	public String filterType() {
		// Hay que retornar uno de estos valores: "pre", "post", "route"
		return "pre";
	}

	@Override
	public int filterOrder() {
		// Podemos tener varios filtros
		//Orden de ejecucion 1,2,3,4,...
		return 1;
	}

}
