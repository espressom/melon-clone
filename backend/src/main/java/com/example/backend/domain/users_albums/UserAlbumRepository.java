package com.example.backend.domain.users_albums;

import com.example.backend.domain.albums.Album;
import com.example.backend.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAlbumRepository extends JpaRepository<UserAlbum, Long> {
    UserAlbum findByAlbumAndUser(Album album, User user);
}
