package com.example.backend.domain.songs;

import com.example.backend.domain.BaseTime;
import com.example.backend.domain.Genre;
import com.example.backend.domain.albums.Album;
import com.example.backend.domain.producers.Producer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "songs")
public class Song extends BaseTime {

    @Id
    @Column(name = "song_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String songName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "composer_id")
    private Producer composer;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "lyricist_id")
    private Producer lyricist;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "arranger_id")
    private Producer arranger;

    @ManyToOne(optional = false)
    @JoinColumn(name = "singer_id")
    @JsonBackReference
    private Producer singer;

    private String lyric;

    private int totalLikeSum;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "album_id")
    private Album album;

    private boolean isValid = true;

    @Enumerated(value=EnumType.STRING)
    private Genre genre;

    @Builder
    public Song(String songName, Producer composer, Producer lyricist, Producer arranger, Producer singer, String lyric, int totalLikeSum, Album album, boolean isValid, Genre genre) {
        this.songName = songName;
        this.composer = composer;
        this.lyricist = lyricist;
        this.arranger = arranger;
        this.singer = singer;
        this.lyric = lyric;
        this.totalLikeSum = totalLikeSum;
        this.album = album;
        this.isValid = isValid;
        this.genre = genre;
    }
}
