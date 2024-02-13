package beans;

import java.util.Date;

public class Item {
	private int itemID;
	private String title;
	private String description;
	private String itemImage;
	private String itemState;
	private String itemCondition;
	private int minIncrement;
	private String category;
	private int startPrice;
	private boolean isSold;
	private Date registeredDate;
	private Date soldDate;
	private User seller;
	private User buyer;
	
	public Item() {
		super();
	}
	public Item(int itemID, String title, String description, String itemImage, String itemState, String itemCondition,
			int minIncrement, String category, int startPrice, boolean isSold, Date registeredDate, Date soldDate,
			User seller, User buyer) {
		super();
		this.itemID = itemID;
		this.title = title;
		this.description = description;
		this.itemImage = itemImage;
		this.itemState = itemState;
		this.itemCondition = itemCondition;
		this.minIncrement = minIncrement;
		this.category = category;
		this.startPrice = startPrice;
		this.isSold = isSold;
		this.registeredDate = registeredDate;
		this.soldDate = soldDate;
		this.seller = seller;
		this.buyer = buyer;
	}
	public Item(String title, String description, String itemImage, String itemCondition, String category,
			int startPrice, int minIncrement, User seller) {
		super();
		this.title = title;
		this.description = description;
		this.itemImage = itemImage;
		this.itemCondition = itemCondition;
		this.category = category;
		this.startPrice = startPrice;
		this.minIncrement = minIncrement;
		this.seller = seller;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public String getItemState() {
		return itemState;
	}
	public void setItemState(String itemState) {
		this.itemState = itemState;
	}
	public String getItemCondition() {
		return itemCondition;
	}
	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}
	public int getMinIncrement() {
		return minIncrement;
	}
	public void setMinIncrement(int minIncrement) {
		this.minIncrement = minIncrement;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}
	public boolean isSold() {
		return isSold;
	}
	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public Date getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	
}
