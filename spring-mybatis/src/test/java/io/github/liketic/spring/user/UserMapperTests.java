package io.github.liketic.spring.user;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testCreateUser() throws Exception {
        User existing = userMapper.findByLogin("test-user");
        assertNull("User test-user should not exist", existing);

        User user = new User();
        user.setLogin("test-user");
        user.setPassword("pwd");
        user.setEmail("test-user@abc.com");

        userMapper.create(user);

        assertNotNull(user.getId());

        User created = userMapper.findByLogin("test-user");
        assertNotNull(created);
    }

}
