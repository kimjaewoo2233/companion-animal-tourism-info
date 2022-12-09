package com.example.popmov.service;

import com.example.popmov.dto.BoardDTO;
import com.example.popmov.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {

    public void saveBoard(BoardDTO boardDTO);

    public Page<BoardDTO> getList(Pageable pageable) ;

    public BoardDTO getRead(Long id);

    public void delete(BoardDTO boardDTO);

    public void modify(BoardDTO boardDTO);
}
