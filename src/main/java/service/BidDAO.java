package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Bid;
import beans.Item;
import beans.User;

public class BidDAO implements DAO<Bid>{
	@Override
	public boolean add(Bid bid) {
	    PreparedStatement ps = null;
	    int result = 0;
	    try {
	        Connection con = DBService.openConnection();
	        String insert = "INSERT INTO auction.Bid (item_id, bidder_id, bidAmount) VALUES (?, ?, ?)";
	        ps = con.prepareStatement(insert);
	        ps.setInt(1, bid.getItem().getItemID());
	        ps.setInt(2, bid.getBidder().getUserID());
	        ps.setInt(3, bid.getBidAmount());
	        result = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null)
	                ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return result == 1;
	}
	@Override
	public boolean update(Bid bid) {
	    PreparedStatement ps = null;
	    int result = 0;
	    try {
	        Connection con = DBService.openConnection();
	        String update = "UPDATE auction.Bid SET item_id=?, bidder_id=?, bidAmount=?, bidTime=? WHERE bidId=?";
	        ps = con.prepareStatement(update);
	        ps.setInt(1, bid.getItem().getItemID());
	        ps.setInt(2, bid.getBidder().getUserID());
	        ps.setInt(3, bid.getBidAmount());
	        ps.setTimestamp(4, new java.sql.Timestamp(bid.getBidTime().getTime()));
	        ps.setInt(5, bid.getBidId());
	        result = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null)
	                ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return result == 1;
	}

	@Override
	public boolean delete(int id) {
	    PreparedStatement ps = null;
	    int result = 0;
	    try {
	        Connection con = DBService.openConnection();
	        String delete = "DELETE FROM auction.Bid WHERE bidId=?";
	        ps = con.prepareStatement(delete);
	        ps.setInt(1, id);
	        result = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null)
	                ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return result == 1;
	}

	@Override
	public List<Bid> getAll() {
	    List<Bid> bids = new ArrayList<>();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        Connection con = DBService.openConnection();
	        String query = "SELECT * FROM auction.Bid";
	        ps = con.prepareStatement(query);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            Bid bid = new Bid();
	            bid.setBidId(rs.getInt("bidId"));
	            // Retrieve item and bidder information and set them in the bid object
	            int itemId = rs.getInt("item_id");
	            int bidderId = rs.getInt("bidder_id");
	            Item item = new ItemDAO().get(itemId);
	            User bidder = new UserDAO().get(bidderId);
	            bid.setItem(item);
	            bid.setBidder(bidder);
	            bid.setBidAmount(rs.getInt("bidAmount"));
	            bid.setBidTime(rs.getTimestamp("bidTime"));
	            bids.add(bid);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null)
	                rs.close();
	            if (ps != null)
	                ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return bids;
	}

	@Override
	public Bid get(int id) {
	    Bid bid = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        Connection con = DBService.openConnection();
	        String query = "SELECT * FROM auction.Bid WHERE bidId=?";
	        ps = con.prepareStatement(query);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            bid = new Bid();
	            bid.setBidId(rs.getInt("bidId"));
	            int itemId = rs.getInt("item_id");
	            int bidderId = rs.getInt("bidder_id");
	            Item item = new ItemDAO().get(itemId);
	            User bidder = new UserDAO().get(bidderId);
	            bid.setItem(item);
	            bid.setBidder(bidder);
	            bid.setBidAmount(rs.getInt("bidAmount"));
	            bid.setBidTime(rs.getTimestamp("bidTime"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null)
	                rs.close();
	            if (ps != null)
	                ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return bid;
	}


}
