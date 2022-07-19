package com.example.backend.domain.albums;

import com.example.backend.web.dto.AlbumResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.backend.domain.albums.QAlbum.album;
import static com.example.backend.domain.producers.QProducer.producer;

@RequiredArgsConstructor
public class AlbumRepositoryImpl implements AlbumRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<AlbumResponseDto> getAllAlbumsJoinedByProducer() {
        return queryFactory
                .from(album)
                .select(Projections.constructor(AlbumResponseDto.class,
                        album.id,
                        album.name,
                        producer.id,
                        producer.name,
                        album.agency,
                        album.publisher,
                        album.releaseDate,
                        album.photoUrl))
                .join(producer)
                .on(album.producer.eq(producer))
                .fetch();
    }

}
