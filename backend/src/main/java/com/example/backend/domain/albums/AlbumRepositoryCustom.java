package com.example.backend.domain.albums;

import com.example.backend.web.dto.AlbumResponseDto;
import com.querydsl.core.Tuple;

import java.util.List;

public interface AlbumRepositoryCustom {

    List<AlbumResponseDto> getAllAlbumsJoinedByProducer();

}
