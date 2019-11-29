package cn.clboy.springbootjpa.controlelr;

import cn.clboy.springbootjpa.entity.User;
import cn.clboy.springbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Author cloudlandboy
 * @Date 2019/11/23 下午12:16
 * @Since 1.0.0
 */

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user")
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @RequestMapping("/user/{id}")
    public User getById(@PathVariable Integer id) {
        User user = userRepository.getOne(id);
        return user;
    }
}