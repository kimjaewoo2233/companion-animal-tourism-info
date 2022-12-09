package com.example.popmov.service;

import java.util.List;

public interface PageService {

    public List<Integer> getPagination(int currentPageNumber, int totalPages);
}
