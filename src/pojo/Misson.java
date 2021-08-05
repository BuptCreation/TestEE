package pojo;

import java.util.List;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-05-23
 */
public class Misson {
    private String username;
    private String title;
    private String guide;
    private String keyword;
    private List<String> writers;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    @Override
    public String toString() {
        return "Misson{" +
                "username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", guide='" + guide + '\'' +
                ", keyword='" + keyword + '\'' +
                ", writers=" + writers +
                '}';
    }
}
