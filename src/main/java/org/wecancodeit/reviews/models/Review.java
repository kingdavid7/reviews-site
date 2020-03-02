package org.wecancodeit.reviews.models;

public class Review {

	private Long id;
	private String title;
	private String image;
	private String category;
	private String content;
	
	public Review(Long id, String title, String image, String category, String content) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.category = category;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
