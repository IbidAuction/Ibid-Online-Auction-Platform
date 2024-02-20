package beans;

import java.sql.Timestamp;

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
	private Timestamp registeredDate;
	private Timestamp auctionStartDate;
	private Timestamp auctionEndDate;
	private Timestamp soldDate;
	private User seller;
	private User buyer;
	
	public Item() {
		super();
	}
	
	public Item(int itemID, String title, String description, String itemImage, String itemState, String itemCondition,
			int minIncrement, String category, int startPrice, boolean isSold, Timestamp registeredDate,
			Timestamp auctionStartDate, Timestamp auctionEndDate, Timestamp soldDate, User seller, User buyer) {
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
		this.auctionStartDate = auctionStartDate;
		this.auctionEndDate = auctionEndDate;
		this.soldDate = soldDate;
		this.seller = seller;
		this.buyer = buyer;
	}

	public Item(String title, String description, String itemImage, String itemCondition, int minIncrement,
			String category, int startPrice, Timestamp auctionStartDate, Timestamp auctionEndDate, User seller) {
		this.title = title;
		this.description = description;
		this.itemImage = itemImage;
		this.itemCondition = itemCondition;
		this.minIncrement = minIncrement;
		this.category = category;
		this.startPrice = startPrice;
		this.auctionStartDate = auctionStartDate;
		this.auctionEndDate = auctionEndDate;
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
	public Timestamp getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Timestamp registeredDate) {
		this.registeredDate = registeredDate;
	}
	public Timestamp getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(Timestamp soldDate) {
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
	public Timestamp getAuctionStartDate() {
		return auctionStartDate;
	}
	public void setAuctionStartDate(Timestamp auctionStartDate) {
		this.auctionStartDate = auctionStartDate;
	}
	public Timestamp getAuctionEndDate() {
		return auctionEndDate;
	}
	public void setAuctionEndDate(Timestamp auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", title=" + title + ", description=" + description + ", itemImage="
				+ itemImage + ", itemState=" + itemState + ", itemCondition=" + itemCondition + ", minIncrement="
				+ minIncrement + ", category=" + category + ", startPrice=" + startPrice + ", isSold=" + isSold
				+ ", registeredDate=" + registeredDate + ", auctionStartDate=" + auctionStartDate + ", auctionEndDate="
				+ auctionEndDate + ", soldDate=" + soldDate + ", seller=" + seller + ", buyer=" + buyer + "]";
	}
	
	
}
