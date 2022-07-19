package com.example.backend.domain.albums;

import com.example.backend.web.dto.AlbumResponseDto;

import java.util.List;

public interface AlbumRepositoryCustom {

    List<AlbumResponseDto> getAllAlbumsJoinedByProducer();

}
