package pojo;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-13
 */
public class News {
    private String type;//消息类型
    private String title;//文章标题
    private String content;//文章内容
    private boolean isComment;//是否评论文章
    private String extraInfo;//额外消息
    private int studentNo; //对应的学生学号

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isComment() {
        return isComment;
    }

    public void setComment(boolean comment) {
        isComment = comment;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
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

    public News(String type, String title, String content, boolean isComment, String extraInfo, int studentNo) {
        this.type = type;
        this.title = title;
        this.content = content;
        this.isComment = isComment;
        this.extraInfo = extraInfo;
        this.studentNo = studentNo;
    }

    @Override
    public String toString() {
        return "News{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isComment=" + isComment +
                ", extraInfo='" + extraInfo + '\'' +
                ", studentNo=" + studentNo +
                '}';
    }


}
