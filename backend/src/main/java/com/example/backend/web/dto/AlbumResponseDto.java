package com.example.backend.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumResponseDto {

    private Long AlbumId;
    private String AlbumName;
    private Long producerId;
    private String producerName;
    private String agency;
    private String publisher;
    private Date releaseDate;
    private String photoUrl;

}
