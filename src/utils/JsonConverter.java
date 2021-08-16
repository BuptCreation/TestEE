package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 类<code>JsonConverter</code>用于:Json转换操作工具类
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
        return new Gson().toJson(articles);
    }
    public String studentJson(List<User> users){
        return new Gson().toJson(users);
    }
    public String userJson(User user){
        return new Gson().toJson(user);
    }
}
