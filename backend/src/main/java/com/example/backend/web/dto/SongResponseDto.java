package com.example.backend.web.dto;

import com.e2on.api.data.Dto;
import com.example.backend.domain.Genre;
import com.example.backend.domain.albums.Album;
import com.example.backend.domain.producers.Producer;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SongResponseDto extends Dto {
    private Long songId;
    private Genre songGenre;
    private boolean isValidSong;
    private String songName;
    private String lyric;
    private int totalLikeSum;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Album album;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Producer singer;
    private String singerName;
}
