package com.bradend.ExamBelt.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="shows")
public class Show {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=1, max=200, message="must have a title")
	private String title;
	
	@Size(min=2, max=200, message="must have a network, min 2 characters")
	private String network;
	
	@Size(min=2, max=200, message="must have a description, min 2 characters")
	private String description;
	
	@Size(min=2, max=200, message="must have a review, min 2 characters")
	private String review;

	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
//	RELATIONSHIP
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
	
//	 CREATED AND UPDATED AT
	@PrePersist
	 protected void onCreate() {
		 this.createdAt = new Date();
	 }
	 @PreUpdate
	 protected void onUpdate(){
		 this.updatedAt = new Date();
	 }
	
//	EMPTY CONSTRUCTOR
	public Show() {
		
	}
//	CONSTRUCTORS
	public Show(Long id, @NotNull @Size(min = 2, max = 200) String title, @Size(min = 2, max = 200) String network,
			@Size(min = 2, max = 200) String description, @Size(min= 2, max = 200) String review, Date createdAt, Date updatedAt, User user) {
		super();
		this.id = id;
		this.title = title;
		this.network = network;
		this.description = description;
		this.review = review;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
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
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getDescription() {
		return description;
	}
	public String getReview() {
		return review;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	


	
}
