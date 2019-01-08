package com.raphael.Study_ReactiveWeb;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity(name = "board")
public class Board {
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(generator = "board-seq-gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "board-seq-gen", sequenceName = "board_id_seq")
    private long id;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "created_date", nullable = false)
    @Builder.Default
    private Date createdAt = new Date();

    @Column(name = "updated_date", nullable = false)
    @Builder.Default
    private Date updatedAt = new Date();

    @Column(name = "author_id", nullable = false)
    private Integer authorId;

    @Column(name = "visibleYn")
    @Builder.Default
    private Boolean visibleYn = true;

}
