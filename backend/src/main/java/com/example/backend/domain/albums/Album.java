package com.example.backend.domain.albums;

import com.example.backend.domain.BaseTime;
import com.example.backend.domain.producers.Producer;
import com.example.backend.domain.songs.Song;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "albums")
public class Album extends BaseTime {

    @Id
    @Column(name="album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "album_name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "producer_id")
    private Producer producer;

    private String agency;
    private String publisher;
    private String photoUrl;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    private List<Song> songs = new ArrayList<>();

    @Builder
    public Album(String name, Producer producer, String agency, String publisher, String photoUrl) {
        this.name = name;
        this.producer = producer;
        this.agency = agency;
        this.publisher = publisher;
        this.photoUrl = photoUrl;
    }
}
