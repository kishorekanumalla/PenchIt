package penchit.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CourseVO {
	
	private String courseName;
	private Integer courseId;
	private String courseDesc;
	private String courseSyllabus;
	private Integer coursePrice;
	private byte[] courseLogo;
	private String version;
	private String courseLogoName;
	private String groupName;
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	public String getCourseSyllabus() {
		return courseSyllabus;
	}
	public void setCourseSyllabus(String courseSyllabus) {
		this.courseSyllabus = courseSyllabus;
	}
	public Integer getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(Integer coursePrice) {
		this.coursePrice = coursePrice;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCourseLogoName() {
		return courseLogoName;
	}
	public void setCourseLogoName(String courseLogoName) {
		this.courseLogoName = courseLogoName;
	}
	public byte[] getCourseLogo() {
		return courseLogo;
	}
	public void setCourseLogo(byte[] courseLogo) {
		this.courseLogo = courseLogo;
	}
	
	
}
