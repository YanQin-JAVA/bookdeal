package com.yanqin.bookdeal.common.util;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @author Administrator
 */
public class GsonUtils {

    public static final com.google.gson.GsonBuilder GSONBUILDER = new com.google.gson.GsonBuilder();
    public final static Gson GSON = GSONBUILDER.disableHtmlEscaping().create();

    public GsonUtils() {
    }

    public static Gson create() {
        return GSONBUILDER.create();
    }

    public static <T> T fromJson(String json, Class<T> cls) {
        return GSON.fromJson(json, cls);
    }

    public static String toJson(Object src) {
        return GSON.toJson(src);
    }

    /**
     * apiResultJsonGetData
     * @param json
     * @param fieldname
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> apiResultJsonGetData(String json, String fieldname, Class<T> t){
        JsonElement jsonElement = JsonParser.parseString(json);
        JsonElement userlist = jsonElement.getAsJsonObject().get(fieldname);

        TypeToken<?> typeToken = TypeToken.getParameterized(List.class, t);
        return GSON.fromJson(userlist, typeToken.getType());
    }
}
