Reviews Site
-----------
                                                      Overview:


Create a reviews site that categorizes reviews. Create reviews about anything you like: tech, travel, toys, they’re all good.

Create a Spring Boot + MVC app that displays a list of reviews, allowing us to click on an individual review to see its details.

Tasks
Required Tasks
Create/configure a Spring Boot/MVC application.
Create a Review class for the content of reviews. Its instance variables (attributes) should include:
id (make this of type long – you’ll find out why later) – just use arbitrary, unique numbers for these ids
title
image url
review category
content
whatever other things you’d like to include. Some ideas:
date
description/synopsis
Stretch Task: tags (this should probably be a Collection)
accessor (get* methods) that return information about review attributes. These will allow your Thymeleaf templates to display information about reviews.
Create a ReviewRepository class
This class should be annotated properly so that it can be injected into ReviewsController.
It should have a constructor that creates your Review instances and populates a Map that stores your reviews, using each review’s id as the map key.
It should have a method to find all reviews
It should have a method to find one review by id
Create a ReviewsController class.
apply proper annotation
It should inject…something appropriately
It should have a method mapped to a url that puts all of your reviews into the model, forwarding to a “reviews” template.
It should have a method mapped to a url including an id parameter that puts one of your reviews into the model, forwarding to a “review” template. This method should expect an “id” query parameter in order to select a specific review.
Place images you use into your src/main/resources/static/images folder and link to them there. Example: if your image is in src/main/resources/static/images/foo.jpg, you would reference it in your application as /images/foo.jpg.

Use your html/css-fu to style to your pages consistently and to make them appealing.
Tip: Use Creative Commons Image Search to find images that are free for use.

Grading
Find the rubric here.

Thymeleaf Tips
Iteration
We use th:each to iterate over collections in Thymeleaf. If I had a collection called widgets in my model, each of these having a name attribute, I would do the following to generate a <div> for each of these. widget is the name of my iteration variable, much like the for each loops you’re familar with:

<div th:each="widget: ${widgets}" th:text="${widget.name}" />
This would result in something like the following, given the names “fee”, “fie”, and “foe”:

<div>fee</div>
<div>fie</div>
<div>foe</div>
(See the tutorial section on iteration.)

Link URLs
Link urls have a special syntax in Thymeleaf, the @ syntax: @{...}. If I had an object called foo in the model, with a getId() method, and wanted to create a query parameter with the id, I would reference it as follows:

<a th:href="@{/doAThing(thingId=${foo.id})}">link text</a>
This would result in the following being rendered, assuming that foo.getId() returns 42:

<a href="/doAThing?thingId=42">link text</a>
(See the tutorial section on link urls.)

References
Thymeleaf Tutorial (Note: this is not specific to using it with Spring MVC)
