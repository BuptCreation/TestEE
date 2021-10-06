package pojo;

/**
 * 类<code>Comment</code>用于:实现评论类以及其需要的相关参数和构造函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-21
 */
public class Comment {

    private String user; //发表的用户
    private int id; //发表时间的时间戳
    private String content; //内容
    private String textno; //文章号
    private String context; //不知道啥用
    private double vocabulary; //词汇运用
    private double fluent; //结构与衔接
    private double variety;//语法使用
    private double complete;//写作内容
    private double specification; //写作规范
    private String date;//评论发表日期

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
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

    public String getTextno() {
        return textno;
    }

    public void setTextno(String textno) {
        this.textno = textno;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public double getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(double vocabulary) {
        this.vocabulary = vocabulary;
    }

    public double getFluent() {
        return fluent;
    }

    public void setFluent(double fluent) {
        this.fluent = fluent;
    }

    public double getVariety() {
        return variety;
    }

    public void setVariety(double variety) {
        this.variety = variety;
    }

    public double getComplete() {
        return complete;
    }

    public void setComplete(double complete) {
        this.complete = complete;
    }

    public Comment() {
    }

    public Comment(String user, int id, String content, String textno, String context, double vocabulary, double fluent, double variety, double complete, double specification, String date) {
        this.user = user;
        this.id = id;
        this.content = content;
        this.textno = textno;
        this.context = context;
        this.vocabulary = vocabulary;
        this.fluent = fluent;
        this.variety = variety;
        this.complete = complete;
        this.specification = specification;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "user='" + user + '\'' +
                ", id=" + id +
                ", content='" + content + '\'' +
                ", textno='" + textno + '\'' +
                ", context='" + context + '\'' +
                ", vocabulary=" + vocabulary +
                ", fluent=" + fluent +
                ", variety=" + variety +
                ", complete=" + complete +
                ", specification=" + specification +
                ", date='" + date + '\'' +
                '}';
    }
}
