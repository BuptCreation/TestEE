package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-31-16
 */
public class JsonConverter {
    private final Gson gson;

    public JsonConverter() {

        gson = new GsonBuilder().create();
    }
    public String convertToJson(List<Map<String, Object>> articles){
        Gson gson = new Gson();
        return gson.toJson(articles);
    }
    public String studentJson(List<User> users){
        Gson gson = new Gson();
        return gson.toJson(users);
    }
}
