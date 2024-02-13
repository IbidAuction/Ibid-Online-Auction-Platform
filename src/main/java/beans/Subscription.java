package beans;

import java.util.Date;

public class Subscription {
	private int subscriptionId;
	private User user;
	private String subscriptionName;
	private Date startDate;
	private Date endDate;
	private int price;
	private boolean isActive;
	
	public Subscription() {
		super();
	}
	public Subscription(int subscriptionId, User user, String subscriptionName, Date startDate, Date endDate, int price,
			boolean isActive) {
		super();
		this.subscriptionId = subscriptionId;
		this.user = user;
		this.subscriptionName = subscriptionName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.isActive = isActive;
	}
	public Subscription(User user, String subscriptionName, Date startDate, Date endDate, int price) {
		super();
		this.user = user;
		this.subscriptionName = subscriptionName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}
	public int getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSubscriptionName() {
		return subscriptionName;
	}
	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
