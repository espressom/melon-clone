package com.example.backend.domain.songs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongsRepository extends JpaRepository<Songs, Long> {

    Songs findBySinger(Long singer_id);


}
