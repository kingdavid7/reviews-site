package org.wecancodeit.reviews.controllers;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.exceptions.ReviewNotFoundException;
import org.wecancodeit.reviews.repositories.ReviewRepository;


@Controller
public class ReviewsController {

	@Resource
	private ReviewRepository reviewRepo;
	
	@GetMapping("/show-reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviewsModel", reviewRepo.findAllReviews());
		return "reviews-template";
	}
	
	
	@GetMapping("/review")
	public String findOneReview(@RequestParam Long id, Model  model) throws ReviewNotFoundException{
		if(reviewRepo.findOneReview(id) == null) {
			throw new ReviewNotFoundException();
		}
		model.addAttribute("reviewModel", reviewRepo.findOneReview(id));
		return "review-template";
		
	}
	
}
