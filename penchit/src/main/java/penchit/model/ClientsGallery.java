package penchit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "clients_gallery")
public class ClientsGallery {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLI_GALLERY_ID")
	private Integer id;
	@Column(name = "CLI_GALLERY_NAME")
	private String name;
	@Column(name = "CLI_GALLERY_TYPE")
	private String type;
	@Lob
	@Column(name = "CLI_GALLERY_PIC")
	private byte[] picture;
	@Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DT")
    private Date createdDate;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Column(name = "UPDATED_DT")
    private Date updatedDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
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
