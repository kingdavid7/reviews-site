package org.wecancodeit.reviews.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.models.Review;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	
	private Review reviewOne = new Review(1L, "Best Internet of Things Platforms (IoT)", "images/QforIoT.jpgTech", "Tech", "With IoT platforms, developers can build applications specifically for IoT purposes. These platforms provide users with the ability to quickly build, test, deploy, and iterate on IoT-specific applications. Once built, businesses can connect these applications and continuously improve the solutions. IoT platforms often offer similar functionality to low or no-code development platforms, such as drag-and-drop elements and WYSIWYG editors for non-developers. However, most do require some level of coding knowledge, and the more sophisticated platforms may require highly skilled developers. In addition to their standard functionality, some cloud platform as a service products may offer the ability to build IoT enabled applications.\r\n" + 
			"		       To qualify for inclusion in the IoT Platforms category, a product must:"
			+ "         1. Provide a platform for developers to build IoT-specific applications\r\n" + 
			"			2. Offer application management tools for IoT specific application\r\n" + 
			"			3. Possess the ability to deploy connected IoT application");
	
	private Review reviewTwo = new Review(2L, "The Best IoT Companies in 2020", "images/IoT2020.jpg", "Internet of Things", "Google Cloud IoT Core, IBM Watson IoT Platform, AWS IoT Core are among the top trending IoT companies providers, "
			+ "Google IoT shows that it is a fully managed service to easily and securely connect, manage, and ingest data from globally dispersed devices, while IBM Watson IoT Platform can help you get a quick start on your next Internet of Things project. It is a fully managed, cloud-hosted service designed to make it simple to derive value from your Internet of Things devices. It provides capabilities such as device registration, connectivity, control, rapid visualization and storage of Internet of Things data. Connect and Manage devices: Connect to the Watson IoT Platform on IBM Cloud with ease, then set up and manage your IoT devices and data to start creating your own applications, visualization dashboards and mobile IoT apps. Build quickly and securely: Find the tools and services you need to create your IoT applications including cognitive APIs, Weather Company data, blockchain and more. Extend with Watson Cognitive APIs: Create a better experience with a natural voice interface or image recognition "
			+ ",AMAZON AWS IoT Core is a managed cloud platform that lets connected devices easily and securely interact with cloud applications and other devices.AWS IoT Core supports HTTP, WebSockets, and MQTT, a lightweight communication protocol specifically designed to tolerate intermittent connections, minimize the code footprint on devices, and reduce network bandwidth requirements, No doubt that soon IoT will be the FUTURE of Technology. ");
	
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
