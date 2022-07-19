package com.example.backend.domain;

import com.example.backend.domain.users.User;
import com.example.backend.domain.users.UserRepository;
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
    public void 유저_생성_테스트() {
        userRepository.save(User.builder().password("1").name("테스트").email("example234234").build());

        List<User> users = userRepository.findAll();

        User user = users.get(0);
        System.out.println(user);
    }

    @Test
    public void 유저_로그인_정보_테스트() {
        boolean res = userRepository.existsByEmailAndPassword("example", "1");
        System.out.println(res);
    }

    @Test
    public void 유저_이름_검색_테스트() {
        User user = userRepository.findUserByName("테스트").orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 유저가 없습니다"));
        System.out.println(user.getName());
    }

    @Test
    public void 유저_이메일_검색_테스트() {
        User user = userRepository.findUserByEmail("example").orElseThrow(() -> new IllegalArgumentException("해당 이메일을 가진 유저가 없습니다"));
        System.out.println(user.getEmail());
    }

    @Test
    public void 유저_플레이리스트_가져오기_테스트() {
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
        user.getUserPlaylists().forEach(userPlaylist -> System.out.println(userPlaylist.getId()));
    }

}
