package pojo;

/**
 * 用于：ChatRoom      浏览器发送给服务器
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-21
 */
public class Message {
    private User toName;
    private User message;
    private boolean isGroup;

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public User getToName() {
        return toName;
    }

    public void setToName(User toName) {
        this.toName = toName;
    }

    public User getMessage() {
        return message;
    }

    public void setMessage(User message) {
        this.message = message;
    }
}


