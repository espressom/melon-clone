package com.example.backend.service.album;

import com.example.backend.domain.albums.AlbumRepository;
import com.example.backend.web.dto.AlbumResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    @Transactional
    public List<AlbumResponseDto> getAllAlbums() {
        return albumRepository.getAllAlbumsJoinedByProducer();
    }

//    public Li

}
