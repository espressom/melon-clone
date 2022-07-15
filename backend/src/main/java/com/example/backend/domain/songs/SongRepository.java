package com.example.backend.domain.songs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {

    Song findBySinger(Long singer_id);


}
