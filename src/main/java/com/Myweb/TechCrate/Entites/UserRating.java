package com.Myweb.TechCrate.Entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userrating")
public class UserRating {
	@Id
	@Column(name="username")
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFeedbackmsg() {
		return feedbackmsg;
	}
	public void setFeedbackmsg(String feedbackmsg) {
		this.feedbackmsg = feedbackmsg;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Column(name="feedbackmsg")
	private String feedbackmsg;
	@Column(name="rating")
	private int rating;
	
}
