package com.example.backend.domain.songs;

import com.example.backend.domain.producers.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {

}
