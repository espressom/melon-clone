package com.example.backend.domain.songs;

import com.example.backend.domain.BaseTimeEntity;
import com.example.backend.domain.Genre;
import com.example.backend.domain.albums.Albums;
import com.example.backend.domain.producers.Producers;
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

    @ManyToOne
    private Producers composer;

    @ManyToOne
    private Producers lyricist;

    @ManyToOne
    private Producers arranger;

    @ManyToOne
    private Producers singer;

    private String lyric;

    private int totalLikeSum;

    @ManyToOne(optional = false)
    private Albums albums;

    private boolean isValid;

    @Enumerated(value=EnumType.STRING)
    private Genre genre;

}
