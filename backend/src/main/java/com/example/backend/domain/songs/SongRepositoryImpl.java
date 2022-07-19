package com.example.backend.domain.songs;

import com.example.backend.web.dto.SongResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.backend.domain.producers.QProducer.producer;
import static com.example.backend.domain.songs.QSong.song;

@RequiredArgsConstructor
public class SongRepositoryImpl implements SongRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<SongResponseDto> getAllSongsJoinedByProducer() {
        return queryFactory
                .from(song)
                .select(Projections.constructor(SongResponseDto.class,
                        song.id,
                        song.genre,
                        song.isValid.as("isValidSong"),
                        song.songName,
                        song.lyric,
                        song.totalLikeSum,
                        song.album,
                        song.singer,
                        producer.name.as("singerName")))
                .join(producer)
                .on(song.singer.eq(producer))
                .fetch();
    }

}
