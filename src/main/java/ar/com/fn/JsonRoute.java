package ar.com.fn;

import com.google.gson.Gson;

import spark.ResponseTransformerRoute;

public abstract class JsonRoute extends ResponseTransformerRoute {

    private Gson gson = new Gson();

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
