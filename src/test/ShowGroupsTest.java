package test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import dao.impl.GroupDaoImpl;
import org.junit.Test;
import service.impl.GroupServiceImpl;
import utils.JsonConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-07-17
 */
public class ShowGroupsTest {
    @Test
    public void groupsTest(){
        List<JsonArray> jsonArrayList = new ArrayList<JsonArray>();
        Gson gson = new Gson();
        try {
            GroupDaoImpl groupDao = new GroupDaoImpl();
            List<Map<String, Object>> groupList = groupDao.queryGroup("teacher168");
            String json = new JsonConverter().convertToJson(groupList);
            JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
            jsonArrayList.add(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(gson.toJson(jsonArrayList));
    }
}
