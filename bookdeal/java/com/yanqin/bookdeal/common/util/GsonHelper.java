package com.yanqin.bookdeal.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GsonHelper {

    private static final Gson gson = new Gson();

    public static boolean isNull(JsonElement element) {
        return element == null || element.isJsonNull();
    }

    public static JsonArray getAsJsonArray(JsonElement element) {
        return isNull(element) ? null : element.getAsJsonArray();
    }

    public static String getAsString(JsonElement element) {
        return isNull(element) ? null : element.getAsString();
    }

    public static JsonObject getAsJsonObject(JsonElement element){
        return isNull(element) ? null : element.getAsJsonObject();
    }

    public static Integer getAsInteger(JsonElement element) {
        return isNull(element) ? null : element.getAsInt();
    }

    public static int getAsPrimitiveInt(JsonElement element) {
        Integer r = getAsInteger(element);
        return r == null ? 0 : r;
    }

    public static boolean isJSONValid(String jsonInString) {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch(com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

}
