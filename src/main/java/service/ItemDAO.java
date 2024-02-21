package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Item;
import beans.User;

public class ItemDAO implements DAO<Item> {

    @Override
    public boolean add(Item t) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            System.out.println("Connection opened successfully.");
            String insert = "INSERT INTO auction.Item (title, description, itemImage, itemCondition, minIncrement, category, startPrice, sellerID, auctionStartDate, auctionEndDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(insert);
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setString(3, t.getItemImage());
            ps.setString(4, t.getItemCondition());
            ps.setInt(5, t.getMinIncrement());
            ps.setString(6, t.getCategory());
            ps.setInt(7, t.getStartPrice());
            ps.setInt(8, t.getSeller().getUserID());
            ps.setTimestamp(9, t.getAuctionStartDate());
            ps.setTimestamp(10, t.getAuctionEndDate());
            result = ps.executeUpdate();
            System.out.println("Item added successfully. Rows affected: " + result);
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
    public boolean update(Item t) {
        PreparedStatement ps = null;
        int result = 0;
        try {
            Connection con = DBService.openConnection();
            System.out.println("Connection opened successfully.");
            String update = "UPDATE auction.Item SET title=?, description=?, itemImage=?, Itemtate=?, itemCondition=?, minIncrement=?, category=?, startPrice=?, isSold=?, soldDate=?, sellerID=?, buyerID=? ,auctionStartDate=?, auctionEndDate=? WHERE itemID=?";
            ps = con.prepareStatement(update);
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setString(3, t.getItemImage());
            ps.setString(4, t.getItemState());
            ps.setString(5, t.getItemCondition());
            ps.setInt(6, t.getMinIncrement());
            ps.setString(7, t.getCategory());
            ps.setInt(8, t.getStartPrice());
            ps.setBoolean(9, t.isSold());
            ps.setTimestamp(10, t.getSoldDate() != null ? t.getSoldDate() : null);
            ps.setInt(11, t.getSeller().getUserID());
            ps.setInt(12, t.getBuyer() != null ? t.getBuyer().getUserID() : 0);
            ps.setInt(13, t.getItemID());
            ps.setTimestamp(14, t.getAuctionStartDate() != null ? t.getAuctionStartDate() : null);
            ps.setTimestamp(15, t.getAuctionEndDate() != null ? t.getAuctionEndDate() : null);
            result = ps.executeUpdate();
            System.out.println("Item updated successfully. Rows affected: " + result);
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
            System.out.println("Connection opened successfully.");
            String delete = "DELETE FROM auction.Item WHERE itemID=?";
            ps = con.prepareStatement(delete);
            ps.setInt(1, id);
            result = ps.executeUpdate();
            System.out.println("Item deleted successfully. Rows affected: " + result);
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
    public List<Item> getAll() {
        List<Item> Item = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            System.out.println("Connection opened successfully.");
            String query = "SELECT * FROM auction.Item";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setItemID(rs.getInt("itemID"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setItemImage(rs.getString("itemImage"));
                item.setItemState(rs.getString("itemState"));
                item.setItemCondition(rs.getString("itemCondition"));
                item.setMinIncrement(rs.getInt("minIncrement"));
                item.setCategory(rs.getString("category"));
                item.setStartPrice(rs.getInt("startPrice"));
                item.setSold(rs.getBoolean("isSold"));
                item.setRegisteredDate(rs.getTimestamp("registeredDate"));
                item.setSoldDate(rs.getTimestamp("soldDate") != null ? rs.getTimestamp("soldDate") : null);
                item.setAuctionStartDate(rs.getTimestamp("auctionStartDate") != null ? rs.getTimestamp("auctionStartDate") : null);
                item.setAuctionEndDate(rs.getTimestamp("auctionEndDate") != null ? rs.getTimestamp("auctionEndDate") : null);
                // Set seller and buyer information
                User seller = new User();
                seller.setUserID(rs.getInt("sellerID"));
                item.setSeller(seller);
                int buyerId = rs.getInt("buyerID");
                if (buyerId != 0) {
                    item.setBuyer(new UserDAO().get(buyerId));
                }
                Item.add(item);
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
        return Item;
    }

    @Override
    public Item get(int id) {
        Item item = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection con = DBService.openConnection();
            System.out.println("Connection opened successfully.");
            String query = "SELECT * FROM auction.Item WHERE itemID=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                item = new Item();
                item.setItemID(rs.getInt("itemID"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setItemImage(rs.getString("itemImage"));
                item.setItemState(rs.getString("itemState"));
                item.setItemCondition(rs.getString("itemCondition"));
                item.setMinIncrement(rs.getInt("minIncrement"));
                item.setCategory(rs.getString("category"));
                item.setStartPrice(rs.getInt("startPrice"));
                item.setSold(rs.getBoolean("isSold"));
                item.setRegisteredDate(rs.getTimestamp("registeredDate"));
                item.setSoldDate(rs.getTimestamp("soldDate") != null ? rs.getTimestamp("soldDate") : null);
                item.setAuctionStartDate(rs.getTimestamp("auctionStartDate") != null ? rs.getTimestamp("auctionStartDate") : null);
                item.setAuctionEndDate(rs.getTimestamp("auctionEndDate") != null ? rs.getTimestamp("auctionEndDate") : null);
                // Set seller and buyer information
                User seller = new User();
                seller.setUserID(rs.getInt("sellerID"));
                item.setSeller(seller);
                int buyerId = rs.getInt("buyerID");
                if (buyerId != 0) {
                    User buyer = new User();
                    buyer.setUserID(buyerId);
                    item.setBuyer(buyer);
                }
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
        return item;
    }

    public Integer changeState(Item it){
        Integer status;
        try{
            Connection con = DBService.openConnection();
            String command;
            if (it.getItemState().equals("rejected") || it.getItemState().equals("pending")){
                command = "approved";
            } else {
                command = "rejected";
            }
            String query = "Update Item SET itemState = ? where itemID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, command);
            ps.setInt(2, it.getItemID());
            status = ps.executeUpdate();
            con.close();
            ps.close();
            return status;
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public List<Item> getItembyName(String name){
        ItemDAO curr = new ItemDAO();
        List<Item>all = curr.getAll();
        List<Item>store = new ArrayList<>();

        for (Item it : all){
            if (it.getTitle().toLowerCase().equals(name.toLowerCase())){
                store.add(it);
            }
        }
        return store;

    }
}
