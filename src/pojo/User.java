package pojo;

public class User {
    private Integer id; //默认id
    private java.lang.String username; //用户名
    private java.lang.String password; //密码
    private java.lang.String email; //邮箱
    private java.lang.String identity; //身份，用于确认是教师还是学生
    private int studentNo; //学号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    @Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", identity='" + identity + '\'' +
                ", studentNo='" + studentNo + '\'' +
                '}';
    }

    public java.lang.String getIdentity() {
        return identity;
    }

    public void setIdentity(java.lang.String identity) {
        this.identity = identity;
    }

    public User(){}

    public User(java.lang.String identity) {
        this.identity = identity;
    }

    public User(Integer id, java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String identity, int studentNo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.identity = identity;
        this.studentNo = studentNo;
    }


}
