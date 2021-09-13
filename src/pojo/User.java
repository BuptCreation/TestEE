package pojo;
/**
 * 类<code>User</code>用于:实现用户类的相关操作及其需要的相关函数和构造函数
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-11-13
 */
public class User {
    private Integer id; //默认id
    private String username; //用户名
    private String nickname; //昵称
    private String password; //密码
    private String email; //邮箱
    private String identity; //身份，用于确认是教师还是学生
    private String studentno; //学号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", identity='" + identity + '\'' +
                ", studentNo=" + studentno +
                '}';
    }

    public User(){}

    public User(String identity) {
        this.identity = identity;
    }

    public User(Integer id, String username, String nickname, String password, String email, String identity, String studentno) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.identity = identity;
        this.studentno = studentno;
    }

    public User(Integer id, String username,String nickname, String password, String email, String identity) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.identity = identity;
    }
}
