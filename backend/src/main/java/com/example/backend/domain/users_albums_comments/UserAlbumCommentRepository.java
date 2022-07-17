package com.example.backend.domain.users_albums_comments;

import com.example.backend.domain.albums.Album;
import com.example.backend.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAlbumCommentRepository extends JpaRepository<UserAlbumComment, Long> {

    Optional<UserAlbumComment> findByAlbumAndUser(Album album, User user);

}
