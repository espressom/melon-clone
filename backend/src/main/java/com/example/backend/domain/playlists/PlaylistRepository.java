package com.example.backend.domain.playlists;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>, PlaylistRepositoryCustom {
}
