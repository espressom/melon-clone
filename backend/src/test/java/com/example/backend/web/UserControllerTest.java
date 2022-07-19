package com.example.backend.web;

import com.example.backend.domain.Gender;
import com.example.backend.domain.users.UserRepository;
import com.example.backend.web.dto.LoginRequestDto;
import com.example.backend.web.dto.ResponseDto;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.backend.web.dto.UserSignupRequestDto;
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

    @Test
    public void 유저_로그인_테스트() {
        LoginRequestDto requestDto = LoginRequestDto.builder().password("1").email("example").build();
        String url = "http://localhost:"+port+"/login/";
        ResponseEntity<HashMap> responseEntity = restTemplate.postForEntity(url, requestDto, HashMap.class);
        System.out.println(responseEntity.getHeaders().get("Authorization"));
    }

    @Test
    public void 유저_회원가입_테스트() throws Exception {
        // given
        UserSignupRequestDto requestDto = UserSignupRequestDto.builder()
                .password("1234")
                .email("example")
                .name("하잉")
                .gender(Gender.FEMALE)
                .nickname("닉넴")
                .photoUrl("사진경로")
                .build();

        String url = "http://localhost:"+port+"/signup/user";

        // when
        ResponseEntity<ResponseDto> responseEntity = restTemplate.postForEntity(url, requestDto, ResponseDto.class);

        // then
        assertThat(responseEntity.getStatusCode().is2xxSuccessful());

    }

}
