package pojo;

/**
 * 类<code>Group</code>用于:实现小组类以及其需要的相关参数和构造函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-06-21
 */
public class Group {
    private int _id;
    private int studentno; //学号
    private String studentname;//学生姓名
    private String nickname; //昵称
    private int groupid;//小组号
    private int speeches;//群聊发言次数
    private int logins;//登录次数
    private String teachername;//教师姓名

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getStudentno() {
        return studentno;
    }

    public void setStudentno(int studentno) {
        this.studentno = studentno;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getSpeeches() {
        return speeches;
    }

    public void setSpeeches(int speeches) {
        this.speeches = speeches;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public int getLogins() {
        return logins;
    }

    public void setLogins(int logins) {
        this.logins = logins;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Group() {
    }

    public Group(int _id, int studentno, String studentname, String nickname, int groupid, int speeches, int logins, String teachername) {
        this._id = _id;
        this.studentno = studentno;
        this.studentname = studentname;
        this.nickname = nickname;
        this.groupid = groupid;
        this.speeches = speeches;
        this.logins = logins;
        this.teachername = teachername;
    }

    @Override
    public String toString() {
        return "Group{" +
                "_id=" + _id +
                ", studentno=" + studentno +
                ", studentname='" + studentname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", groupid=" + groupid +
                ", speeches=" + speeches +
                ", logins=" + logins +
                ", teachername='" + teachername + '\'' +
                '}';
    }
}
