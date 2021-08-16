package pojo;

/**
 * 类<code>Article</code>用于:实现文章类以及其需要的相关参数和构造函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-21
 */
public class Article {
    private int id; //学号
    private User title; //标题
    private User author; //作者
    private User content; //内容
    private int commentCount; //评论数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getTitle() {
        return title;
    }

    public void setTitle(User title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getContent() {
        return content;
    }

    public void setContent(User content) {
        this.content = content;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Article() {
    }

    public Article(int id, User title, User author, User content, int commentCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.commentCount = commentCount;
    }
}
