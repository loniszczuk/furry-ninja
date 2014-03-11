package ar.com.fn.utils;

import com.google.gson.*;

public class GsonFactory {


    // ༼ つ ◕_◕ ༽つ
    public static Gson giveGson() {

        return new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .serializeNulls()
            .create();
    }
}
