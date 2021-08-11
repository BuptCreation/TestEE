package pojo;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-06-21
 */
public class Group {
    private int _id;
    private int id; //学号
    private User username;//学生姓名
    private int groupId;//小组号
    private int speeches;//群聊发言次数
    private User teacherUsername;//教师姓名

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getSpeeches() {
        return speeches;
    }

    public void setSpeeches(int speeches) {
        this.speeches = speeches;
    }

    public User getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(User teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    public Group() {
    }

    public Group(int _id, int id, User username, int groupId, int speeches, User teacherUsername) {
        this._id = _id;
        this.id = id;
        this.username = username;
        this.groupId = groupId;
        this.speeches = speeches;
        this.teacherUsername = teacherUsername;
    }

    @Override
    public java.lang.String toString() {
        return "Group{" +
                "_id=" + _id +
                ", id=" + id +
                ", username=" + username +
                ", groupId=" + groupId +
                ", speeches=" + speeches +
                ", teacherUsername=" + teacherUsername +
                '}';
    }
}
