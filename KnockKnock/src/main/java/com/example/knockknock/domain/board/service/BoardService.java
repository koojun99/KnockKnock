package com.example.knockknock.domain.board.service;

import com.example.knockknock.domain.board.dto.GetBoardsResponseDto;
import com.example.knockknock.domain.board.entity.Board;
import com.example.knockknock.domain.board.repository.BoardRepository;
import com.example.knockknock.domain.post.repository.PostRepository;
import com.example.knockknock.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;


    @Transactional
    public void createBoard(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public List<GetBoardsResponseDto> getAllBoards(){
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(GetBoardsResponseDto::from)
                .collect(Collectors.toList());
    }
}
