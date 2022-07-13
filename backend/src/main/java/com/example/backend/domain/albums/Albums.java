package com.example.backend.domain.albums;

import com.example.backend.domain.BaseTimeEntity;
import com.example.backend.domain.producers.Producers;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Albums extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    @Column(nullable = false)
    private String albumName;

    @ManyToOne(optional = false)
    private Producers producers;

    private String agency;
    private String publisher;
    private String photoUrl;
}
