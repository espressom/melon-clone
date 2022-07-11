package com.example.backend.web;

import com.example.backend.domain.posts.Posts;
import com.example.backend.domain.posts.PostsRepository;
import com.example.backend.web.dto.PostsResponseDto;
import com.example.backend.web.dto.PostsSaveRequestDto;
import com.example.backend.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

//    @After
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception {
        // given
        String title = "title";
        String content = "content";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder().title(title).content(content).author("author").build();

        String url = "http://localhost:"+port+"/api/v1/posts";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

    }

    @Test
    public void Posts_조회된다() throws Exception {
        // given
        Posts registeredPost = postsRepository.save(Posts.builder().title("테스트 제목").author("김코딩").content("테스트 내용").build());
        String url = "http://localhost:"+port+"/api/v1/posts/"+registeredPost.getId();

        // when
        ResponseEntity<Posts> resp = restTemplate.getForEntity(url, Posts.class);
        System.out.println(resp);

        // then
        assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resp.getBody().getAuthor()).isEqualTo("김코딩");

    }

    @Test
    public void Posts_수정된다() throws Exception {
        // given

        // 수정을 확인하기 위해 먼저 게시글을 저장
        String title = "title";
        String content = "content";
        Posts savedPosts = postsRepository.save(Posts.builder().title(title).content(content).author("author").build());
        // 저장한 객체를 DAO(postsRepository)에서 가져오고, id 값에 접근
        Long updateId = savedPosts.getId();
        System.out.println(updateId);

        // 갱신 시 사용할 DTO 생성
        String expectedTitle = "title2";
        String expectedContent = "content2";
        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder().title(expectedTitle).content(expectedContent).build();


        String url = "http://localhost:"+port+"/api/v1/posts/"+updateId;

        // 별도의 헤더는 추가하지 않고 메시지만 담아 HttpEntity 객체 생성
        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        // when
        // 브라우저 대신 restTemplate을 사용해 요청을 보내고 응답 결과를 responseEntity에 저장
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // then
        // responseEntity의 응답 상태코드가 200인지 확인
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(requestEntity.getBody()).isGreaterThan(0L); // 오류

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(all.size()-1).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(all.size()-1).getContent()).isEqualTo(expectedContent);


    }



}
