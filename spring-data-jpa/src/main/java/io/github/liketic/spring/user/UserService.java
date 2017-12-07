package io.github.liketic.spring.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User create(User user) {
        Assert.notNull(user, "User could not be null");
        User existingUser = findByLogin(user.getLogin());
        Assert.isNull(existingUser, "User login [" + user.getLogin() + "] already in use");
        userRepository.save(user);
        logger.debug("User " + user + " created successfully");
        return user;
    }

    public User findByLogin(String login) {
        Assert.hasText(login, "User login could not be empty");
        return userRepository.findByLogin(login);
    }
}
