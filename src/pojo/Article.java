package pojo;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-21
 */
public class Article {
    private int id; //学号
    private String title; //标题
    private String author; //作者
    private String content; //内容
    private int commentCount; //评论数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
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

    public Article(int id, String title, String author, String content, int commentCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.commentCount = commentCount;
    }
}
