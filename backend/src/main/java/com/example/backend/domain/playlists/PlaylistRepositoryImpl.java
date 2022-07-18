package com.example.backend.domain.playlists;

import com.example.backend.domain.users_playlists.UserPlaylist;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.backend.domain.playlists.QPlaylist.playlist;

@RequiredArgsConstructor
public class PlaylistRepositoryImpl implements PlaylistRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Playlist> getSongsByUserPlaylist(UserPlaylist userPlaylist) {
        return queryFactory
                .selectFrom(playlist)
                .where(playlist.userPlaylist.eq(userPlaylist))
                .fetch();
    }
}
