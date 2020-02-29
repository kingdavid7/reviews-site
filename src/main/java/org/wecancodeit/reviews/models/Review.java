package org.wecancodeit.reviews.models;

public class Review {

	private Long id;
	private String title;
	private String imageUrl;
	private String reviewCategory;
	private String content;
	
	public Review(Long id, String title, String imageUrl, String reviewCategory, String content) {
		super();
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.reviewCategory = reviewCategory;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getReviewCategory() {
		return reviewCategory;
	}

	public void setReviewCategory(String reviewCategory) {
		this.reviewCategory = reviewCategory;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
