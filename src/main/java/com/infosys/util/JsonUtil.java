package com.infosys.util;

import com.google.gson.Gson;

public class JsonUtil {
    private Gson JsonParser;

    public JsonUtil() {
        JsonParser = new Gson();
    }


    public String JavaToJson(Object object){
        return JsonParser.toJson(object);
    }

    public <T> T JsonToJava(String jsonString, Class<T> clazz){

        return JsonParser.fromJson(jsonString, clazz);
    }
}
