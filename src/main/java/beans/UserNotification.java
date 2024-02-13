package beans;

import java.util.Date;

public class UserNotification {
	private int notificationId;
	private String message;
	private Date notificationTime;
	private User user;
	
	public UserNotification() {
		super();
	}
	public UserNotification(int notificationId, String message, Date notoficationTime, User user) {
		super();
		this.notificationId = notificationId;
		this.message = message;
		this.notificationTime = notoficationTime;
		this.user = user;
	}
	public UserNotification(String message, User user) {
		super();
		this.message = message;
		this.user = user;
	}
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getNotificationTime() {
		return notificationTime;
	}
	public void setNotificationTime(Date notoficationTime) {
		this.notificationTime = notoficationTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
