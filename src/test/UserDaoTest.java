package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void UserTest(){
        User user = userDao.queryUserByUsername("nicknametest");
        System.out.println(user.getNickname());
    }
}