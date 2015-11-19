package penchit.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactInfoVO {
	
	 	private int contactId;	
		private String contactName;
		private String contactLandLineNo;
		private String contactMobileNo;
		private String contactEmail;
		private String contactAboutsUs;
		
		public int getContactId() {
			return contactId;
		}
		public void setContactId(int contactId) {
			this.contactId = contactId;
		}
		public String getContactName() {
			return contactName;
		}
		public void setContactName(String contactName) {
			this.contactName = contactName;
		}
		public String getContactLandLineNo() {
			return contactLandLineNo;
		}
		public void setContactLandLineNo(String contactLandLineNo) {
			this.contactLandLineNo = contactLandLineNo;
		}
		public String getContactMobileNo() {
			return contactMobileNo;
		}
		public void setContactMobileNo(String contactMobileNo) {
			this.contactMobileNo = contactMobileNo;
		}
		public String getContactEmail() {
			return contactEmail;
		}
		public void setContactEmail(String contactEmail) {
			this.contactEmail = contactEmail;
		}
		public String getContactAboutsUs() {
			return contactAboutsUs;
		}
		public void setContactAboutsUs(String contactAboutsUs) {
			this.contactAboutsUs = contactAboutsUs;
		}

}
