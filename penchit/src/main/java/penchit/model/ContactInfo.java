package penchit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_info")
public class ContactInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTACT_ID")
    private int id;
	@Column(name = "CONTACT_NAME")
	private String name;
	@Column(name = "CONTACT_LANDLINE")
	private String landLineNo;
	@Column(name = "CONTACT_MOBILENO")
	private String mobileNo;
	@Column(name = "CONTACT_EMAIL")
	private String email;
	@Column(name = "CONTACT_ABOUT_US")
	private String aboutsUs;
	@Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DT")
    private Date createdDate;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Column(name = "UPDATED_DT")
    private Date updatedDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLandLineNo() {
		return landLineNo;
	}
	public void setLandLineNo(String landLineNo) {
		this.landLineNo = landLineNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAboutsUs() {
		return aboutsUs;
	}
	public void setAboutsUs(String aboutsUs) {
		this.aboutsUs = aboutsUs;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
}
