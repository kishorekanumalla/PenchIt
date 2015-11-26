package penchit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import penchit.exception.ApplicationException;
import penchit.model.ClientsGallery;
import penchit.model.ContactInfo;
import penchit.model.Course;
import penchit.model.Group;
import penchit.vo.ClientGalleryVO;
import penchit.vo.ContactInfoVO;
import penchit.vo.CourseVO;
import penchit.vo.GroupVO;

public class AdminHelper {
	
	
	public static Group convertGroupVOToDTO(GroupVO courseGroupVO) throws ApplicationException {
		Group group;
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			group = new Group();
			group.setName(courseGroupVO.getGroupName());
			group.setDivisions(courseGroupVO.getDivision());
			group.setId(courseGroupVO.getGroupId());
			group.setCreatedBy(user.getUsername());
			group.setCreatedDate(new Date());
			group.setUpdatedBy(user.getUsername());
			group.setUpdatedDate(new Date());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
		return group;
	}
	public static List<GroupVO> convertGroupListDTOToVO(List<Group> group)throws ApplicationException {
		List<GroupVO> groupVOList;
		try {
			groupVOList = new ArrayList<GroupVO>();
			for (Group cGroup:group){
				GroupVO groupVO = new GroupVO();
				groupVO.setGroupName(cGroup.getName());
				groupVO.setDivision(cGroup.getDivisions());
				groupVO.setGroupId(cGroup.getId());
				groupVOList.add(groupVO);
			}
		} catch (Exception e) {
			throw new ApplicationException();	
		}
		return groupVOList;
	}
	public static GroupVO convertGroupDTOToVO(Group courseGroup) throws ApplicationException {
			GroupVO groupVO;
			try {
				groupVO = new GroupVO();
				groupVO.setGroupName(courseGroup.getName());
				groupVO.setDivision(courseGroup.getDivisions());
				groupVO.setGroupId(courseGroup.getId());
			} catch (Exception e) {
				throw new ApplicationException();	
			}
		return groupVO;
	}
	public static List<CourseVO> convertCourseListDTOToVO(List<Course> courseList) throws ApplicationException {
		List<CourseVO> courseListVO = new ArrayList<CourseVO>();
		try {
			for (Course course:courseList){
				CourseVO courseVO = new CourseVO();
				courseVO.setCourseId(course.getId());
				courseVO.setCourseDesc(course.getDescription());
				courseVO.setCourseLogo(course.getLogo());
				courseVO.setCourseName(course.getName());
				courseVO.setCoursePrice(course.getPrice());
				courseVO.setCourseLogoName(course.getLogoName());
				courseVO.setVersion(course.getVersion());
				courseVO.setCourseSyllabus(course.getSyllabus());
				courseListVO.add(courseVO);
			}
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return courseListVO;
}
	public static CourseVO convertCourseDTOToVO(Course course) throws ApplicationException {
		CourseVO courseVO = new CourseVO();
		try {
			courseVO.setCourseId(course.getId());
			courseVO.setCourseDesc(course.getDescription());
			courseVO.setCourseLogo(course.getLogo());
			courseVO.setCourseName(course.getName());
			courseVO.setCoursePrice(course.getPrice());
			courseVO.setCourseLogoName(course.getLogoName());
			courseVO.setVersion(course.getVersion());
			courseVO.setCourseSyllabus(course.getSyllabus());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return courseVO;
}
	public static Course convertCourseVOToDTO(CourseVO courseVO) throws ApplicationException {
		Course course = new Course();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			course.setName(courseVO.getCourseName());
			course.setSyllabus(courseVO.getCourseSyllabus());
			course.setDescription(courseVO.getCourseDesc());
			course.setPrice(courseVO.getCoursePrice());
			course.setLogo(courseVO.getCourseLogo());
			course.setLogoName(courseVO.getCourseLogoName());
			course.setVersion(courseVO.getVersion());
			course.setCreatedBy(user.getUsername());
			course.setCreatedDate(new Date());
			course.setUpdatedBy(user.getUsername());
			course.setUpdatedDate(new Date());
			course.setId(courseVO.getCourseId());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return course;
}
	public static ContactInfo convertContactVOToDTO(ContactInfoVO contactInfoVO) throws ApplicationException {
		ContactInfo contactInfo = new ContactInfo();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			contactInfo.setAboutsUs(contactInfoVO.getContactAboutsUs());
			contactInfo.setEmail(contactInfoVO.getContactEmail());
			contactInfo.setId(contactInfoVO.getContactId());
			contactInfo.setLandLineNo(contactInfoVO.getContactLandLineNo());
			contactInfo.setMobileNo(contactInfoVO.getContactMobileNo());
			contactInfo.setName(contactInfoVO.getContactName());
			contactInfo.setCreatedBy(user.getUsername());
			contactInfo.setCreatedDate(new Date());
			contactInfo.setUpdatedBy(user.getUsername());
			contactInfo.setUpdatedDate(new Date());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return contactInfo;
}
	public static ContactInfoVO convertContactDTOToVO(ContactInfo contactInfo) throws ApplicationException {
		ContactInfoVO contactInfoVO = new ContactInfoVO();
		try {
			contactInfoVO.setContactAboutsUs(contactInfo.getAboutsUs());
			contactInfoVO.setContactEmail(contactInfo.getEmail());
			contactInfoVO.setContactId(contactInfo.getId());
			contactInfoVO.setContactLandLineNo(contactInfo.getLandLineNo());
			contactInfoVO.setContactMobileNo(contactInfo.getMobileNo());
			contactInfoVO.setContactName(contactInfo.getName());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return contactInfoVO;
}
	public static ClientGalleryVO convertClientGalleryDTOToVO(ClientsGallery clientsGallery) throws ApplicationException {
		ClientGalleryVO clientGalleryVO = new ClientGalleryVO();
		try {
			clientGalleryVO.setClientGalleryId(clientsGallery.getId());
			clientGalleryVO.setClientGalleryName(clientsGallery.getName());
			clientGalleryVO.setClientGalleryPic(clientsGallery.getPicture());
			clientGalleryVO.setClientGalleryType(clientsGallery.getType());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return clientGalleryVO;
	}
	public static List<ClientGalleryVO> convertClientsGalleryListDTOToVO(List<ClientsGallery> clientsGalleryList) throws ApplicationException {
		List<ClientGalleryVO> clientGalleryVOList = new ArrayList<ClientGalleryVO>();
		try {
			for (ClientsGallery clientsGallery : clientsGalleryList) {
				ClientGalleryVO  clientGalleryVO = new ClientGalleryVO();
				clientGalleryVO.setClientGalleryId(clientsGallery.getId());
				clientGalleryVO.setClientGalleryName(clientsGallery.getName());
				clientGalleryVO.setClientGalleryPic(clientsGallery.getPicture());
				clientGalleryVO.setClientGalleryType(clientsGallery.getType());
				clientGalleryVOList.add(clientGalleryVO);
			}
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return clientGalleryVOList;
	}
	public static ClientsGallery convertClientGalleryVOToDTO(ClientGalleryVO clientsGalleryVO) throws ApplicationException {
		ClientsGallery clientsGallery = new ClientsGallery();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			clientsGallery.setId(clientsGalleryVO.getClientGalleryId());
			clientsGallery.setName(clientsGalleryVO.getClientGalleryName());
			clientsGallery.setPicture(clientsGalleryVO.getClientGalleryPic());
			clientsGallery.setType(clientsGalleryVO.getClientGalleryType());
			clientsGallery.setCreatedBy(user.getUsername());
			clientsGallery.setCreatedDate(new Date());
			clientsGallery.setUpdatedBy(user.getUsername());
			clientsGallery.setUpdatedDate(new Date());
		} catch (Exception e) {
			throw new ApplicationException();	
		}
	return clientsGallery;
	}
}
