package pojo;

/**
 * 类<code>Comment</code>用于:实现评论类以及其需要的相关参数和构造函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-21
 */
public class Comment {

    private User user; //发表的用户
    private int id; //发表事件
    private String content; //内容
    private String title; //标题
    private String context; //不知道啥用
    private int vocabulary; //词汇使用
    private int fluent; //连贯与衔接
    private int variety;//语法多样性
    private int complete;//任务完成度

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

    public int getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(int vocabulary) {
        this.vocabulary = vocabulary;
    }

    public int getFluent() {
        return fluent;
    }

    public void setFluent(int fluent) {
        this.fluent = fluent;
    }

    public int getVariety() {
        return variety;
    }

    public void setVariety(int variety) {
        this.variety = variety;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public Comment(User user, int id, String content, String title, String context, int vocabulary, int fluent, int variety, int complete) {
        this.user = user;
        this.id = id;
        this.content = content;
        this.title = title;
        this.context = context;
        this.vocabulary = vocabulary;
        this.fluent = fluent;
        this.variety = variety;
        this.complete = complete;
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
                ", vocabulary=" + vocabulary +
                ", fluent=" + fluent +
                ", variety=" + variety +
                ", complete=" + complete +
                '}';
    }
}
