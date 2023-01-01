package com.hectormtzm.universitydao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hectormtzm.universitydao.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    
}
