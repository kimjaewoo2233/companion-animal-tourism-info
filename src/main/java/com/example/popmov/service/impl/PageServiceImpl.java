package com.example.popmov.service.impl;


import com.example.popmov.service.PageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PageServiceImpl implements PageService {

    private final int PAGE_LENGTH = 5;

    public List<Integer> getPagination(int currentPageNumber, int totalPages){
            int startNumber = Math.max(currentPageNumber - (PAGE_LENGTH/2),0);
            int endNumber = Math.min(startNumber + PAGE_LENGTH,totalPages);

            return IntStream.range(startNumber,endNumber).boxed().collect(Collectors.toList());
    }
}
