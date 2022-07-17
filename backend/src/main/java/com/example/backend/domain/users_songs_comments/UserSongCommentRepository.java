package com.example.backend.domain.users_songs_comments;

import com.example.backend.domain.songs.Song;
import com.example.backend.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSongCommentRepository extends JpaRepository<UserSongComment, Long> {

    Optional<UserSongComment> findBySongAndUser(Song song, User user);

}
