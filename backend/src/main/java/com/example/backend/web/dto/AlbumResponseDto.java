package com.example.backend.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class AlbumResponseDto {

    private Long AlbumId;
    private String AlbumName;
    private Long producerId;
    private String producerName;
    private String agency;
    private String publisher;
    private Date releaseDate;
    private String photoUrl;

    public AlbumResponseDto(Long albumId, String albumName, Long producerId, String producerName, String agency, String publisher, Date releaseDate, String photoUrl) {
        this.AlbumId = albumId;
        this.AlbumName = albumName;
        this.producerId = producerId;
        this.producerName = producerName;
        this.agency = agency;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.photoUrl = photoUrl;
    }
}
