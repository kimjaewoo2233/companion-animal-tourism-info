package com.example.popmov.service.impl;

import com.example.popmov.dto.BoardDTO;
import com.example.popmov.entity.Board;
import com.example.popmov.repository.BoardRepository;
import com.example.popmov.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;


    public void saveBoard(BoardDTO boardDTO){
            boardRepository.save(BoardDTO.toEntity(boardDTO));
    }

    public Page<BoardDTO> getList(Pageable pageable) {
        return boardRepository.findAll(pageable).map(BoardDTO::toDTO);
    }

    @Override
    public BoardDTO getRead(Long id) {

        return BoardDTO.toDTO(boardRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public void delete(BoardDTO boardDTO) {
            boardRepository.deleteById(boardDTO.getId());
    }

    @Override
    @Transactional
    public void modify(BoardDTO dto) {
        Board board = boardRepository.findById(dto.getId()).get();
        board.modifyBoard(dto.getTitle(),dto.getContent(),dto.getVisit(),dto.getCompanion());

        boardRepository.save(board);
    }


}
