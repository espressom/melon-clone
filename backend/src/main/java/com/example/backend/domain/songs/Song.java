package com.example.backend.domain.songs;

import com.example.backend.domain.BaseTime;
import com.example.backend.domain.Genre;
import com.example.backend.domain.albums.Album;
import com.example.backend.domain.producers.Producer;
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

    @ManyToOne
    private Producer composer;

    @ManyToOne
    private Producer lyricist;

    @ManyToOne
    private Producer arranger;

    @ManyToOne
    private Producer singer;

    private String lyric;

    private int totalLikeSum;

    @ManyToOne(optional = false)
    private Album albums;

    private boolean isValid;

    @Enumerated(value=EnumType.STRING)
    private Genre genre;

}
