package com.example.backend.domain.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void USER_CREATE_TEST() {
        userRepository.save(User.builder().password("1").name("테스트").email("example").build());

        List<User> users = userRepository.findAll();

        User user = users.get(0);
        System.out.println(user);
    }

}
