package penchit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_group")
public class CourseGroup {
	
	 	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name = "ID")
	    private Integer id;
	    @Column(name = "NAME")
	    private String name;
	    @Column(name = "DIVISIONS")
	    private String divisions;
	    
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

		@Override
	    public boolean equals(Object object) {
	        if (object instanceof User){
	        	CourseGroup user = (CourseGroup) object;
	            return user.id == id;
	        }

	        return false;
	    }

	    @Override
	    public int hashCode() {
	        return id;
	    }


}
