package com.example.backend.domain.albums;

import com.example.backend.domain.BaseTime;
import com.example.backend.domain.producers.Producer;
import com.example.backend.domain.songs.Song;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "producer_id")
    private Producer producer;

    private String agency;
    private String publisher;
    private String photoUrl;

    private Date releaseDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    private List<Song> songs = new ArrayList<>();

    @Builder
    public Album(String name, Producer producer, String agency, String publisher, String photoUrl, Date releaseDate) {
        this.name = name;
        this.producer = producer;
        this.agency = agency;
        this.publisher = publisher;
        this.photoUrl = photoUrl;
        this.releaseDate = releaseDate;
    }
}
