package test;


import org.junit.Test;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "student168", "666666", "bbj168@qq.com", "student",211));
        userService.registUser(new User(null, "teacher168", "666666", "abc168@qq.com", "teacher",211));
    }

    @Test
    public void login() {
        System.out.println( userService.login(new User(null, "wzg168", "123456", null, "student",211)) );
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("wzg16888")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}