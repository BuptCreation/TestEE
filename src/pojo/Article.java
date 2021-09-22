package pojo;

/**
 * 类<code>Article</code>用于:实现文章类以及其需要的相关参数和构造函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-07-21
 */
public class Article {
    private String textno; //文章号
    private String title; //文章标题
    private String description; //文章描述
    private String content; //文章内容
    private String teacherno; //教师是谁
    private String groupnumber;//小组号
    private int browsertimes; //浏览次数
    private int commentCount; //评论数
    private double averagevocabularypoint; //词汇平均分
    private double averagefluentpoint; //连贯与衔接平均分
    private double averagevarietypoint; //语法多样性平均分
    private double averagecompletepoint; //任务完成度平均分
    private String date; //文章发表日期

    public String getTextno() {
        return textno;
    }

    public void setTextno(String textno) {
        this.textno = textno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno;
    }

    public int getBrowsertimes() {
        return browsertimes;
    }

    public void setBrowsertimes(int browsertimes) {
        this.browsertimes = browsertimes;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public double getAveragevocabularypoint() {
        return averagevocabularypoint;
    }

    public void setAveragevocabularypoint(double averagevocabularypoint) {
        this.averagevocabularypoint = averagevocabularypoint;
    }

    public double getAveragefluentpoint() {
        return averagefluentpoint;
    }

    public void setAveragefluentpoint(double averagefluentpoint) {
        this.averagefluentpoint = averagefluentpoint;
    }

    public double getAveragevarietypoint() {
        return averagevarietypoint;
    }

    public void setAveragevarietypoint(double averagevarietypoint) {
        this.averagevarietypoint = averagevarietypoint;
    }

    public double getAveragecompletepoint() {
        return averagecompletepoint;
    }

    public void setAveragecompletepoint(double averagecompletepoint) {
        this.averagecompletepoint = averagecompletepoint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Article() {
    }
    public String getGroupnumber() {
        return groupnumber;
    }

    public void setGroupnumber(String groupnumber) {
        this.groupnumber = groupnumber;
    }


    public Article(String textno, String title, String description, String content, String teacherno, String groupnumber, int browsertimes, int commentCount, double averagevocabularypoint, double averagefluentpoint, double averagevarietypoint, double averagecompletepoint, String date) {
        this.textno = textno;
        this.title = title;
        this.description = description;
        this.content = content;
        this.teacherno = teacherno;
        this.groupnumber = groupnumber;
        this.browsertimes = browsertimes;
        this.commentCount = commentCount;
        this.averagevocabularypoint = averagevocabularypoint;
        this.averagefluentpoint = averagefluentpoint;
        this.averagevarietypoint = averagevarietypoint;
        this.averagecompletepoint = averagecompletepoint;
        this.date = date;
    }
}
