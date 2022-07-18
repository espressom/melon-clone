package com.example.backend.web;

import com.example.backend.domain.Gender;
import com.example.backend.domain.users.UserRepository;
import com.example.backend.web.dto.UserLoginRequestDto;
import com.example.backend.web.dto.UserSaveRequestDto;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

//    @Test
//    public void 유저_로그인_테스트() {
//        UserLoginRequestDto requestDto = UserLoginRequestDto.builder().password("1234").email("example1234").build();
//        String url = "http://localhost:"+port+"/user/";
//        ResponseEntity<HashMap> responseEntity = restTemplate.postForEntity(url, requestDto, HashMap.class);
//        System.out.println(responseEntity.getHeaders().get("Authorization"));
//    }

    @Test
    public void 유저_로그인_테스트() {
        UserLoginRequestDto requestDto = new UserLoginRequestDto("example", "1");
        String url = "http://localhost:"+port+"/user/";
        ResponseEntity<HashMap> responseEntity = restTemplate.postForEntity(url, requestDto, HashMap.class);
        System.out.println(responseEntity.getHeaders().get("Authorization"));
    }

    @Test
    public void 유저_회원가입_테스트() throws Exception {
        // given
        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .password("1234")
                .email("example1")
                .name("하잉")
                .gender(Gender.FEMALE)
                .nickname("닉넴")
                .photoUrl("사진경로")
                .build();

        String url = "http://localhost:"+port+"/user/registration";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode().is2xxSuccessful());
    }

}
