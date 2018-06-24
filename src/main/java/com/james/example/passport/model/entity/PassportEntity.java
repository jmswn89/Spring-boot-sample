package com.james.example.passport.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author James Jayaputera (james.jayaputera@gmail.com)
 *
 */
@Entity
@Table(name="passport")
public class PassportEntity {

	@Id
	@Column
	private String docNo;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String placeOfBirth;
	
	@Column
	private String nationality;
	
	@Column
	private String sex;
	
	@Column
	private String authority;
	
	@Column
	private Date dateOfBirth;
	
	@Column
	private Date dateOfIssue;
	
	@Column
	private Date dateOfExpiry;

	@Column
	private String imageFilename;

	@Column
	private String imageContentType;
	
	@Column
	private byte[] image;

	public PassportEntity() {
	}
	
	public PassportEntity(String docNo, String firstName, String lastName, String placeOfBirth, String nationality,
			String sex, String authority, Date dateOfBirth, Date dateOfIssue, Date dateOfExpiry, String imageFilename,
			byte[] image, String imageContentType) {
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
		this.imageFilename = imageFilename;
		this.image = image;
		this.imageContentType = imageContentType;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
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
