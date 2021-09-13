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
    private String nickname; //昵称(当消息类型为writing或apply时可用)
    private String username; //消息所有者的用户名
    private String textno; //文章号
    private String towho; //发给谁
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getTowho() {
        return towho;
    }

    public void setTowho(String towho) {
        this.towho = towho;
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

    public News() {
    }

    public News(String type, String title, String nickname, String username, String textno, String towho, String groupid, String standardDate, String date) {
        this.type = type;
        this.title = title;
        this.nickname = nickname;
        this.username = username;
        this.textno = textno;
        this.towho = towho;
        this.groupid = groupid;
        this.standardDate = standardDate;
        this.date = date;
    }

    @Override
    public String toString() {
        return "News{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", textno='" + textno + '\'' +
                ", towho='" + towho + '\'' +
                ", groupid='" + groupid + '\'' +
                ", standardDate='" + standardDate + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
