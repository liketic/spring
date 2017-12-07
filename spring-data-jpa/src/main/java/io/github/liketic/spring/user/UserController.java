package io.github.liketic.spring.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{login:^[_'.@A-Za-z0-9-]*$}")
    @ResponseBody
    public User showUser(@PathVariable String login, Model model) {
        User user = userService.findByLogin(login);
        if (user == null)
            throw new RuntimeException("User login [" + login + "] doesn't exist");
        return user;
    }

    @PostMapping("")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        userService.create(user);
        return user;
    }
}
