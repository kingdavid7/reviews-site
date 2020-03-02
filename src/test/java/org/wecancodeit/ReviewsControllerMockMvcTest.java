package org.wecancodeit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.reviews.controllers.ReviewsController;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.repositories.ReviewRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewsController.class)

public class ReviewsControllerMockMvcTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private Review reviewOne;
	
	@Mock
	private Review reviewTwo;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToAllReviews() throws Exception{
		this.mockMvc.perform(get("/show-reviews")).andExpect(status().isOk())
		.andExpect(view().name("reviews-template"));	
	}
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToReviewOnePage() throws Exception{
		when(reviewRepo.findOneReview(1L)).thenReturn(reviewOne);
		this.mockMvc.perform(get("/show-reviews/1")).andExpect(status().isOk())
		.andExpect(view().name("review-template"));	
	}

	@Test
	public void shouldAddAllReviewsToTheModel() throws Exception{
		when(reviewRepo.findAllReviews()).thenReturn(Arrays.asList(reviewOne, reviewTwo));
		this.mockMvc.perform(get("/show-reviews"))
		.andExpect(model().attribute("reviewsModel", hasSize(2)));
	}
	
	@Test
	public void shouldAddSingleReviewToTheModel() throws Exception{
		when(reviewRepo.findOneReview(1L)).thenReturn(reviewOne);
		this.mockMvc.perform(get("/show-reviews/1"))
		.andExpect(model().attribute("reviewModel", is(reviewOne)));
	}

	@Test
	public void ShouldReturnNotFoundForBadRequest() throws Exception{
		Long badId = 5L;
		when(reviewRepo.findOneReview(badId)).thenReturn(null);
		this.mockMvc.perform(get("show-reviews/5"))
		.andExpect(status().isNotFound());
	}
	
	
}

