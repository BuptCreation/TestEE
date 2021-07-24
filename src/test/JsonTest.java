package test;

import com.google.gson.Gson;
import org.junit.Test;
import pojo.User;

/**
 * 类<code>Doc</code>用于
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-24
 */
public class JsonTest {
    @Test public void JsonTest1(){
        User user1 = new User(2,"kira","452663","551@bupy.com","student");
        Gson gson = new Gson();
        //对象转json
        String userjsonstring = gson.toJson(user1);
        System.out.println(userjsonstring);
        //json转对象
        User user2 = gson.fromJson(userjsonstring,User.class);
        System.out.println(user2);
    }
}
