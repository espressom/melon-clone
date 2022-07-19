package com.example.backend.domain.songs;

import com.example.backend.web.dto.SongResponseDto;

import java.util.List;

public interface SongRepositoryCustom {

    List<SongResponseDto> getAllSongsJoinedByProducer();

}
