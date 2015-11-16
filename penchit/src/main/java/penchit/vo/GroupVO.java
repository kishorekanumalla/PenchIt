package penchit.vo;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupVO {

	
	private String groupName;
	
	private String division;
	
	private Integer groupId;
	
	private List<CourseVO> courses;
	
	
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public List<CourseVO> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseVO> courses) {
		this.courses = courses;
	}
}
