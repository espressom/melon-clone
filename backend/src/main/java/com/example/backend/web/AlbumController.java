package com.example.backend.web;

import com.example.backend.service.album.AlbumService;
import com.example.backend.web.dto.AlbumResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping("/")
    public List<AlbumResponseDto> getAllAlbums() {
        return albumService.getAllAlbums();
    }

}
