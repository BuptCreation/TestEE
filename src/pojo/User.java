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
    private String password; //密码
    private String email; //邮箱
    private String identity; //身份，用于确认是教师还是学生
    private int studentNo; //学号

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

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", identity='" + identity + '\'' +
                ", studentNo='" + studentNo + '\'' +
                '}';
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public User(){}

    public User(String identity) {
        this.identity = identity;
    }

    public User(Integer id, String username, String password, String email, String identity, int studentNo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.identity = identity;
        this.studentNo = studentNo;
    }


}
