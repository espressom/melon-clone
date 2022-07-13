package com.example.backend.domain.songs;

import com.example.backend.domain.BaseTimeEntity;
import com.example.backend.domain.Genre;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Songs extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    @Column(nullable = false)
    private String songName;

//    @ForeignKey()
    private Long composer;
    private Long lyricist;
    private Long arranger;
    private Long singer;

    private String lyric;

    private int totalLikeSum;

    private Long albumId;
    private boolean isValid;

    @Enumerated(value=EnumType.STRING)
    private Genre genre;

    @Builder
    public Songs(String songName, Long composer, Long lyricist, Long arranger, Long singer, String lyric, int totalLikeSum, Long albumId, boolean isValid, Genre genre) {
        this.songName = songName;
        this.composer = composer;
        this.lyricist = lyricist;
        this.arranger = arranger;
        this.singer = singer;
        this.lyric = lyric;
        this.totalLikeSum = totalLikeSum;
        this.albumId = albumId;
        this.isValid = isValid;
        this.genre = genre;
    }
}
