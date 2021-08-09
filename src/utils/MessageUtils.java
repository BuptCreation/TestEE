package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.ResultGroupMessage;
import pojo.ResultMessage;

/**
 * 用来封装消息工具类
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-21
 */
public class MessageUtils {

    public static String getMessage(boolean isSystemMessage,String fromName,Object message){
        try{
            ResultMessage result = new ResultMessage();
            result.setIsSystem(isSystemMessage);
            result.setMessage(message);
            if (fromName!=null) {
                result.setFromName(fromName);
            }
            //利用jackson将对象转化成json
            ObjectMapper mapper= new ObjectMapper();
            return mapper.writeValueAsString(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String getGroupMessage(boolean isSystemMessage,String KeyGroup,Object message){
        try{
            ResultGroupMessage result= new ResultGroupMessage();
            result.setKeyGroup(KeyGroup);
            result.setMessage(message);
            result.setIsSystem(isSystemMessage);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
