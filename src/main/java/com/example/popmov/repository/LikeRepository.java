package com.example.popmov.repository;

import com.example.popmov.entity.Lik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikeRepository extends JpaRepository<Lik,Long> {


}
