package ar.com.fn;
import static spark.Spark.*;
import spark.*;

/**
 * @author jformoso
 */
public class Main {
	public static void main(String[] args) {
		get(new Route("/ping") {
			@Override
			public Object handle(Request request, Response response) {
				return "pong";
			}
		});
	}
}
