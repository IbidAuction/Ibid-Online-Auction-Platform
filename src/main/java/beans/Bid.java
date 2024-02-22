package beans;

import java.util.Date;

public class Bid {
	private int bidId;
	private Item item;
	private User bidder;
	private int bidAmount;
	private Date bidTime;
	
	public Bid() {
		super();
	}
	public Bid(int bidId, Item item, User bidder, int bidAmount, Date bidTime) {
		super();
		this.bidId = bidId;
		this.item = item;
		this.bidder = bidder;
		this.bidAmount = bidAmount;
		this.bidTime = bidTime;
	}
	public Bid(Item item, User bidder, int bidAmount) {
		super();
		this.item = item;
		this.bidder = bidder;
		this.bidAmount = bidAmount;
	}
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public User getBidder() {
		return bidder;
	}
	public void setBidder(User bidder) {
		this.bidder = bidder;
	}
	public int getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Date getBidTime() {
		return bidTime;
	}
	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", item=" + item + ", bidder=" + bidder + ", bidAmount=" + bidAmount
				+ ", bidTime=" + bidTime + "]";
	}
	
	
}
