package pojo;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-21
 */
public class Comment {

    private User user;
    private int id;
    private String content;
    private String title;
    private String context;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Comment(User user, int id, String content, String title, String context) {
        this.user = user;
        this.id = id;
        this.content = content;
        this.title = title;
        this.context = context;
    }

    public Comment(){};

    @Override
    public String toString() {
        return "Comment{" +
                "user=" + user +
                ", id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                '}';
    }

}
