package ar.com.fn.api;

import spark.ResponseTransformerRoute;
import ar.com.fn.utils.GsonFactory;

import com.google.gson.Gson;
 
public abstract class JsonRoute extends ResponseTransformerRoute {

    private Gson gson = GsonFactory.giveGson();

	protected JsonRoute(String path) {
		super(path);
	}

	protected JsonRoute(String path, String acceptType) {
		super(path, acceptType);
	}
	
	@Override
	public String render(Object model) {
		return gson.toJson(model);
	}
}
