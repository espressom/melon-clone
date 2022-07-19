package com.example.backend.web;

import com.e2on.api.util.DtoToMapConverter;
import com.example.backend.service.song.SongService;
import com.example.backend.web.dto.SongResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    @GetMapping("/")
    public List<SongResponseDto> getAllSongs() {
        List<SongResponseDto> songs = songService.getAllSongs();
        songs = DtoToMapConverter.unpack(songs, SongResponseDto.class,1);
        return songs;
    }

}
