package com.hectormtzm.universitycrm.service;

import java.util.List;

import com.hectormtzm.universitycrm.entity.Review;

public interface ReviewService {
    List<Review> getAllReviews();

    Review getReview(Long id);

    Review saveReview(Review review, Long courseId);

    void deleteReview(Long id);

    List<Review> getReviewsByCourseId(Long courseId);
}