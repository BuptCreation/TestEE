package pojo;

public class ResultGroupMessage {
    private boolean isGroup=true;
    private boolean isSystem=false;
    private String KeyGroup;
    private Object message;
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