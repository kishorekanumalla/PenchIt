package penchit.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "group_master")
public class Group {
	
	 	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name = "GROUP_ID")
	    private Integer id;
	    @Column(name = "GROUP_NAME")
	    private String name;
	    @Column(name = "GROUP_DIVISIONS")
	    private String divisions;
	    @ManyToMany(mappedBy="groups")
	    public Set<Course> courses;
	    
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
		public String getDivisions() {
			return divisions;
		}

		public void setDivisions(String divisions) {
			this.divisions = divisions;
		}

		public Set<Course> getCourses() {
			return courses;
		}

		public void setCourses(Set<Course> courses) {
			this.courses = courses;
		}

		@Override
	    public boolean equals(Object object) {
	        if (object instanceof User){
	        	Group user = (Group) object;
	            return user.id == id;
	        }

	        return false;
	    }

	    @Override
	    public int hashCode() {
	        return id;
	    }


}
