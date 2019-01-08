package com.raphael.Study_ReactiveWeb;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("local")
public class BoardRepositoryTests {
    @Autowired
    BoardRepository boardRepository;

    @Before
    public void init() {
        Board board = Board.builder()
                .title("test")
                .contents("contents")
                .authorId(1)
                .build();

        boardRepository.save(board);
    }

    @Test
    public void findAll() {
        Iterable<Board> boards = boardRepository.findAll();
        assertThat(boards).isNotEmpty();
    }

    @Test
    public void findById() {
        Board boardOne = Board.builder()
                .title("title1")
                .contents("contents1")
                .authorId(1)
                .build();
        boardRepository.save(boardOne);

        Optional<Board> findOne = boardRepository.findById(boardOne.getId());

        assertThat(findOne.get().getTitle()).isEqualTo(boardOne.getTitle());
        assertThat(findOne.get().getContents()).isEqualTo(boardOne.getContents());
        assertThat(findOne.get().getAuthorId()).isEqualTo(boardOne.getAuthorId());
    }
}
