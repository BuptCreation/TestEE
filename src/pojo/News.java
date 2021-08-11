package pojo;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-13
 */
public class News {
    private User type;//消息类型
    private User title;//文章标题
    private User content;//文章内容
    private boolean isComment;//是否评论文章
    private User extraInfo;//额外消息
    private int studentNo; //对应的学生学号

    public User getType() {
        return type;
    }

    public void setType(User type) {
        this.type = type;
    }

    public User getTitle() {
        return title;
    }

    public void setTitle(User title) {
        this.title = title;
    }

    public User getContent() {
        return content;
    }

    public void setContent(User content) {
        this.content = content;
    }

    public boolean isComment() {
        return isComment;
    }

    public void setComment(boolean comment) {
        isComment = comment;
    }

    public User getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(User extraInfo) {
        this.extraInfo = extraInfo;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public News() {
    }

    public News(User type, User title, User content, boolean isComment, User extraInfo, int studentNo) {
        this.type = type;
        this.title = title;
        this.content = content;
        this.isComment = isComment;
        this.extraInfo = extraInfo;
        this.studentNo = studentNo;
    }

}
