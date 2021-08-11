package pojo;

public class ResultGroupMessage {
    private boolean isGroup=true;
    private boolean isSystem=false;
    private User KeyGroup;
    private Object message;
    public User getKeyGroup() {
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

    public void setKeyGroup(User keyGroup) {
        KeyGroup = keyGroup;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
