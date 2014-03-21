package ar.com.fn.api;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import spark.ResponseTransformerRoute;
import ar.com.fn.utils.GsonFactory;

public abstract class JsonRoute extends ResponseTransformerRoute {

    private Gson gson = GsonFactory.giveGson();
    // temp
    public static List<String> routes = new ArrayList<>();

	protected JsonRoute(String path) {
		super(path);
		routes.add(path);
	}

	protected JsonRoute(String path, String acceptType) {
		super(path, acceptType);
		routes.add(path);
	}
	
	@Override
	public String render(Object model) {
		return gson.toJson(model);
	}

}
