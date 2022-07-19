package com.example.backend.service.song;

import com.example.backend.domain.songs.SongRepository;
import com.example.backend.web.dto.SongResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SongService {

    private final SongRepository songRepository;

    @Transactional
    public List<SongResponseDto> getAllSongs() {
        return songRepository.getAllSongsJoinedByProducer();
    }

}
