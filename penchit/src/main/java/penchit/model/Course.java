package penchit.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "COURSE_ID")
    private Integer id;
    @Column(name = "COURSE_NAME")
    private String name;
    @Column(name = "COURSE_DESC")
    private String description;
    @Column(name = "COURSE_SYLLABUS")
    private String syllabus;
    @Column(name = "COURSE_PRICE")
    private Integer price;
    @Column(name = "COURSE_VERSION")
    private String version;
    @Lob
    @Column(name = "COURSE_LOGO")
    private byte[] logo;
    
    @ManyToMany
    @JoinTable(name="COURSE_GROUP",joinColumns=@JoinColumn(name="COURSE_ID", referencedColumnName="COURSE_ID"),inverseJoinColumns=@JoinColumn(name="GROUP_ID", referencedColumnName="GROUP_ID"))
    public Set<Group> groups;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
    	
}
