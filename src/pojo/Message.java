package pojo;

/**
 * 用于：ChatRoom      浏览器发送给服务器
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-21
 */
public class Message {
    private String toName;
    private String message;
    private boolean isGroup;

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


