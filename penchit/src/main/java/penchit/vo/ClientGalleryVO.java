package penchit.vo;

public class ClientGalleryVO {
	
	private int clientGalleryId;
	private String clientGalleryName;
	private String clientGalleryType;
	private byte[] clientGalleryPic;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getClientGalleryId() {
		return clientGalleryId;
	}
	public void setClientGalleryId(int clientGalleryId) {
		this.clientGalleryId = clientGalleryId;
	}
	public String getClientGalleryName() {
		return clientGalleryName;
	}
	public void setClientGalleryName(String clientGalleryName) {
		this.clientGalleryName = clientGalleryName;
	}
	public String getClientGalleryType() {
		return clientGalleryType;
	}
	public void setClientGalleryType(String clientGalleryType) {
		this.clientGalleryType = clientGalleryType;
	}
	public byte[] getClientGalleryPic() {
		return clientGalleryPic;
	}
	public void setClientGalleryPic(byte[] clientGalleryPic) {
		this.clientGalleryPic = clientGalleryPic;
	}

}
