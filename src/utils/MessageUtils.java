package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.ResultGroupMessage;
import pojo.ResultMessage;

import java.util.List;

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
    public static String getGroupMessage(boolean isSystemMessage, String KeyGroup, Object message, boolean isat, List<String> atwhos,String sender){
        try{
            ResultGroupMessage result= new ResultGroupMessage();
            result.setKeyGroup(KeyGroup);
            result.setMessage(message);
            result.setIsSystem(isSystemMessage);
            result.setat(isat);
            result.setAtwhos(atwhos);
            result.setSender(sender);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
