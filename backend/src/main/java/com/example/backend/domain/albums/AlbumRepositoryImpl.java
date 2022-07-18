package com.example.backend.domain.albums;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Projections;

import java.util.List;

import static com.example.backend.domain.albums.QAlbum.album;
import static com.example.backend.domain.producers.QProducer.producer;

@RequiredArgsConstructor
public class AlbumRepositoryImpl implements AlbumRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Tuple> getAllAlbumsJoinedByProducer() {
        return queryFactory.from(album)
                .select(album.id,
                        album.name,
                        producer.id,
                        producer.name,
                        album.agency,
                        album.publisher,
                        album.releaseDate,
                        album.photoUrl)
                .join(producer)
                .on(album.producer.eq(producer))
                .fetch();
    }

}
