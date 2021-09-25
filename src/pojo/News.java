package pojo;

/**
 * 类<code>News</code>用于:实现消息类的相关操作及其需要的相关函数和构造函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-13
 */
public class News {
    private String type;//消息类型
    private String title;//文章标题
    private String username; //消息所有者的用户名
    private String who;//谁发的
    private String textno; //文章号
    private String groupid; //发给哪个组
    private String standardDate; //标准时间
    private String date; //CST表示时间

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTextno() {
        return textno;
    }

    public void setTextno(String textno) {
        this.textno = textno;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getStandardDate() {
        return standardDate;
    }

    public void setStandardDate(String standardDate) {
        this.standardDate = standardDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public News() {
    }

    public News(String type, String title, String username, String who, String textno, String groupid, String standardDate, String date) {
        this.type = type;
        this.title = title;
        this.username = username;
        this.who = who;
        this.textno = textno;
        this.groupid = groupid;
        this.standardDate = standardDate;
        this.date = date;
    }

    @Override
    public String toString() {
        return "News{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", who='" + who + '\'' +
                ", textno='" + textno + '\'' +
                ", groupid='" + groupid + '\'' +
                ", standardDate='" + standardDate + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
