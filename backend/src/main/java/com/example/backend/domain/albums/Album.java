package com.example.backend.domain.albums;

import com.example.backend.domain.BaseTime;
import com.example.backend.domain.producers.Producer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Producer producer;

    private String agency;
    private String publisher;
    private String photoUrl;
}
