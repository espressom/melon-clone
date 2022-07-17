package com.example.backend.domain.playlists;

import com.example.backend.domain.songs.Song;
import com.example.backend.domain.users_playlists.UserPlaylist;

import java.util.List;

public interface PlaylistRepositoryCustom {

    List<Playlist> getSongsByUserPlaylist(UserPlaylist userPlaylist);

}
