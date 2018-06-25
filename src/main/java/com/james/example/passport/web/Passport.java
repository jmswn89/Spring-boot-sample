package com.james.example.passport.web;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author James Jayaputera (james.jayaputera@gmail.com)
 *
 */
@Entity
public class Passport {

	@Id
	@NotNull
	@Size(min=4, max=10)
	private String docNo;
	
	@NotNull
	@Size(min=1, max=35)
	private String firstName;
	
	@NotNull
	@Size(min=1, max=35)
	private String lastName;
	
	@NotNull
	@Size(min=4, max=35)
	private String placeOfBirth;
	
	@NotNull
	@Size(min=4, max=35)
	private String nationality;
	
	@NotNull
	private String sex;
	
	@NotNull
	@Size(min=4, max=35)
	private String authority;
	
	@NotNull
	@Size(min=8, max=10)
	private String dateOfBirth;
	
	@NotNull
	@Size(min=8, max=10)
	private String dateOfIssue;
	
	@NotNull
	@Size(min=8, max=10)
	private String dateOfExpiry;
	
	private String image;

	private String imageFilename;
	
	private String imageContentType;
	

	public Passport(@NotNull String docNo, @NotNull String firstName, @NotNull String lastName,
			@NotNull String placeOfBirth, @NotNull String nationality, @NotNull String sex, @NotNull String authority,
			@NotNull String dateOfBirth, @NotNull String dateOfIssue, @NotNull String dateOfExpiry,
			@NotNull String image, @NotNull String imageFilename, @NotNull String imageContentType) {
		super();
		this.docNo = docNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.placeOfBirth = placeOfBirth;
		this.nationality = nationality;
		this.sex = sex;
		this.authority = authority;
		this.dateOfBirth = dateOfBirth;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiry = dateOfExpiry;
		this.image = image;
		this.imageFilename = imageFilename;
		this.imageContentType = imageContentType;
	}

	public Passport() {
		super();
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageFilename() {
		return imageFilename;
	}

	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}


	
}
