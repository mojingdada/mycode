package com.example.myweb;


import com.example.myweb.dao.UserDAO;
import com.example.myweb.model.User;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


import java.util.Random;

@SpringBootTest
@Sql("/init-schema.sql")
public class InitDatabaseTests {
    @Autowired
    UserDAO userDAO;

    @Test
    public void contextLoads() {
        Random random = new Random();
        for (int i = 0; i < 11; ++i) {
            User user = new User();
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
            user.setName(String.format("USER%d", i));
            user.setPassword("");
            user.setSalt("");
            userDAO.addUser(user);
            user.setPassword("xxx");
            userDAO.updatePassword(user);
        }
//        Assert.assertEquals("newpassword", userDAO.selectById(1).getPassword());
//        userDAO.deleteById(1);
//        Assert.assertNull(userDAO.selectById(1));
    }
}
