package pojo;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-21
 */
public class Comment {

    private User user; //发表的用户
    private int id; //发表事件
    private java.lang.String content; //内容
    private java.lang.String title; //标题
    private java.lang.String context; //

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getContent() {
        return content;
    }

    public void setContent(java.lang.String content) {
        this.content = content;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getContext() {
        return context;
    }

    public void setContext(java.lang.String context) {
        this.context = context;
    }

    public Comment(User user, int id, java.lang.String content, java.lang.String title, java.lang.String context) {
        this.user = user;
        this.id = id;
        this.content = content;
        this.title = title;
        this.context = context;
    }

    public Comment(){};

    @Override
    public java.lang.String toString() {
        return "Comment{" +
                "user=" + user +
                ", id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                '}';
    }

}
