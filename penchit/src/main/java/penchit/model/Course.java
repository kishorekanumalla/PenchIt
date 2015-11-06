package penchit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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

}
