package io.github.liketic.spring.user.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserMapper userMapper;


    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User create(User user) {
        Assert.notNull(user, "User could not be null");
        User existingUser = findByLogin(user.getLogin());
        Assert.isNull(existingUser, "User login [" + user.getLogin() + "] already in use");
        userMapper.create(user);
        logger.debug("User " + user + " created successfully");
        return user;
    }

    public User findByLogin(String login) {
        Assert.hasText(login, "User login could not be empty");
        return userMapper.findByLogin(login);
    }
}
