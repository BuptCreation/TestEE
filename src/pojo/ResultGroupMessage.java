package pojo;

import java.util.List;

public class ResultGroupMessage {
    private boolean isGroup=true;
    private boolean isSystem=false;
    private String KeyGroup;
    private Object message;
    private boolean isat;
    private List<String> atwhos;
    private String sender;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSystem(boolean system) {
        isSystem = system;
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

    public String getKeyGroup() {
        return KeyGroup;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public boolean isSystem() {
        return isSystem;
    }

    public void setIsSystem(boolean system) {
        isSystem = system;
    }

    public void setKeyGroup(String keyGroup) {
        KeyGroup = keyGroup;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
