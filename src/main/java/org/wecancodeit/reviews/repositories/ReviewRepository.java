package org.wecancodeit.reviews.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.models.Review;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	
	private Review reviewOne = new Review(1L, "title", "/images/QforIoT.jpg", "review category", "content");//data that goes in my Application
	private Review reviewTwo = new Review(2L, "title2", "/images/IBM.jpg", "review category", "content2");//data that goes in my Application
	
	public ReviewRepository() {
		reviewList.put(reviewOne.getId(), reviewOne);
		reviewList.put(reviewTwo.getId(), reviewTwo);	
	}
	
	//I can use varargs for testing purposes to take on the necessary reviews
	public ReviewRepository(Review...reviews) {
		for ( Review review: reviews) {
			reviewList.put(review.getId(), review);
			
		}
	}

	public Review findOneReview(long id) {
		return reviewList.get(id);
	}

	public Collection<Review> findAllReviews() {
		return reviewList.values();
	}
}
