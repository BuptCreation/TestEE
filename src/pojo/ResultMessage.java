package pojo;


/**
 * ResultMessage 结果方法用于：CharRoom 服务器发送给浏览器
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-21
 */
public class ResultMessage {
    private boolean isSystem;
    private User fromName;
    private Object message;

    public boolean isSystem() {
        return isSystem;
    }

    public void setIsSystem(boolean system) {
        isSystem = system;
    }

    public User getFromName() {
        return fromName;
    }

    public void setFromName(User fromName) {
        this.fromName = fromName;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
