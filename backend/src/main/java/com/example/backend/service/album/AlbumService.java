package com.example.backend.service.album;

import com.example.backend.domain.albums.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AlbumService {

    private final AlbumRepository albumRepository;


}
