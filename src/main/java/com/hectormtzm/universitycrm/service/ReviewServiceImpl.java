package com.hectormtzm.universitycrm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hectormtzm.universitycrm.entity.Course;
import com.hectormtzm.universitycrm.entity.Review;
import com.hectormtzm.universitycrm.exception.NotFoundException;
import com.hectormtzm.universitycrm.repository.ReviewRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CourseService courseService;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReview(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Review with id '" + id + "' does not exist in our records"));
    }

    @Override
    public List<Review> getReviewsByCourseId(Long courseId) {
        Course course = courseService.getCourse(courseId);
        return course.getReviews();
    }

    @Override
    public Review saveReview(Review review, Long courseId) {
        Course course = courseService.getCourse(courseId);
        review.setCourse(course);
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        Review review = getReview(id);
        reviewRepository.delete(review);
    }
}
