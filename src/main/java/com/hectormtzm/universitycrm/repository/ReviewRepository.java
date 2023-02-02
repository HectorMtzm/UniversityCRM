package com.hectormtzm.universitycrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hectormtzm.universitycrm.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    
}
