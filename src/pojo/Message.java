package pojo;

import java.util.List;

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
    private boolean isat;
    private List<String> atwhos;
    private int groupid;
    private String sender;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public boolean isat() {
        return isat;
    }

    public void setat(boolean isat) {
        this.isat = isat;
    }

    public List<String> getAtwhos() {
        return atwhos;
    }

    public void setAtwhos(List<String> atwhos) {
        this.atwhos = atwhos;
    }

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

    public boolean isIsat() {
        return isat;
    }

    public void setIsat(boolean isat) {
        this.isat = isat;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public Message() {
    }

    public Message(String toName, String message, boolean isGroup, boolean isat, List<String> atwhos, int groupid, String sender) {
        this.toName = toName;
        this.message = message;
        this.isGroup = isGroup;
        this.isat = isat;
        this.atwhos = atwhos;
        this.groupid = groupid;
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "toName='" + toName + '\'' +
                ", message='" + message + '\'' +
                ", isGroup=" + isGroup +
                ", isat=" + isat +
                ", atwhos=" + atwhos +
                ", groupid=" + groupid +
                ", sender='" + sender + '\'' +
                '}';
    }
}


